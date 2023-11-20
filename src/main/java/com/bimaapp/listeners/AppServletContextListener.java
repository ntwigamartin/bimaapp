package com.bimaapp.listeners;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bimaapp.database.Database;
import com.bimaapp.database.MysqlDatabase;
import com.bimaapp.database.helper.DbTable;
import com.bimaapp.database.helper.DbTableColumn;
import com.bimaapp.enums.PolicyType;
import com.bimaapp.enums.UserRole;
import com.bimaapp.model.Client;
import com.bimaapp.model.Policy;
import com.bimaapp.model.User;

@WebListener
public class AppServletContextListener implements ServletContextListener{
    
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*****************application initialized *******************");
        try {
            Connection connection = MysqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Client.class);
            entities.add(Policy.class);

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
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            MysqlDatabase database = MysqlDatabase.getInstance();

            if (database.getConnection() != null){
                database.getConnection().close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
