package gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import entities.event;
import service.serviceevent;
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
public class AjouteventController implements Initializable {

    /**
     * Initializes the controller class.
     */

    
     @FXML
    private TextField tflocalisation;
    
    @FXML
    private TextField tfdescription;
      @FXML
    private TextField tfprix;
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
        
      @FXML
    private void Ajoutevent(ActionEvent event) throws IOException {
        serviceevent sv = new serviceevent();
        sv.ajouter(new event(tflocalisation.getText(),tfdescription.getText(), Integer.parseInt(tfprix.getText())));
        JOptionPane.showMessageDialog(null, "event ajoutée !");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeEvenet.fxml"));
        Parent root = loader.load();
        tflocalisation.getScene().setRoot(root);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsevent.fxml"));
//        Parent root = loader.load();
//        tflocalisation.getScene().setRoot(root);
//        
//        DetailseventController dpc = loader.getController();
//        dpc.setLblocalisation(tflocalisation.getText());
//        dpc.setLbdescription(tfdescription.getText());
//        dpc.setLbPrix(Integer.parseInt(tfprix.getText()));

    
    }
       
    
}
