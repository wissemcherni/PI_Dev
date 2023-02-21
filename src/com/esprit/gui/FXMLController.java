/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author wissem
 */
public class FXMLController implements Initializable {

    @FXML
    private AnchorPane menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pageCommande(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Commande_View.fxml"));
            AnchorPane component = loader.load();
            menu.getChildren().setAll(component);
        }catch(Exception ignored){
            
        }
    }

    @FXML
    private void pageLivraison(ActionEvent event) {
    }

    @FXML
    private void pageProduit_Echange(ActionEvent event) {
    }

    @FXML
    private void pageProfil_Livreur(ActionEvent event) {
    }
    
}
