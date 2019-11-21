/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jojok
 */
public class Database {
     private Statement statement = null;
     private Connection dbConnection;
     
     public Connection ConnectToDatabase()throws SQLException,ClassNotFoundException{
        try{
            String url = "jdbc:mysql://localhost/";
            String databaseName = "lp2";
            String driver = "com.mysql.jdbc.Driver";
            String username = "root";
            String password = "";
            Class.forName(driver);
            dbConnection = (Connection)DriverManager.getConnection(url+databaseName,username,password);
            return dbConnection;
        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
