/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entities.Boutique;
import entities.Cathegorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import services.ServiceBoutique;
import services.ServiceCathegorie;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ChoixCategorieController implements Initializable {

    @FXML
    private Button fragile;
    @FXML
    private Button volumineux;
    @FXML
    private Button alimentation;
    @FXML
    private Button simple;
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
    private void fragile(ActionEvent event) throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        fragile.getScene().setRoot(root);
          AfficherCategorieController dpc = loader.getController();
        
      ServiceCathegorie ab = new ServiceCathegorie();
       Cathegorie b =ab.rechercher("fragile");
        dpc.setAftype(b.getType());
        
        dpc.setAfdescription(b.getDescriptionc());
       
         dpc.setAftype("fragile");
        
          
 
        
    }

    @FXML
    private void volumineux(ActionEvent event) throws IOException {
   
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        volumineux.getScene().setRoot(root);
          AfficherCategorieController dpc = loader.getController();
        
      ServiceCathegorie ab = new ServiceCathegorie();
       Cathegorie b =ab.rechercher("volumineux");
        dpc.setAftype(b.getType());
        
        dpc.setAfdescription(b.getDescriptionc());
       
         dpc.setAftype("volumineux");
        
    }
    

    @FXML
    private void alimentation(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        alimentation.getScene().setRoot(root);
      AfficherCategorieController dpc = loader.getController();
        
       ServiceCathegorie ab = new ServiceCathegorie();
       Cathegorie b =ab.rechercher("alimentation");
        dpc.setAftype(b.getType());
        
        dpc.setAfdescription(b.getDescriptionc());
       
         dpc.setAftype("alimentation");
        
        
    }
       
//bc.setId(tfid.getText());
    
    @FXML
    private void simple(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        simple.getScene().setRoot(root);
          AfficherCategorieController dpc = loader.getController();
      ServiceCathegorie ab = new ServiceCathegorie();
       Cathegorie b =ab.rechercher("simple");
        dpc.setAftype(b.getType());
        
        dpc.setAfdescription(b.getDescriptionc());
       
         dpc.setAftype("simple");
        
        
          
        
    }


    @FXML
    private void retourbienvenue(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Bienvenue.fxml"));
        Parent root = loader.load();
        simple.getScene().setRoot(root);
        BienvenueController dpc = loader.getController();
       
        
    }

    @FXML
    private void ajoutercategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutCategorie.fxml"));
        Parent root = loader.load();
        simple.getScene().setRoot(root);
       AjoutCategorieController dpc = loader.getController();
       
    }

    private void cherchercategorie(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCathegorie.fxml"));
        Parent root = loader.load();
        simple.getScene().setRoot(root);
       AjoutCategorieController dpc = loader.getController();
    }

    @FXML
    private void autre(ActionEvent event) throws IOException {  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        simple.getScene().setRoot(root);
       AfficherCategorieController dpc = loader.getController();
        
    }

    @FXML
    private void simple(MouseEvent event) {
    }
}
    



  
    
