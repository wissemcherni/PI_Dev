/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.achatticket;
import service.serviceachatticket;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Maha Maatoug
 */
public class DetailsachatticketController implements Initializable {
     @FXML
    private TextField lbnb_ticket;

    @FXML
    private TextField lbprix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
      @FXML
    void modifieachatticket(ActionEvent ev) throws IOException {
        achatticket.setNb_ticket(Integer.valueOf(lbnb_ticket.getText()));
        achatticket.setPrix(Integer.valueOf(lbprix.getText()));
        new service.serviceachatticket().modifier(achatticket);
        JOptionPane.showMessageDialog(null, "Event modifier !");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeticket.fxml"));
        Parent root = loader.load();
        lbprix.getScene().setRoot(root);
    }
    @FXML
    void delete(ActionEvent ev) throws IOException{
        new service.serviceachatticket().supprimer(achatticket);
        JOptionPane.showMessageDialog(null, "achtticket supprimer !");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeticket.fxml"));
        Parent root = loader.load();
        lbprix.getScene().setRoot(root); 
    }
    private achatticket achatticket;
    void setData(achatticket selectedItem) {
        this.achatticket = selectedItem;
         lbnb_ticket.setText(String.valueOf(achatticket.getNb_ticket()));
    
        lbprix.setText(String.valueOf(achatticket.getPrix()));
    }
}


    

