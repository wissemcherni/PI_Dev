/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package service;
import entities.achatticket;

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
public class serviceachatticket  implements IService<achatticket> {
 private  Connection cnx = Datasource.getInstance().getCnx();

    @Override
    public void ajouter(achatticket a) {
         String req = "INSERT INTO achatticket(id_participant,nb_ticket,prix) VALUES(?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, 1);
              pst.setInt(2, a.getNb_ticket());
              
               pst.setInt(3, a.getPrix());
              
            pst.executeUpdate();
            System.out.println("achat ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(achatticket a) {
        String req = "UPDATE  achatticket SET  nb_ticket= '"+a.getNb_ticket()+",prix='"+a.getPrix()+"' WHERE id="+a.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("achatticket modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(achatticket a) {
        String req = "DELETE FROM achatticket WHERE id="+a.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("achatticket supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<achatticket> afficher() {
        List<achatticket> list = new ArrayList<>();
        
        String req = "SELECT * FROM achatticket";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new achatticket(result.getInt("id"), result.getInt("id_participant"), result.getInt("nb_ticket"),result.getInt("prix")));
            }
            System.out.println("achatticket récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
