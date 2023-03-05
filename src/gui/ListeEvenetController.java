/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.event;
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
import service.serviceevent;

/**
 * FXML Controller class
 *
 * @author Maha Maatoug
 */
public class ListeEvenetController implements Initializable {

    @FXML
    private ListView<event> _liste_;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }    
    
    private void afficher(){
        _liste_.getItems().setAll(new serviceevent().afficher());

    }

    @FXML
    private void details(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsevent.fxml"));
        Parent root = loader.load();
        _liste_.getScene().setRoot(root);
        
        DetailseventController dpc = loader.getController();
        dpc.setData(_liste_.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutevent.fxml"));
        Parent root = loader.load();
        _liste_.getScene().setRoot(root);
    }
    
}
