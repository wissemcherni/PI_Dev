/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.commande;
import com.esprit.services.Service_commande;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> types = new ArrayList();
        types.add("echange");
        types.add("vente");
         List<String> statuss = new ArrayList();
        statuss.add("livre");
        statuss.add("non_livre");
        
        liste_commandes.getItems().setAll(new Service_commande().afficher());
        status.getItems().setAll(statuss);
        type.getItems().setAll(types);
    }    
    @FXML
    private void ajouter() {
            if (status.getValue().isEmpty()|| emiteur.getText().isEmpty()|| type.getValue().isEmpty()){
                JOptionPane.showMessageDialog(null,"champs manquant");
                
                    }
            else {commande c = new commande(status.getValue(), Integer.parseInt(id_depot.getText()), emiteur.getText(), type.getValue());
        new Service_commande().ajouter(c);
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
        _btn_.setOnAction(e -> {
            modifier();
        });
    }
    private void modifier(){
        _btn_.setText("Ajouter");
        _btn_.setOnAction(e -> {
            ajouter();
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
    
}
