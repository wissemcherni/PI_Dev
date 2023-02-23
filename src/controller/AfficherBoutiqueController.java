/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherBoutiqueController implements Initializable {

    private Label lbLocalisation;
    private Label lbSecteur;
    private Label lbSurface;
    private Label lbEtat;
    private Label lbDescription;
    private TextField tfid;

    public Label getLbLocalisation() {
        return lbLocalisation;
    }

    public void setLbLocalisation(Label lbLocalisation) {
        this.lbLocalisation = lbLocalisation;
    }

    public Label getLbSecteur() {
        return lbSecteur;
    }

    public void setLbsSecteur(Label lbSecteur) {
        this.lbSecteur = lbSecteur;
    }

    public Label getLbSurface() {
        return lbSurface;
    }

    public void setLbSurface(Label lbSurface) {
        this.lbSurface = lbSurface;
    }

    public Label getLbEtat() {
        return lbEtat;
    }

    public void setLbEtat(Label lbEtat) {
        this.lbEtat = lbEtat;
    }

    public Label getLbDescription() {
        return lbDescription;
    }

    public void setLbDescription(Label lbDescription) {
        this.lbDescription = lbDescription;
    }

    public TextField getTfid() {
        return tfid;
    }

    public void setTfid(TextField tfid) {
        this.tfid = tfid;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    void setLbSecteur(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void supprimerCathegorie(ActionEvent event) {
    }
    
}
