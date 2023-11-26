package com.bimaapp.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;

import com.bimaapp.app.model.Client;
import com.bimaapp.app.model.CoverDetail;
import com.bimaapp.app.model.Policy;
import com.bimaapp.app.model.User;
import com.bimaapp.database.helper.DbTable;
import com.bimaapp.database.helper.DbTableColumn;

@Singleton
@Startup
public class MysqlDatabase implements Serializable {

    // private static MysqlDatabase database;

    private static Connection connection;

    @PostConstruct
    private void init() {
        try {
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/bimaapp");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
       
    }

    // public static MysqlDatabase getInstance() throws SQLException{
    //     if (database == null)
    //         database = new MysqlDatabase();

    //     return database;

    // }

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private void updateSchema(){

        System.out.println("*************** updating schema database *************");

        try {
            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Client.class);
            entities.add(Policy.class);
            entities.add(CoverDetail.class);

            for (Class<?> clazz : entities) {
                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();

                sqlBuilder.append("create table if not exists ").append(dbTable.name()).append("(");
                for (Field field : clazz.getDeclaredFields()) {
                    if (!field.isAnnotationPresent(DbTableColumn.class))
                        continue;

                    DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                    sqlBuilder.append(dbTableColumn.name()).append(" ").append(dbTableColumn.definition()).append(",");
                }

                sqlBuilder.append(")");

                connection.prepareStatement(sqlBuilder.toString().replace(",)", ")")).executeUpdate();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public void saveOrUpdate(Object entity) {

        try {

            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbTableColumn.class))
                    continue;

                field.setAccessible(true);
                if (field.get(entity) == null)
                    continue;

                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(dbTableColumn.name()).append(",");
                paramPlaceHolderBuilder.append("?").append(",");
                parameters.add(field.get(entity));

            }

            String queryBuilder = "insert into " +
                dbTable.name() +
                "(" +
                columnBuilder +
                ")" +
                " values(" +
                paramPlaceHolderBuilder +
                ")";

            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query: " + query);

            PreparedStatement sqlStmt = connection.prepareStatement(query);

            int paramIdx = 1;
            for (Object param : parameters) {
                if (param.getClass().isAssignableFrom(BigDecimal.class))
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                else if (param instanceof Enum)
                    sqlStmt.setString(paramIdx++, ((Enum<?>) param).name());
                else if (param.getClass().isAssignableFrom(Long.class))
                    sqlStmt.setLong(paramIdx++, (long) param);
                else if (param instanceof Class<?>){
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("***********"+param + "****************");
                    sqlStmt.setLong(paramIdx++, ((Class<?>) param).getField("id").getLong(((Class<?>) param)));
                }
                else if (param.getClass().isAssignableFrom(Date.class))
                    sqlStmt.setDate(paramIdx++, new java.sql.Date(((Date) param).getTime()));
                else
                    sqlStmt.setString(paramIdx++, (String) param);
            }

            sqlStmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> fetch(T entity) {

        List<T> resultList = new ArrayList<>();

        try {
            Class<?> clazz = entity.getClass();

            if (!clazz.isAnnotationPresent(DbTable.class))
                return resultList;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            String tableAlias = dbTable.name().charAt(0) + "_e_";
            System.out.println("table alias " + tableAlias);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            List<Object> whereParams = new ArrayList<>();

            DateConverter converter = new DateConverter( null );
            converter.setPattern("yyyy-mm-dd");
            ConvertUtils.register(converter, Date.class);

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbTableColumn.class))
                    continue;

                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(tableAlias).append(".").append(dbTableColumn.name()).append(",");

                field.setAccessible(true);
                if (field.get(entity) != null) {
                    paramPlaceHolderBuilder
                        .append(whereParams.isEmpty()?"":" and ")
                        .append(tableAlias).append(".").append(dbTableColumn.name()).append("=?");
                    whereParams.add(field.get(entity));
                }

            }

            String queryBuilder =
                "select " +
                columnBuilder +
                " from " +
                dbTable.name() + " " + tableAlias +
                (whereParams.isEmpty() && StringUtils.isBlank(paramPlaceHolderBuilder) ? "" : " where " + paramPlaceHolderBuilder);

            String query = queryBuilder.replace(", from", " from");
            System.out.println("Query: " + query);

            PreparedStatement sqlStmt = connection.prepareStatement(query);

            int paramIdx = 1;
            for (Object whereParam : whereParams) {
                if (whereParam.getClass().isAssignableFrom(BigDecimal.class))
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) whereParam);
                else if (whereParam.getClass().isAssignableFrom(Long.class))
                    sqlStmt.setLong(paramIdx++, (long) whereParam);
                else
                    sqlStmt.setString(paramIdx++, (String) whereParam);
            }

            ResultSet resultSet = sqlStmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int resultSetMetaDataCnt = resultSetMetaData.getColumnCount();

            while (resultSet.next()){
                T bean = (T) entity.getClass().getDeclaredConstructor().newInstance();

                for (int idx = 1; idx <= resultSetMetaDataCnt; idx++ ) {
                    String colName = resultSetMetaData.getColumnName(idx);

                    for (Field field : fields) {
                        if (!field.isAnnotationPresent(DbTableColumn.class))
                            continue;

                        DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                        field.setAccessible(true);
                        if (dbTableColumn.name().equals(colName)) {
                            BeanUtils.setProperty(bean, field.getName(), resultSet.getObject(idx));
                            break;
                        }
                    }

                }

                resultList.add(bean);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return resultList;

    }

    @PreDestroy
    public void closeConnection(){
        try {
            if (connection != null)
                connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
