/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entities.Cathegorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ServiceCathegorie;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CathegorieController implements Initializable {

    @FXML
    private TextField ajdescription;
    @FXML
    private TextField ajtype;
    @FXML
    private TextField mddescription;
    @FXML
    private TextField mdtype;
    @FXML
    private TextField id;
    @FXML
    private Label aftype;
    @FXML
    private Label afdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterCathegorie(ActionEvent event) {
        try{
            new ServiceCathegorie().ajouter(new Cathegorie(ajtype.getText(),ajdescription.getText()));
            new Alert(Alert.AlertType.INFORMATION, "Ajout avec succes!", ButtonType.OK).show();
        }catch(Exception ignored){
            new Alert(Alert.AlertType.WARNING, "Verifier les champs !", ButtonType.OK).show();
        }
    }

    @FXML
    private void modifierCathegorie(ActionEvent event) {
         try{
            new ServiceCathegorie().modifier(new Cathegorie(Integer.parseInt(id.getText()),ajtype.getText(),ajdescription.getText()));
            new Alert(Alert.AlertType.INFORMATION, "Ajout avec succes!", ButtonType.OK).show();
        }catch(Exception ignored){
            new Alert(Alert.AlertType.WARNING, "Verifier les champs !", ButtonType.OK).show();
        }
    }

    @FXML
    private void SupprimerCathegorie(ActionEvent event) {
        try{ new ServiceCathegorie().supprimer(new Cathegorie(Integer.parseInt(id.getText()), null, null));
        new Alert(Alert.AlertType.INFORMATION, "Suppression avec succes!", ButtonType.OK).show();
         }catch(Exception ignored){
            new Alert(Alert.AlertType.WARNING, "Verifier les champs !", ButtonType.OK).show();
        }
    }

    @FXML
    private void afficherCathegorie(ActionEvent event) {
        try{ Cathegorie cat = new ServiceCathegorie().rechercher(Integer.valueOf(id.getText()));
        aftype.setText(cat.getType());
        afdescription.setText(cat.getDescriptionc());
        }catch(Exception ignored){
            new Alert(Alert.AlertType.WARNING, "Verifier les champs !", ButtonType.OK).show();
        }
    }
    
}
