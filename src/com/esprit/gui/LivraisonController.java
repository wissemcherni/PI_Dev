/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.commande;
import com.esprit.entities.livraison;
import com.esprit.services.Service_livraison;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author wissem
 */
public class LivraisonController implements Initializable {

    @FXML
    private ListView<livraison> liste_livraison;
    @FXML
    private Button _btn_;
    @FXML
    private Button _delete_;
    @FXML
    private TextField search_text;
    @FXML
    private TextField id_commande;
    @FXML
    private TextField id_livreur;
   
    @FXML
    private DatePicker datepicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        search_text.textProperty().addListener((observable, oldValue, newValue) -> {
            if(search_text.getText().isEmpty()){
                 liste_livraison.getItems().setAll(
                    new Service_livraison().afficher());
            }
            liste_livraison.getItems().setAll(
                    new Service_livraison().afficher()
                            .stream().filter( c -> String.valueOf(c.getId()).contains(newValue) )
                            .collect(Collectors.toList())
            );
       });
        
        // TODO
    }    

    @FXML
    private void edit(MouseEvent event) {
        livraison li =liste_livraison.getSelectionModel().getSelectedItem();
              id_commande.setText(String.valueOf(li.commande.getId_commande()));
        id_livreur.setText(String.valueOf(li.getId_livreur()));
         
         // conversion de java.sql.Date en LocalDate
    LocalDate localDate = li.getDATE();
    
    // affectation de la date au DatePicker
    datepicker.setValue(localDate);
         
 
        _btn_.setText("Modifier");
        _delete_.setVisible(true);
        _btn_.setOnAction(e -> {
            modifier();
        });
    }
    private void modifier(){
        _btn_.setText("Ajouter");
        _btn_.setOnAction(e -> {
            try {
                ajouter();
            } catch (AWTException ex) {
                Logger.getLogger(Commande_ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        _delete_.setVisible(false);
     livraison li =liste_livraison.getSelectionModel().getSelectedItem();
      li.commande.setId_commande(Integer.parseInt(id_commande.getText()));
      li.setId_livreur(Integer.parseInt(id_livreur.getText()));
       // conversion de java.sql.Date en LocalDate
    LocalDate localDate = li.getDATE();
    
    // affectation de la date au DatePicker
    datepicker.setValue(localDate);
        new Service_livraison().modifier(li);
             id_commande.clear();
        id_livreur.clear();
        datepicker.setValue(null);
         
        new Alert(Alert.AlertType.INFORMATION,"livraison Modifier",ButtonType.OK).show();
        liste_livraison.getItems().setAll(new Service_livraison().afficher());
    }

    @FXML
    private void ajouter() throws AWTException {
        LocalDate localDate = datepicker.getValue();
        livraison li = new livraison(new commande( Integer.parseInt(id_commande.getText())), Integer.parseInt(id_livreur.getText()),localDate);
        new Service_livraison().ajouter(li);
        SystemTray tray = SystemTray.getSystemTray();

                //If the icon is a file
                Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                //Alternative (if the icon is on the classpath):
                //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

                TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
                //Let the system resize the image if needed
                trayIcon.setImageAutoSize(true);
                //Set tooltip text for the tray icon
                trayIcon.setToolTip("System tray icon demo");
                tray.add(trayIcon);

                trayIcon.displayMessage("Notification ajout", "livraison ajoutée avec succès", MessageType.INFO);
        id_commande.clear();
        id_livreur.clear();
        datepicker.setValue(null);
         
        new Alert(Alert.AlertType.INFORMATION,"livraison Ajouter",ButtonType.OK).show();
        liste_livraison.getItems().setAll(new Service_livraison().afficher());
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void reset(ActionEvent event) {
        liste_livraison.getItems().setAll(new Service_livraison().afficher());
    }

    @FXML
    private void getDate(ActionEvent event) {
        LocalDate localDate = datepicker.getValue();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        
    }
    
}
