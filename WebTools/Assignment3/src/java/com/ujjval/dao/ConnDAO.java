/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjval.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.ujjval.constants.Constants;
/**
 *
 * @author ujjva
 */
public class ConnDAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con = null;
        Class.forName(Constants.driver);
        con = DriverManager.getConnection(Constants.url,Constants.user,Constants.pass);
       return con; 
    }
}
