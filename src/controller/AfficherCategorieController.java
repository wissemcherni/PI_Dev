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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ServiceBoutique;
import services.ServiceCathegorie;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherCategorieController implements Initializable {

    @FXML
    private Label aftype;
    @FXML
    private Label afdescription;
    @FXML
    private Button retourbienvenue;
    @FXML
    private TextField tftype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Label getAftype() {
        return aftype;
    }
     public void setAftype(String type) {
        this.aftype.setText(type);
    }
       public void setAfdescription(String description) {
        this.afdescription.setText(description);
    }

    
    public Label getAfdescription() {
        return afdescription;
    }

  

    public Button getRetourbienvenue() {
        return retourbienvenue;
    }

    public void setRetourbienvenue(Button retourbienvenue) {
        this.retourbienvenue = retourbienvenue;
    }

 @FXML
    private void afficher(ActionEvent event) {
ServiceCathegorie ab = new ServiceCathegorie();
Cathegorie b =ab.rechercher(tftype.getText());
setAftype(b.getType());
       
        setAfdescription(b.getDescriptionc());
    
}
@FXML
 public void supprimer(ActionEvent event) {
     
    ServiceCathegorie ab = new ServiceCathegorie();
ab.supprimer(tftype.getText());
setAftype("supprimé");
        setAfdescription("supprimé");
    
    
}///
    @FXML
 public void modifier(ActionEvent event) throws IOException {
    

 // ServiceBoutique ab = new ServiceBoutique();
  //obj cat w pasih paramaetre mod 
   FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCategorie.fxml"));
        Parent root = loader.load();
        aftype.getScene().setRoot(root);
         
ModifierCategorieController bc=loader.getController();
bc.setMdtype(aftype.getText()); 

  
 
 }
  @FXML
    private void retourbienvenue(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Bienvenue.fxml"));
        Parent root = loader.load();
        aftype.getScene().setRoot(root);
        BienvenueController dpc = loader.getController();
       
        
    }

   

   
    
}
