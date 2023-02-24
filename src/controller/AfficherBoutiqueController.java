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
import javafx.scene.control.TextField;
import services.ServiceBoutique;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherBoutiqueController implements Initializable {

    @FXML
    private Label lbLocalisation;
    @FXML
    private Label lbSecteur;
    @FXML
    private Label lbSurface;
    @FXML
    private Label lbEtat;
    @FXML
    private Label lbDescription;
    @FXML
    private TextField tfid;

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setLbLocalisation(String localisation) {
        this.lbLocalisation.setText(localisation);
    }
    
     public void setLbSurface(String surface) {
        this.lbSurface.setText(surface);
    }
   public void setLbEtat(String etat) {
        this.lbEtat.setText(etat);
    }
    public void setLbDescription(String description) {
        this.lbDescription.setText(description);
    }

     public void setLbSecteur(String secteur) {
        this.lbSecteur.setText(secteur);
    }

      


   

    @FXML
    private void afficher(ActionEvent event) {
ServiceBoutique ab = new ServiceBoutique();
Boutique b =ab.rechercher(Integer.valueOf(tfid.getText()));
setLbLocalisation(b.getLocalisation());
        setLbSecteur(b.getSecteur());
       setLbEtat(b.getEtat());
        setLbDescription(b.getDescriptionb());
setLbSurface(Integer.toString(b.getSurface()));
    
}
@FXML
 public void supprimer(ActionEvent event) {
     
     ServiceBoutique ab = new ServiceBoutique();
ab.supprimer(Integer.valueOf(tfid.getText()));
setLbLocalisation("supprimé");
        setLbSecteur("supprimé");
       setLbEtat("supprimé");
        setLbDescription("supprimé");
setLbSurface("supprimé");
    
}///
    @FXML
 public void modifier(ActionEvent event) throws IOException {
    

  ServiceBoutique ab = new ServiceBoutique();
  //obj cat w pasih paramaetre mod 
   FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierBoutique.fxml"));
        Parent root = loader.load();
        tfid.getScene().setRoot(root);
         
ModifierBoutiqueController bc=loader.getController();;
bc.setId(tfid.getText());
  
 
 }
 
 
 
 }


