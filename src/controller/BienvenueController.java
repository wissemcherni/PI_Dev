/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BienvenueController implements Initializable {

    @FXML
    private Button boutique;
    @FXML
    private Button categorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void boutique(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChoixBoutique.fxml"));
        Parent root = loader.load();
        boutique.getScene().setRoot(root);
        
       ChoixBoutiqueController dpc = loader.getController();
        
    }

    @FXML
    private void categorie(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ChoixCategorie.fxml"));
        Parent root = loader.load();
        boutique.getScene().setRoot(root);
        
       ChoixCategorieController dpc = loader.getController();
        
    }
    
}
