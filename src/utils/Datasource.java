/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Maha Maatoug
 */
public class Datasource {

    /**
     * @param args the command line arguments
     */
    private Connection cnx;
    
    private static Datasource instance;
    
    private final String URL = "jdbc:mysql://localhost:3306/projet";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Datasource() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connecting !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Datasource getInstance() {
        if(instance == null) {
            instance = new Datasource();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}


