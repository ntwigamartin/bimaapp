package com.bimaapp.app.bean.userbean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.bimaapp.app.model.User;
import com.bimaapp.database.MysqlDatabase;

@Stateless
@Remote
public class LoginBean implements LoginBeanI, Serializable {

    
    public boolean authenticate(User loginUser) throws SQLException{
  
        PreparedStatement sqlStmt = MysqlDatabase.getConnection()
            .prepareStatement("select * from users where username=? and password=? limit 1");
        sqlStmt.setString(1, loginUser.getUsername());
        sqlStmt.setString(2, loginUser.getPassword());

        ResultSet result = sqlStmt.executeQuery();

        return result.next();
    }

}
