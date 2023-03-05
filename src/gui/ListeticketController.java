/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.achatticket;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import service.serviceachatticket;

/**
 * FXML Controller class
 *
 * @author Maha Maatoug
 */
public class ListeticketController implements Initializable {
@FXML
private ListView<achatticket> liste;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }    
    private void afficher(){
        liste.getItems().setAll(new serviceachatticket().afficher());

    }
@FXML
    private void details(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsachatticket.fxml"));
        Parent root = loader.load();
        liste.getScene().setRoot(root);
        
        DetailsachatticketController dpc = loader.getController();
        dpc.setData(liste.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutachatticket.fxml"));
        Parent root = loader.load();
        liste.getScene().setRoot(root);
    }
}
