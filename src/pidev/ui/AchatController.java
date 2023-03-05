/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pidev.Entity.Salon;
import pidev.Entity.Salon_Achat;
import pidev.Entity.User;

import pidev.Service.Salon_Achat_Service;

/**
 * FXML Controller class
 *
 * @author elaab
 */
public class AchatController implements Initializable {

    private Salon current;
    @FXML
    private TableView<Salon_Achat> bidsTableview;
    @FXML
    private TableColumn<Salon_Achat, String> userColumn;
    @FXML
    private TableColumn<Salon_Achat, Integer> priceColumn;
    @FXML
    private TextField tfprice;

    ObservableList<Salon_Achat> observable;
    // à changer avec id user connecté
    int userid = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setData(Salon s) {
        this.current = s;
        tfprice.setText(s.getMax_jetons() + "");
        List<Salon_Achat> list = new Salon_Achat_Service().AfficherBySalon(current.getId());
        observable = FXCollections.observableArrayList(list);
        System.out.println(observable);
        bidsTableview.setItems(observable);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("prix_calculer"));
        User u = new Salon_Achat_Service().findUserById(userid);
        if (u != null) {
            userColumn.setCellValueFactory(cell
                    -> new SimpleStringProperty(u.getName() + " " + u.getPrenom())
            );
        }
    }

    @FXML
    private void acheter(ActionEvent event) {
        int proposedAmount = Integer.valueOf(tfprice.getText());
        if (proposedAmount < current.getMax_jetons() || proposedAmount < new Salon_Achat_Service().getLastPrice()) {
            JOptionPane.showMessageDialog(null, "Vérifier le montant");

        } else {
            Salon_Achat_Service t = new Salon_Achat_Service();
            Salon_Achat ss = new Salon_Achat(current.getId(), 0, userid, Integer.parseInt(tfprice.getText()));
            t.ajouter(ss);
            JOptionPane.showMessageDialog(null, "Jeton acheté !");
            observable.add(ss);

        }

    }

    @FXML
    private void back(ActionEvent event) {
             try {
            FXMLLoader loader = new FXMLLoader(Salon_UIController.class.getResource("Salon_UI.fxml"));
            Parent component = loader.load();
        
            tfprice.getScene().setRoot(component);

        } catch (IOException ex) {
            Logger.getLogger(Salon_ComponentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
