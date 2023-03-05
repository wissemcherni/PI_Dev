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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Maha Maatoug
 */
public class DetailseventController implements Initializable {
 
    @FXML
    private TextField lblocalisation;

    @FXML
    private TextField lbdescription;

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
    void modifierevent(ActionEvent ev) throws IOException {
        event.setLocalisation(lblocalisation.getText());
        event.setDescription(lbdescription.getText());
        event.setPrix(Integer.valueOf(lbprix.getText()));
        new service.serviceevent().modifier(event);
        JOptionPane.showMessageDialog(null, "Event modifier !");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeEvenet.fxml"));
        Parent root = loader.load();
        lbprix.getScene().setRoot(root);
    }
    @FXML
    void delete(ActionEvent ev) throws IOException{
        new service.serviceevent().supprimer(event);
        JOptionPane.showMessageDialog(null, "Event supprimer !");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeEvenet.fxml"));
        Parent root = loader.load();
        lbprix.getScene().setRoot(root); 
    }
    private event event;
    void setData(event selectedItem) {
        this.event = selectedItem;
        lblocalisation.setText(event.getLocalisation());
        lbdescription.setText(event.getDescription());
        lbprix.setText(String.valueOf(event.getPrix()));
    }
}

