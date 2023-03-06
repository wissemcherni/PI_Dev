/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entities.Boutique;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import services.ServiceBoutique;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ChoixBoutiqueController implements Initializable {

    @FXML
    private Button tunis;
    @FXML
    private Button beja;
    @FXML
    private Button sfax;
    @FXML
    private Button kairouan;
    @FXML
    private Button retourbienvenue;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tunis(ActionEvent event) throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        tunis.getScene().setRoot(root);
          AfficherBoutiqueController dpc = loader.getController();
        
      ServiceBoutique ab = new ServiceBoutique();
       Boutique b =ab.rechercher("tunis");
        dpc.setLbLocalisation(b.getLocalisation());
        dpc.setLbSecteur(b.getSecteur());
        dpc.setLbEtat(b.getEtat());
        dpc.setLbDescription(b.getDescriptionb());
        dpc.setLbSurface(Integer.toString(b.getSurface()));
         dpc.setLbliste("BOUTIQUE TUNIS");
        
          
 
        
    }

    @FXML
    private void beja(ActionEvent event) throws IOException {
   
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        beja.getScene().setRoot(root);
          AfficherBoutiqueController dpc = loader.getController();
        
      ServiceBoutique ab = new ServiceBoutique();
       Boutique b =ab.rechercher("beja");
        dpc.setLbLocalisation(b.getLocalisation());
        dpc.setLbSecteur(b.getSecteur());
        dpc.setLbEtat(b.getEtat());
        dpc.setLbDescription(b.getDescriptionb());
        dpc.setLbSurface(Integer.toString(b.getSurface()));
         dpc.setLbliste("BOUTIQUE BEJA");
}
        
    

    @FXML
    private void sfax(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        tunis.getScene().setRoot(root);
      AfficherBoutiqueController dpc = loader.getController();
        
      ServiceBoutique ab = new ServiceBoutique();
Boutique b =ab.rechercher("sfax");
        dpc.setLbLocalisation(b.getLocalisation());
        dpc.setLbSecteur(b.getSecteur());
        dpc.setLbEtat(b.getEtat());
        dpc.setLbDescription(b.getDescriptionb());
        dpc.setLbSurface(Integer.toString(b.getSurface()));
         dpc.setLbliste("BOUTIQUE SFAX");
        
          }
       
//bc.setId(tfid.getText());
    
    @FXML
    private void kairouan(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        tunis.getScene().setRoot(root);
          AfficherBoutiqueController dpc = loader.getController();
        
      ServiceBoutique ab = new ServiceBoutique();
Boutique b =ab.rechercher("kairouan");
        dpc.setLbLocalisation(b.getLocalisation());
        dpc.setLbSecteur(b.getSecteur());
        dpc.setLbEtat(b.getEtat());
        dpc.setLbDescription(b.getDescriptionb());
        dpc.setLbSurface(Integer.toString(b.getSurface()));
         dpc.setLbliste("BOUTIQUE KAIROUAN");
        
          
        
    }


    @FXML
    private void retourbienvenue(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Bienvenue.fxml"));
        Parent root = loader.load();
        tunis.getScene().setRoot(root);
        BienvenueController dpc = loader.getController();
       
        
    }

    @FXML
    private void ajouterboutique(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutBoutique.fxml"));
        Parent root = loader.load();
        tunis.getScene().setRoot(root);
        FXMLController dpc = loader.getController();
       
    }
    
}
