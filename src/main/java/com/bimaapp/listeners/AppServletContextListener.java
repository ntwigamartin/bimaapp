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

        Database db = Database.getDbInstance();
       

        db.getClients().add(new Client("27835782", "Jane Doe", "0712011000", "jane@gmail.com", "nairobi"));
        db.getClients().add(new Client("27835783", "John Doe", "0712011233", "john@gmail.com", "Thika"));
        db.getClients().add(new Client("27835784", "Peter Doe", "0712011322", "peter@gmail.com", "Nakuru"));
        db.getClients().add(new Client("27835785", "Willy Doe", "0712011499", "willy@gmail.com", "Mombasa"));
        db.getClients().add(new Client("27835786", "Jenn Doe", "0712011755", "jenn@gmail.com", "Kisumu"));


        db.getPolicies().add(new Policy(LocalDate.now().toString(), LocalDate.now().plusYears(1).toString(), "1001",
         PolicyType.PRIVATE, db.getClients().get(0)));
        db.getPolicies().add(new Policy(LocalDate.now().toString(), LocalDate.now().plusYears(1).toString(), "1002",
         PolicyType.PRIVATE, db.getClients().get(1)));
        db.getPolicies().add(new Policy(LocalDate.now().toString(), LocalDate.now().plusYears(1).toString(), "1003",
         PolicyType.PRIVATE, db.getClients().get(2)));


        try {
            Connection connection = MysqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Client.class);

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
