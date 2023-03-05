/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pidev.Entity.Salon;
import pidev.Service.Produit_Service;
import pidev.Service.Salon_Service;
import pidev.ui.Salon_UIController.SelectSalon;

/**
 * FXML Controller class
 *
 * @author elaab
 */
public class Salon_ComponentController implements Initializable {

    @FXML
    private Label _nom_produit_;
    @FXML
    private Label _date_limite_;
    @FXML
    private Label _description_;
    @FXML
    private Label _jeton_progress_;
    @FXML
    private Label _index_;

    private Salon_UIController parent;
    private Salon current;
    private SelectSalon selectSalonInterface;
    private Salon_Service ss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ss = new Salon_Service();

    }

    @FXML
    private void modifier(ActionEvent event) {
        ss.modifier(parent.getUpdateSalon());
        new Alert(Alert.AlertType.INFORMATION, "Modification avec success!", ButtonType.OK).show();
        parent.refresh();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ss.supprimer(current);
        new Alert(Alert.AlertType.INFORMATION, "Suppression avec success!", ButtonType.OK).show();
        parent.refresh();
    }

    @FXML
    private void achat(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Salon_UIController.class.getResource("achat.fxml"));
            Parent component = loader.load();
            AchatController controller = loader.getController();
            controller.setData(current);
            _nom_produit_.getScene().setRoot(component);

        } catch (IOException ex) {
            Logger.getLogger(Salon_ComponentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setData(int index, Salon sal, Salon_UIController parent, SelectSalon us) {
        this.parent = parent;
        this.current = sal;
        this.selectSalonInterface = us;
        _index_.setText(String.valueOf(index));
        _nom_produit_.setText(new Produit_Service().READALL()
                .stream()
                .filter(prod -> {
                    return prod.getId() == sal.getProduit_id();
                })
                .findAny().get().getNom());
        _date_limite_.setText(String.valueOf(sal.getDate_expiration()));
        _description_.setText(sal.getDescription());
        _jeton_progress_.setText(sal.getMax_jetons() + " Dt");
    }

    @FXML
    private void selectSalon(MouseEvent event) {
        selectSalonInterface.select(current);
    }
    /**
     * @Route("/back", name="app_back_sortC")
     */

}
