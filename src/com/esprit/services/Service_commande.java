/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.commande;
import com.esprit.utils.X_change2_data_source;
import static java.lang.Character.getType;
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
public class Service_commande implements IService<commande>{
    private final Connection cnx = X_change2_data_source.getInstance().getCnx();

     @Override
    public void ajouter(commande c) {
        String req = "INSERT INTO commande(statut,id_depot,emiteur,type) VALUES(?, ?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, c.getStatut());
            pst.setInt(2, c.getId_depot());
            pst.setString(3, c.getEmiteur());
            pst.setString(4, c.getType());
            pst.executeUpdate();
            System.out.println("commande ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void modifier(commande c) {
        String req = "UPDATE  commande SET statut=?, id_depot= ? ,emiteur= ? , type=? WHERE id_commande=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, c.getId_commande());
            pst.setString(1, c.getStatut());
            pst.setInt(2, c.getId_depot());
            pst.setString(3, c.getEmiteur());
            pst.setString(4, c.getType());
            pst.executeUpdate();
            System.out.println("commande modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(commande c) {
        String req = "DELETE FROM commande WHERE id_commande=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, c.getId_commande());
            pst.executeUpdate();
            System.out.println("commande supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<commande> afficher() {
        List<commande> list = new ArrayList<>();
        
        String req = "SELECT * FROM commande";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new commande(result.getInt("id_commande"), result.getString("statut"), result.getInt("id_depot"),
                        result.getString("emiteur"), result.getString("type")));
            }
            System.out.println("commande récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
   public void afficherCommandesNonLivrees() {
    
    String req = "SELECT * FROM commande WHERE statut = ?";
    
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, "non_livre");
        ResultSet result = pst.executeQuery();
        System.out.println("les commandes non encore livrés sont :");
        while(result.next()) { 
            String type = result.getString("type");
            int id_depot = result.getInt("id_depot");
            String emiteur = result.getString("emiteur");
            System.out.println( " | ID dépôt : " + id_depot + " | Emetteur : " + emiteur+ " | type : " + type );
        }
            
        
        System.out.println("Commandes récupérées !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    
}
   
   public void afficherParType(String type) {
    String req = "SELECT statut, id_depot, emiteur FROM commande WHERE type=?";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, type);
        ResultSet rs = pst.executeQuery();
        System.out.println("les commande de type : " +type );
        while (rs.next()) {
            String statut = rs.getString("statut");
            int id_depot = rs.getInt("id_depot");
            String emiteur = rs.getString("emiteur");
            System.out.println("Statut : " + statut + " | ID dépôt : " + id_depot + " | Emetteur : " + emiteur);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
    
    }
    
    

