/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.produit_echange;
import com.esprit.entities.profil_livreur;
import com.esprit.utils.X_change2_data_source;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author wissem
 */
public class Service_profil_livreur implements IService<profil_livreur>{
    private final Connection cnx = X_change2_data_source.getInstance().getCnx();

    @Override
    public void ajouter(profil_livreur pl) {
         String req = "INSERT INTO profil_livreur(secteur ,volume ,moy_livraison) VALUES(?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, pl.getSecteur());
            pst.setString(2, pl.getVolume());
            pst.setString(3, pl.getMoy_livraison());
            pst.executeUpdate();
            System.out.println("profil livreur  ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(profil_livreur pl) {
       String req = "UPDATE  profil_livreur SET secteur=?, volume= ? , moy_livraison=? WHERE id_livreur=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, pl.getId_livreur());
            pst.setString(1, pl.getSecteur());
            pst.setString(2, pl.getVolume());
            pst.setString(3, pl.getMoy_livraison());
            pst.executeUpdate();
            System.out.println("profil livreur modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(profil_livreur pl) {
        String req = "DELETE FROM profil_livreur   WHERE id_livreur=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, pl.getId_livreur());
            pst.executeUpdate();
            System.out.println("profil livreur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<profil_livreur> afficher() {
        
        List<profil_livreur> list = new ArrayList<>();
        String req = "SELECT * FROM profil_livreur";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new profil_livreur(result.getInt("id_livreur"), result.getString("secteur"), result.getString("volume"),
                         result.getString("moy_livraison")));
            }
            System.out.println("profil livreur  récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
   /*public int filtrerParSecteur(String secteur) {
    int count = 0;
    String req = "SELECT COUNT(*) FROM profil_livreur WHERE secteur = ?";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, secteur);
        ResultSet result = pst.executeQuery();
        while(result.next()) {
            count = result.getInt(1);
        }
        System.out.println(count + " livreur(s) trouvé(s) dans le secteur " + secteur + ".");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return count;
}
   
   public profil_livreur chercher(int id_livreur) {
    String req = "SELECT * FROM profil_livreur WHERE id_livreur=?";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id_livreur);
        ResultSet result = pst.executeQuery();
        if (result.next()) {
            String secteur = result.getString("secteur");
            String volume = result.getString("volume");
            String moy_livraison = result.getString("moy_livraison");
            return new profil_livreur(secteur, volume, moy_livraison);
        }
        System.out.println("profil livreur non trouvé !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return null;
}*/
    
  

    public int countLivreurBySecteur(String secteur) {
    List<profil_livreur> list = afficher();
    return (int) list.stream()
        .filter(pl -> pl.getSecteur().equalsIgnoreCase(secteur))
        .count();
}
    public Optional<profil_livreur> rechercherParId(int id_livreur) {
    List<profil_livreur> list = afficher();
    return list.stream()
        .filter(pl -> pl.getId_livreur() == id_livreur)
        .findFirst();
    
}
    
    
}
