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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import services.ServiceBoutique;
import services.ServiceCathegorie;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutCategorieController implements Initializable {

    @FXML
    private TextField ajtype;
    @FXML
    private TextArea ajdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
        private void ajouter(ActionEvent event) throws IOException {
    ServiceCathegorie sp = new ServiceCathegorie();
    String type = ajtype.getText();
    if (sp.existeDeja(type)) {
        JOptionPane.showMessageDialog(null, "Cathegorie avec le même type existe déjà !");
        return;
    }
    sp.ajouter(new Cathegorie(type, ajdescription.getText()));
    JOptionPane.showMessageDialog(null, "Cathegorie ajoutée !");
    // ... le reste du code


        
        sp.ajouter(new Cathegorie(ajtype.getText(),ajdescription.getText() ));
        JOptionPane.showMessageDialog(null, "Cathegorie ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCategorie.fxml"));
        Parent root = loader.load();
        ajtype.getScene().setRoot(root);
        
        AfficherCategorieController dpc = loader.getController();
        
        dpc.setAftype(ajtype.getText());
        dpc.setAfdescription(ajdescription.getText());
  
       
    }

/*
         try{
            new ServiceCathegorie().ajouter(new Cathegorie(ajtype.getText(),ajdescription.getText()));
            new Alert(Alert.AlertType.INFORMATION, "Ajout avec succes!", ButtonType.OK).show();
        }catch(Exception ignored){
            new Alert(Alert.AlertType.WARNING, "Verifier les champs !", ButtonType.OK).show();
        }*/

    

    
}
