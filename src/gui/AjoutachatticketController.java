/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import entities.achatticket;
import service.serviceachatticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Maha Maatoug
 */
public class AjoutachatticketController implements Initializable {
    
     @FXML
    private TextField tfnb_ticket;
    
   
      @FXML
    private TextField tfprix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutachatticket(ActionEvent event) throws IOException {
           serviceachatticket sa = new serviceachatticket();
        sa.ajouter(new achatticket(Integer.parseInt(tfnb_ticket.getText()), Integer.parseInt(tfprix.getText())));
        JOptionPane.showMessageDialog(null, "event ajoutée !");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeticket.fxml"));
        Parent root = loader.load();
        tfnb_ticket.getScene().setRoot(root);
    }
}
