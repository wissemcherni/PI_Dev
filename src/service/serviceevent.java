/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package service;

import entities.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Datasource;
/**
 *
 * @author Maha Maatoug
 */
public class serviceevent implements IService<event> {
    
    private  Connection cnx = Datasource.getInstance().getCnx();

    @Override
    public void ajouter(event e) {
         String req = "INSERT INTO event(Localisation, Description, prix) VALUES(?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, e.getLocalisation());
            pst.setString(2, e.getDescription());
              pst.setInt(3, e.getPrix());
            pst.executeUpdate();
            System.out.println("event ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(event e) {
        String req = "UPDATE  event SET LocaliSation='"+e.getLocalisation()+"', Description= '"+e.getDescription()+"' WHERE id="+e.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("event modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(event e) {
        String req = "DELETE FROM event WHERE id="+e.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<event> afficher() {
        List<event> list = new ArrayList<>();
        
        String req = "SELECT * FROM event";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new event(result.getInt("id"), result.getString("Localisation"), result.getString("Description"),result.getInt("prix")));
            }
            System.out.println("events récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}

