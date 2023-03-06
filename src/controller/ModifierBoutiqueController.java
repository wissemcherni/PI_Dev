/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entities.Boutique;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import services.SaisieControl;
import services.ServiceBoutique;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ModifierBoutiqueController implements Initializable {

    @FXML
    private TextField localisation;
    @FXML
    private TextField surface;
    @FXML
    private TextField description;
    @FXML
    private TextField etat;
    @FXML
    private TextField secteur;
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    public void setLocalisation(TextField localisation) {
        this.localisation = localisation;
    }

    public void setSurface(TextField surface) {
        this.surface = surface;
    }

    public void setDescription(TextField description) {
        this.description = description;
    }

    public void setEtat(TextField etat) {
        this.etat = etat;
    }

    public void setSecteur(String secteur) {
        this.secteur.setText(secteur) ;
    }

    public void setId(String id) {
        this.id.setText(id);
    }

   
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        if (!SaisieControl.estNonVide(secteur, "Le secteur est obligatoire")) {
            return;
        }
        if (!SaisieControl.estNonVide(surface, "La surface est obligatoire")) {
            return;
        }
      
        if (!SaisieControl.estLongueurValide(description, "Le prénom doit faire moins de 50 caractères", 50)) {
            return;
        }
       /* ServiceBoutique ab = new ServiceBoutique();
Boutique b = ab.rechercher(secteur.getText());
if (b != null) {
    SaisieControl.afficherErreur(secteur, "Le secteur existe déjà");
    return;
}*/
       /* if (!SaisieControl.estUnique(secteur, "Le nom existe déjà", "valeur existante")) {
            return;
        }*/
        Boutique b = new Boutique(Integer.valueOf(surface.getText()),localisation.getText(),secteur.getText(),etat.getText(),description.getText());
    ServiceBoutique sb = new ServiceBoutique();
    sb.modifier(b);
     FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherBoutique.fxml"));
        Parent root = loader.load();
        localisation.getScene().setRoot(root);
      AfficherBoutiqueController dpc = loader.getController();
        
  
        dpc.setLbLocalisation(b.getLocalisation());
        dpc.setLbSecteur(b.getSecteur());
        dpc.setLbEtat(b.getEtat());
        dpc.setLbDescription(b.getDescriptionb());
        dpc.setLbSurface(Integer.toString(b.getSurface()));
       
    }
    
}
