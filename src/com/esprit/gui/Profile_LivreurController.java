/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.commande;
import com.esprit.entities.profil_livreur;
import com.esprit.services.Service_profil_livreur;
import com.esprit.services.Service_profil_livreur;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wissem
 */
public class Profile_LivreurController implements Initializable {

    @FXML
    private ListView<profil_livreur> liste_profil;
    @FXML
    private Button _btn_;
    @FXML
    private Button _delete_;
    @FXML
    private TextField search_text;
    @FXML
    private TextField secteur;
    @FXML
    private TextField volume;
    @FXML
    private TextField moyen;
    @FXML
    private ComboBox<String> secteur_filter;
    @FXML
    private ComboBox<String> filter_volume;

 @Override
    public void initialize(URL url, ResourceBundle rb) {

        search_text.textProperty().addListener((observable, oldValue, newValue) -> {
            if(search_text.getText().isEmpty()){
                 liste_profil.getItems().setAll(
                    new Service_profil_livreur().afficher());
            }
            liste_profil.getItems().setAll(
                    new Service_profil_livreur().afficher()
                            .stream().filter( c -> String.valueOf(c.getId_livreur()).contains(newValue) )
                            .collect(Collectors.toList())
            );
       });
        List<String> volumes = new ArrayList();
        volumes.add(">10");
        volumes.add(">50");
        volumes.add(">100");
        volumes.add(">500");
        volumes.add(">1000");
        
       
        
        
        
         List<String> statuss = new ArrayList();
        
        filter_volume.getItems().setAll(volumes);
        secteur_filter.getItems().setAll(statuss);
        liste_profil.getItems().setAll(new Service_profil_livreur().afficher());
        filter_volume.setOnAction(e -> {
            liste_profil.getItems().setAll(
                    new Service_profil_livreur().afficher()
                            .stream().filter( c -> Integer.parseInt(c.getVolume()) > Integer.parseInt(filter_volume.getSelectionModel().getSelectedItem()) )
                            .collect(Collectors.toList())
            );
        });
        secteur_filter.setOnAction(e -> {
            liste_profil.getItems().setAll(
                    new Service_profil_livreur().afficher()
                            .stream().filter( c -> c.getSecteur().equals(secteur_filter.getSelectionModel().getSelectedItem()) )
                            .collect(Collectors.toList())
            );
        });
    }    
    @FXML
    private void ajouter() throws AWTException {
        if (secteur.getText().isEmpty()|| volume.getText().isEmpty()|| moyen.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"champs manquant");
                
                    }
            else if (volume.getText().length() < 2 || volume.getText().length()>4){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("The length of the volume must be between 2 and 4 character.");
                    alert.showAndWait();
                    volume.requestFocus();
                    volume.selectAll();
                } else {
        profil_livreur liv = new profil_livreur(secteur.getText(), volume.getText(), moyen.getText());
        new Service_profil_livreur().ajouter(liv);
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

                trayIcon.displayMessage("Notification ajout", "profil livreur ajoutée avec succès", MessageType.INFO);
        secteur.clear();
        volume.clear();
         moyen.clear();
        new Alert(Alert.AlertType.INFORMATION,"Profil Ajouter",ButtonType.OK).show();
        liste_profil.getItems().setAll(new Service_profil_livreur().afficher());
            
          
    }
    }

    @FXML
    private void edit(MouseEvent event) {
        profil_livreur l =liste_profil.getSelectionModel().getSelectedItem();
              secteur.setText(l.getSecteur());
        volume.setText(l.getVolume());
         moyen.setText(l.getMoy_livraison());
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
     profil_livreur l =liste_profil.getSelectionModel().getSelectedItem();
      l.setSecteur(secteur.getText());
      l.setMoy_livraison(moyen.getText());
      l.setVolume(volume.getText());
        new Service_profil_livreur().modifier(l);
             secteur.clear();
        volume.clear();
         moyen.clear();
        new Alert(Alert.AlertType.INFORMATION,"Profil Modifier",ButtonType.OK).show();
        liste_profil.getItems().setAll(new Service_profil_livreur().afficher());
    }

    @FXML
    private void supprimer(ActionEvent event) {
        new Service_profil_livreur().supprimer(liste_profil.getSelectionModel().getSelectedItem());
        liste_profil.getItems().setAll(new Service_profil_livreur().afficher());

    }

    @FXML
    private void back(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
            Parent root = loader.load();
            secteur.getScene().setRoot(root);
        }catch(Exception ignored){
            
        }
    }




    @FXML
    private void reset(ActionEvent event) {
        liste_profil.getItems().setAll(new Service_profil_livreur().afficher());
    }
    
}
