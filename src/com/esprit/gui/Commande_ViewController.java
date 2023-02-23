/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.commande;
import com.esprit.services.Service_commande;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wissem
 */
public class Commande_ViewController implements Initializable {

    @FXML
    private ListView<commande> liste_commandes;
    @FXML
    private ComboBox<String> status;
    @FXML
    private TextField id_depot;
    @FXML
    private TextField emiteur;
    @FXML
    private ComboBox<String> type;
    @FXML
    private Button _btn_;
    @FXML
    private Button _delete_;
    @FXML
    private ComboBox<String> type_filter;
    @FXML
    private ComboBox<String> status_filtre;
    @FXML
    private TextField search_text;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        search_text.textProperty().addListener((observable, oldValue, newValue) -> {
            if(search_text.getText().isEmpty()){
                 liste_commandes.getItems().setAll(
                    new Service_commande().afficher());
            }
            liste_commandes.getItems().setAll(
                    new Service_commande().afficher()
                            .stream().filter( c -> String.valueOf(c.getId_depot()).contains(newValue) )
                            .collect(Collectors.toList())
            );
       });
        List<String> types = new ArrayList();
        types.add("echange");
        types.add("vente");
         List<String> statuss = new ArrayList();
        statuss.add("livre");
        statuss.add("non_livre");
        type_filter.getItems().setAll(types);
        status_filtre.getItems().setAll(statuss);
        liste_commandes.getItems().setAll(new Service_commande().afficher());
        status.getItems().setAll(statuss);
        type.getItems().setAll(types);
        type_filter.setOnAction(e -> {
            liste_commandes.getItems().setAll(
                    new Service_commande().afficher()
                            .stream().filter( c -> c.getType().equals(type_filter.getSelectionModel().getSelectedItem()) )
                            .collect(Collectors.toList())
            );
        });
        status_filtre.setOnAction(e -> {
            liste_commandes.getItems().setAll(
                    new Service_commande().afficher()
                            .stream().filter( c -> c.getStatut().equals(status_filtre.getSelectionModel().getSelectedItem()) )
                            .collect(Collectors.toList())
            );
        });
    }    
    @FXML
    private void ajouter() throws AWTException {
            if (status.getValue().isEmpty()|| emiteur.getText().isEmpty()|| type.getValue().isEmpty()){
                JOptionPane.showMessageDialog(null,"champs manquant");
                
                    }
            else if (emiteur.getText().length() < 3 || emiteur.getText().length()>20){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("The length of the emiteur must be between 3 and 20 character.");
                    alert.showAndWait();
                    emiteur.requestFocus();
                    emiteur.selectAll();
                }
            else {commande c = new commande(status.getValue(), Integer.parseInt(id_depot.getText()), emiteur.getText(), type.getValue());
        new Service_commande().ajouter(c);
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

                trayIcon.displayMessage("Notification ajout", "commande ajoutée avec succès", MessageType.INFO);
        id_depot.clear();
        emiteur.clear();
        new Alert(Alert.AlertType.INFORMATION,"Commande Ajouter",ButtonType.OK).show();
         id_depot.clear();
        emiteur.clear();
                liste_commandes.getItems().setAll(new Service_commande().afficher());
            
            }
          
    }

    @FXML
    private void edit(MouseEvent event) {
        commande c =liste_commandes.getSelectionModel().getSelectedItem();
        id_depot.setText(String.valueOf(c.getId_depot()));
        emiteur.setText(c.getEmiteur());
        _btn_.setText("Modifier");
        _delete_.setVisible(true);
        status.setValue(c.getStatut());
        type.setValue(c.getType());
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
        commande c = liste_commandes.getSelectionModel().getSelectedItem();
        c.setEmiteur(emiteur.getText());
        c.setId_depot(Integer.parseInt(id_depot.getText()));
        c.setStatut(status.getValue());
        c.setType(type.getValue());
        new Service_commande().modifier(c);
        id_depot.clear();
        emiteur.clear();
        new Alert(Alert.AlertType.INFORMATION,"Commande Modifier",ButtonType.OK).show();
        liste_commandes.getItems().setAll(new Service_commande().afficher());
    }

    @FXML
    private void supprimer(ActionEvent event) {
        new Service_commande().supprimer(liste_commandes.getSelectionModel().getSelectedItem());
        liste_commandes.getItems().setAll(new Service_commande().afficher());

    }

    @FXML
    private void back(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
            Parent root = loader.load();
            id_depot.getScene().setRoot(root);
        }catch(Exception ignored){
            
        }
    }




    @FXML
    private void reset(ActionEvent event) {
        liste_commandes.getItems().setAll(new Service_commande().afficher());
    }
    
}
