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
import javafx.scene.control.TextField;
import services.ServiceBoutique;
import services.ServiceCathegorie;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ModifierCategorieController implements Initializable {

    @FXML
    private TextField mddescription;
    @FXML
    private TextField mdtype;
    @FXML
    private Button retourbienvenue;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getMddescription() {
        return mddescription;
    }

     public void setMdtype(String type) {
        this.mdtype.setText(type);
    }
       public void setMddescription(String description) {
        this.mddescription.setText(description);
    }

    public TextField getMdtype() {
        return mdtype;
    }

    public void setMdtype(TextField mdtype) {
        this.mdtype = mdtype;
    }

    public Button getRetourbienvenue() {
        return retourbienvenue;
    }

    public void setRetourbienvenue(Button retourbienvenue) {
        this.retourbienvenue = retourbienvenue;
    }

    @FXML
    private void modifierCathegorie(ActionEvent event) throws IOException { 
      Cathegorie b = new Cathegorie(mdtype.getText(),mddescription.getText());
    ServiceCathegorie sb = new ServiceCathegorie();
    sb.modifier(b);
     FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        mdtype.getScene().setRoot(root);
      AfficherCategorieController dpc = loader.getController();
        
   dpc.setAftype(mdtype.getText());
   dpc.setAfdescription(mddescription.getText());

    }
    
 @FXML
    private void retourbienvenue(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Bienvenue.fxml"));
        Parent root = loader.load();
        mdtype.getScene().setRoot(root);
        BienvenueController dpc = loader.getController();
       
        
    }
    
}
