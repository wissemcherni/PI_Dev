/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.commande;
import com.esprit.utils.X_change2_data_source;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Character.getType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
   
   public void imprimer(commande c) throws BadElementException, IOException, DocumentException{
        //commande c =liste_commandes.getSelectionModel().getSelectedItem();
        //Service_commande c = new Service_commande();
        
        
        
        //File folder1 = new File("documents"); 
        File folder = new File("documents"); 
        if(!folder.exists()){
            folder.mkdir();
        }
        String nom_fichier = "documents/info.pdf"; 
        
       
        
        File imgUser = new File("images/user.jpg");
        //File imgUser = new File("images/user.jpg"); 
        String chemin = imgUser.getAbsolutePath(); 
        
        
        LineSeparator ls = new LineSeparator(); 
        ls.setLineColor(BaseColor.YELLOW);
        
        Image image = null; 
         
        Document document = new Document(); 
        
   
        
       
            
            PdfWriter.getInstance(document, new FileOutputStream(nom_fichier));
            document.open(); 
            document.addTitle("bon de commande "); 
            document.addAuthor("author"); 
            Paragraph preface = new Paragraph(); 
            Paragraph titre = new Paragraph("bon de commande");
           
            
            preface.add(titre);
            preface.add(new Paragraph("Description of user : "));
            preface.add(new Paragraph(c.getId_commande()));
            preface.add(new Paragraph(c.getId_depot()));
            
            preface.add(new Paragraph(c.getStatut()));
           
            preface.add(new Paragraph(c.getEmiteur()));
            preface.add(new Paragraph(c.getType()));
            
            document.add(preface); 

            document.close(); 
            
          
            
            int valid = JOptionPane.showOptionDialog(
                null, 
                new Object[]{
                    "Voulez vous directement ouvrir le fichier ?",
                        
                        "Cliquez OUI pour ouvrir ou NON pour annuler",
                },
                "ouverture du fichier"+nom_fichier, 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, 
                null, null, "OK"
               
            );
            if(valid == JOptionPane.OK_OPTION){
                File ouvrir = new File(nom_fichier); 
                Desktop desk = Desktop.getDesktop();
                desk.open(ouvrir);
            }
           
        } 
    
    
    }
    
    

