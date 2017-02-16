/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Manasi Laddha
 */
public class DAO {
    
    public static Connection establishedConnectionJDBC(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch(ClassNotFoundException e){
            System.err.println("You should add your JDBC jar.");
            e.getMessage();
          
        }
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb","student", "p@ssw0rd");
            
        }
        catch(SQLException e){
            //Logger.getLogger(LoginController.class.getName()).getHandlers();
            e.getMessage();
           
        }
        
        if(con !=null){
            System.out.println("Connection Successful");
        }
            return con;
    }
    
}
