package com.bimaapp.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MysqlDatabase implements Serializable {

    private static MysqlDatabase database;

    private Connection connection;

    private MysqlDatabase() {
        try {
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/bimaapp");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
       
    }

    public static MysqlDatabase getInstance() throws SQLException{
        if (database == null)
            database = new MysqlDatabase();

        return database;

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
