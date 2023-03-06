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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.SaisieControl;
import services.ServiceBoutique;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLController implements Initializable {

  
    @FXML
    private TextField tflocalisation;
    @FXML
    private TextField tfsurface;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfetat;
    @FXML
    private TextField tfsecteur;
  
    private TextField tfid;
    private TextArea lbDescription;

    @Override
    public String toString() {
        return "FXMLController{" + "tflocalisation=" + tflocalisation + ", tfsurface=" + tfsurface + ", tfdescription=" + tfdescription + ", tfetat=" + tfetat + ", tfsecteur=" + tfsecteur + ", tfid=" + tfid + ", lbDescription=" + lbDescription + '}';
    }

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
       
        
        if (ServiceBoutique.estUniquementDesLettres(tfsecteur.getText())) {
    System.out.println("Le secteur de la boutique est en lettres.");
} else {
    System.out.println("Le secteur de la boutique n'est pas en lettres.");
}
        if (!SaisieControl.estNonVide(tfsecteur, "Le secteur est obligatoire")) {
            return;
        }
        
        if (!SaisieControl.estNonVide(tfsurface, "La surface est obligatoire")) {
            return;
        }
      
        
        if (!SaisieControl.estLongueurValide(tfdescription, "Le prénom doit faire moins de 50 caractères", 50)) {
            return;
        }
       /* String secteur = tfsecteur.getText();
        
        if (!SaisieControl.verifierUnicite(secteur)) {
            //System.out.println("Cette valeur existe déjà dans la base de données.");
            return;
            // Ajouter la valeur à la base de données
        } 

        /*
        ServiceBoutique ab = new ServiceBoutique();
Boutique b =ab.rechercher(tfsecteur.getText());
        if (!SaisieControl.estUnique(tfsecteur, "Le secteur existe déjà", b.getSecteur())) {
            return;
        }

        */
        ServiceBoutique sp = new ServiceBoutique();
        String type = tfsecteur.getText();
    if (sp.existeDeja(type)) {
        JOptionPane.showMessageDialog(null, "Boutique avec le même type existe déjà !");
        return;
    }
 

        sp.ajouter(new Boutique(Integer.valueOf(tfsurface.getText()),tflocalisation.getText(),tfsecteur.getText(),tfetat.getText() ,tfdescription.getText() ));
        JOptionPane.showMessageDialog(null, "Boutique ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        tfsecteur.getScene().setRoot(root);
        
        AfficherBoutiqueController dpc = loader.getController();
        
        dpc.setLbLocalisation(tflocalisation.getText());
        dpc.setLbSecteur(tfsecteur.getText());
  
        dpc.setLbEtat(tfetat.getText());
        dpc.setLbDescription(tfdescription.getText());
        dpc.setLbSurface(tfsurface.getText());
        
    }


    }
    
