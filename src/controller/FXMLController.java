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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.ServiceBoutique;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLController implements Initializable {

  
    private TextField tflocalisation;
    private TextField tfsurface;
    private TextField tfdescription;
    private RadioButton tfetat;
    private TextField tfsecteur;
    @FXML
    private Label lbType;
    @FXML
    private TextField tfid;
    @FXML
    private TextArea lbDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void ajouter(ActionEvent event) throws IOException {
        ServiceBoutique sp = new ServiceBoutique();
        sp.ajouter(new Boutique(tfsurface.getInteger(),tflocalisation.getText(),tfsecteur.getText(),tfetat.getText() ,tfdescription.getText() ));
        JOptionPane.showMessageDialog(null, "Boutique ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        tfsecteur.getScene().setRoot(root);
        
        AfficherBoutiqueController dpc = loader.getController();
        dpc.setLbLocalisation(tflocalisation.getText());
        dpc.setLbSecteur(tfsecteur.getText());
        dpc.setLbEtat(tfetat.getText());
        dpc.setLbDescription(tfdescription.getText());
        
    }

    @FXML
    private void afficherCathegorie(ActionEvent event) {
    }
    }
    
