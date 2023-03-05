/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pidev.ui;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.jnlp.PrintService;
import pidev.Entity.Produit;
import pidev.Entity.Salon;
import pidev.Entity.Salon_Achat;
import pidev.Service.Produit_Service;
import pidev.Service.Salon_Service;
import pidev.ui.Salon_UIController.SelectSalon;
import javax.print.service;
import javax.PrintServiceLookup;

/**
 * FXML Controller class
 *
 * @author elaab
 */
public class Salon_UIController implements Initializable, SelectSalon {

    @FXML
    private VBox _salon_list_;
    @FXML
    private ComboBox<Produit> _list_produits_;
    @FXML
    private DatePicker date_expiration;
    @FXML
    private TextArea description;
    @FXML
    private TextField nbr_jetons;
    @FXML
    private Button _btn_;
    private ObservableList<Salon> salons;
    private int id;
    @FXML
    private Button bchercher;
    @FXML
    private TextField eChercher;
@FXML
private TextField emailField;

@FXML
private Button sendEmailButton;

     @FXML
    public void printButtonClicked(ActionEvent event) {
        Salon salon = // obtenir l'instance de Salon à imprimer
        printSalon(salon);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        salons = FXCollections.observableArrayList();
        int[] i = {0};
        salons.addListener((ListChangeListener<Salon>) change -> {
            i[0] = 0;
            _salon_list_.getChildren().clear();
            i[0] = 0;
            new Salon_Service().afficher().forEach(sal -> {
                try {
                    FXMLLoader loader = new FXMLLoader(Salon_UIController.class.getResource("Salon_Component.fxml"));
                    AnchorPane component = loader.load();
                    Salon_ComponentController controller = loader.getController();
                    controller.setData(++i[0], sal, this, this);
                    _salon_list_.getChildren().add(component);
                } catch (Exception ignored) {

                }
            });
        });
        salons.addAll(new Salon_Service().afficher());
        _list_produits_.getItems().setAll(new Produit_Service().READALL());

    }

    @FXML
    private void Ajouter(ActionEvent event) {
        new Salon_Service().ajouter(new Salon(_list_produits_.getSelectionModel().getSelectedItem().getId(), description.getText(), Date.valueOf(date_expiration.getValue()), Integer.valueOf(nbr_jetons.getText())));
        new Alert(Alert.AlertType.INFORMATION, "AJOUT AVEC SUCCESS!", ButtonType.OK).show();
        salons.clear();
        refresh();

    }

    void refresh() {
        salons.clear();
        salons.addAll(new Salon_Service().afficher());
    }

    @Override
    public void select(Salon s) {
        description.setText(s.getDescription());
        date_expiration.setValue(s.getDate_expiration().toLocalDate());
        nbr_jetons.setText(String.valueOf(s.getMax_jetons()));
        _list_produits_.setValue(new Salon_Service().getProduit(s));
        this.id = s.getId();

    }

    public Salon getUpdateSalon() {
        Salon s = new Salon();
        s.setId(id);
        s.setDate_expiration(Date.valueOf(date_expiration.getValue()));
        s.setDescription(description.getText());
        s.setMax_jetons(Integer.parseInt(nbr_jetons.getText()));
        s.setProduit_id(_list_produits_.getSelectionModel().getSelectedItem().getId());
        return s;
    }

    @FXML
    private void Search(ActionEvent event) {
        /*    Salon_Service rs = new Salon_Service();
        ObservableList<Salon_Achat> list = FXCollections.observableList(rs.afficher());
        ServiceSalon e = new Service_Salon();
        Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        Titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        Nbreplaces.setCellValueFactory(new PropertyValueFactory<>("nbreplaces"));
        Nbreparticipants.setCellValueFactory(new PropertyValueFactory<>("nbreparticipants"));
        Datedebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        Datefin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        Image.setCellValueFactory(new PropertyValueFactory<>("image"));
        table.setItems(list);

        rs.afficher();
      table.setItems(list);

        FilteredList<Evenement> filteredData;
        filteredData = new FilteredList<>(list, b -> true);
        eChercher.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Evenement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Evenement.getLieu().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                
                }  else {
                    return false;
                }

            });

        }));*/
    }

    void setquantity(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setprix_calculer(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void rechercherParProduit(KeyEvent event) {
        _salon_list_.getChildren().clear();
        int[] i = {0};
        new Salon_Service().afficher().stream().filter(t -> t.getP().getNom().contains(eChercher.getText())).forEach(t->{
            try {
                    FXMLLoader loader = new FXMLLoader(Salon_UIController.class.getResource("Salon_Component.fxml"));
                    AnchorPane component = loader.load();
                    Salon_ComponentController controller = loader.getController();
                    controller.setData(++i[0], t, this, this);
                    _salon_list_.getChildren().add(component);
                } catch (Exception ignored) {

                }
        });
    }

    private Salon_Service service = new Salon_Service();
/*
    @FXML
    private void envoyerEmail(ActionEvent event) {

        String destinataire = "destinataire@example.com";
        String sujet = "Sujet de l'e-mail";
        String message = "Contenu de l'e-mail";

        service.envoyerEmail(destinataire, sujet, message);
    }
    @FXML
private void envoyerEmail() {
    String email = emailField.getText();
    Salon_Service.envoyerEmail(email);
}
}

*/

public void printSalon(Salon salon) {
    // Obtenir une référence à l'imprimante à utiliser
    PrintService service = PrintServiceLookup.lookupDefaultPrintService();

    // Créer un objet PrinterJob
    PrinterJob printerJob = PrinterJob.getPrinterJob();

    // Définir l'imprimante à utiliser
    printerJob.setPrintService(service);

    // Générer le Printable à partir de l'instance de Salon
    Printable printable = Salon_Service.generatePrintable(salon);

    // Définir le Printable dans le PrinterJob
    printerJob.setPrintable(printable);

    // Afficher la boîte de dialogue d'impression
    if (printerJob.printDialog()) {
        try {
            // Lancer l'impression
            printerJob.print();
        } catch (PrinterException ex) {
        }
    }
}
// envoyer les données à partir d'une cellule
interface SelectSalon {

    void select(Salon s);
}
}
