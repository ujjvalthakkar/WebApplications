/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ujjva
 */
public class LoginDAO {

    public static boolean authUser(String username, String pwd) throws Exception {
        Connection con = DAO.establishedConnectionJDBC();
        PreparedStatement st;
        String query = "select * from userstable where UserName = ? and UserPassword= ?";
        //st = connection.createStatement();
        st = con.prepareStatement(query);
        st.setString(1, username);
        st.setString(2, pwd);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;
    }
}