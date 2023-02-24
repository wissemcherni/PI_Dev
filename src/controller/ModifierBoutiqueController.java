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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import services.ServiceBoutique;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ModifierBoutiqueController implements Initializable {

    @FXML
    private TextField localisation;
    @FXML
    private TextField surface;
    @FXML
    private TextField description;
    @FXML
    private TextField etat;
    @FXML
    private TextField secteur;
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    public void setLocalisation(TextField localisation) {
        this.localisation = localisation;
    }

    public void setSurface(TextField surface) {
        this.surface = surface;
    }

    public void setDescription(TextField description) {
        this.description = description;
    }

    public void setEtat(TextField etat) {
        this.etat = etat;
    }

    public void setSecteur(TextField secteur) {
        this.secteur = secteur;
    }

    public void setId(String id) {
        this.id.setText(id);
    }

   
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        Boutique b = new Boutique(Integer.valueOf(id.getText()),Integer.valueOf(surface.getText()),localisation.getText(),secteur.getText(),etat.getText(),description.getText());
    ServiceBoutique sb = new ServiceBoutique();
    sb.modifier(b);
     FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        localisation.getScene().setRoot(root);
        
    
    }
    
}
