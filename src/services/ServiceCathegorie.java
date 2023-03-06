/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Boutique;
import entities.Cathegorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**descriptionc 
 *
 * @author userp.getDescriptionc
 */
public class ServiceCathegorie implements IService<Cathegorie> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Cathegorie p) {
        String req = "INSERT INTO Cathegorie(type,descriptionc) VALUES('"+p.getType()+"','"+p.getDescriptionc()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Cathegorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Cathegorie p) {
        String req = "UPDATE  Cathegorie SET type= '"+p.getType()+"', descriptionc='"+p.getDescriptionc()+"' WHERE type= '"+p.getType()+"'";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Cathegorie modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void supprimer(String p) {
         String req = "DELETE FROM Cathegorie WHERE type= '"+p+"'";
       // String req = "DELETE FROM Cathegorie WHERE type= '"+p.getType()+"'";
       
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Cathegorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Cathegorie> afficher() {
        List<Cathegorie> list = new ArrayList<>();
        
        String req = "SELECT * FROM Cathegorie";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
               list.add(new Cathegorie(result.getString("type"), result.getString("descriptionc")));
            
            }
            System.out.println("Cathegorie récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    public boolean existeDeja(String type) {
    // établir une connexion à la base de données
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean existe = false;
    try {
        // préparer la requête SQL pour chercher un enregistrement avec le même type
        ps = cnx.prepareStatement("SELECT * FROM cathegorie WHERE type = ?");
        ps.setString(1, type);
        // exécuter la requête et vérifier s'il y a des résultats
        rs = ps.executeQuery();
        if (rs.next()) {
            existe = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // fermer la connexion et les ressources JDBC
        //if (rs != null) try { rs.close(); } catch (SQLException e) {}
        //if (ps != null) try { ps.close(); } catch (SQLException e) {}
      //  if (cnx != null) try { cnx.close(); } catch (SQLException e) {}
    }
    return existe;
}


    @Override
    public Cathegorie rechercher(String p) {
         Cathegorie b=null ;
    
        String req = "SELECT * FROM Cathegorie WHERE `type` ='"+ p+"' ;";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                b=(new Cathegorie(result.getString("type"), result.getString("descriptionc")));
               
            }
            System.out.println("Cathegorie récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return b;
    }

   
   
  
}

    
    
    
