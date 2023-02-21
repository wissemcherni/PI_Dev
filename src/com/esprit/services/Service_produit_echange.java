/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;


import com.esprit.entities.produit_echange;
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
public class Service_produit_echange implements IService<produit_echange>{
private final Connection cnx = X_change2_data_source.getInstance().getCnx();
   
     
    @Override
       public void ajouter(produit_echange pe) {
        String req = "INSERT INTO produit_echange(id_produit,id_commande,type) VALUES(?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, pe.getId_produit());
            pst.setInt(2, pe.getId_commande());
            pst.setString(3, pe.getType());
            pst.executeUpdate();
            System.out.println("produit echange  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(produit_echange pe) {
        String req = "UPDATE  produit_echange SET id_produit=?, id_commande= ? , type=? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, pe.getId());
            pst.setInt(1, pe.getId_produit());
            pst.setInt(2, pe.getId_commande());
            pst.setString(3, pe.getType());
            pst.executeUpdate();
            System.out.println("produit echange modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(produit_echange pe) {
         String req = "DELETE FROM produit_echange  WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, pe.getId());
            pst.executeUpdate();
            System.out.println("produit echange supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<produit_echange> afficher() {
         List<produit_echange> list = new ArrayList<>();
        
        String req = "SELECT * FROM produit_echange";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new produit_echange(result.getInt("id"), result.getInt("id_produit"), result.getInt("id_commande"),
                         result.getString("type")));
            }
            System.out.println("produit echange  récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    }

    
    

