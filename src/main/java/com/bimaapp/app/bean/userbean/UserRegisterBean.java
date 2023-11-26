package com.bimaapp.app.bean.userbean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.bimaapp.app.model.User;
import com.bimaapp.database.MysqlDatabase;

@Stateless
@Remote
public class UserRegisterBean implements UserRegisterBeanI, Serializable{


    public boolean createUser(User user, String confirmPasswordParam) throws SQLException {
                
        if (user.getPassword().equals(confirmPasswordParam)) {

             PreparedStatement sqlStmt = MysqlDatabase.getConnection()
                .prepareStatement("insert into users(username,password,userrole) values(?,?,?)");

            sqlStmt.setString(1, user.getUsername());
            sqlStmt.setString(2, user.getPassword());
            sqlStmt.setString(3, "normal");

            sqlStmt.executeUpdate();

            return true;
            
        }else {
            return false;
        }
    }
}
