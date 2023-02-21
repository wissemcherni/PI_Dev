/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wissem
 */
public class X_change2_data_source {
     private Connection cnx;
    
    private static X_change2_data_source instance;
    
    private final String URL = "jdbc:mysql://localhost:3306/X-change2";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private X_change2_data_source() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connecting !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static X_change2_data_source getInstance() {
        if(instance == null) {
            instance = new X_change2_data_source();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
