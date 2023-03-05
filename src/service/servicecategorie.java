/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package service;
import entities.categorie;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.Datasource;
/**
 *
 * @author Maha Maatoug
 */
public class servicecategorie  implements IService<categorie> {

    /**
     * @param args the command line arguments
     */
    private   Connection cnx = Datasource.getInstance().getCnx();

    //@Override
    @Override
    public void ajouter(categorie c) {
         String req = "INSERT INTO categorie(id, type) VALUES(?,  ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, c.getId());
            pst.setString(2, c.getType());
            
             
            pst.executeUpdate();
            System.out.println("categorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 //   @Override
    @Override
    public void modifier(categorie c) {
        String req = "UPDATE  categorie SET type='"+c.getType()+"' WHERE id="+c.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("categorie modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //@Override
    @Override
    public void supprimer(categorie c) {
        String req = "DELETE FROM categorie WHERE id="+c.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("categorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // @Override
    @Override
    public List<categorie> afficher() {
        List<categorie> list = new ArrayList<>();
        
        String req = "SELECT * FROM categorie";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new categorie(result.getInt("id"), result.getString("type")));
            }
            System.out.println("categorie récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
