/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.livraison;
import com.esprit.entities.profil_livreur;
import com.esprit.utils.X_change2_data_source;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wissem
 */
public class Service_livraison implements IService<livraison>{
   private final Connection cnx = X_change2_data_source.getInstance().getCnx(); 

    @Override
    public void ajouter(livraison l) {
        String req = "INSERT INTO livraison(id_commande ,id_livreur,date) VALUES(?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, l.getId_commande());
            pst.setInt(2, l.getId_livreur());
            pst.setDate(3, l.getDATE());
            pst.executeUpdate();
            System.out.println("livraison  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(livraison l) {
        String req = "UPDATE  livraison SET id_commande=?, id_livreur= ? , date=? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, l.getId());
            pst.setInt(1, l.getId_commande());
            pst.setInt(2, l.getId_livreur());
            pst.setDate(3, l.getDATE());
            pst.executeUpdate();
            System.out.println("livraison modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(livraison l) {
        String req = "DELETE FROM livraison  WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, l.getId());
            pst.executeUpdate();
            System.out.println("livraison supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<livraison> afficher() {
        List<livraison> list = new ArrayList<>();
        
        String req = "SELECT * FROM livreur";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new livraison(result.getInt("id"),result.getInt("id_commande"), result.getInt("id_livreur"), result.getDate("date")));
            }
            System.out.println("livraison  récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
    
