/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import gestion_produit.entities.Category;
import gestion_produit.entities.Product;
import gestion_produit.services.Category_Service;
import gestion_produit.services.Product_Service;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohamed Akrem
 */
public class CategoryController implements Initializable {

    @FXML
    private TextField tfcategory;
    @FXML
    private ComboBox<Category> _list_caegory_;
    @FXML
    private Button _btn_;
    @FXML
    private Button _delete_btn_;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }    
    private void afficher(){
        List<Category>  categories = (new Category_Service().READALL().values()).stream().collect(Collectors.toList());
        _list_caegory_.getItems().setAll(categories);
        tfcategory.clear();
        _delete_btn_.setVisible(false);


    }
    @FXML   
    private void produits(ActionEvent event) throws IOException{
            FXMLLoader loader = new FXMLLoader(ProduitController.class.getResource("produit.fxml"));
        Parent component = loader.load();
        ((Button)event.getSource()).getScene().setRoot(component);
    }

    @FXML
    private void Category(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(ProduitController.class.getResource("sub_category.fxml"));
        Parent component = loader.load();
        ((Button)event.getSource()).getScene().setRoot(component);
        
    }

    @FXML
    private void back (ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(ProduitController.class.getResource("produit.fxml"));
        Parent component = loader.load();
        ((Button)event.getSource()).getScene().setRoot(component);
    }

    @FXML
    private void addcategory(ActionEvent event) {
        Category_Service c = new Category_Service();
        Category ca = c.CREATE(new Category(tfcategory.getText()));
        JOptionPane.showMessageDialog(null, " ajoutée  Category !");
        afficher();
    }

    @FXML
    private void delete(ActionEvent event) {
        new Category_Service().DELETE(_list_caegory_.getValue());
        new Alert(Alert.AlertType.INFORMATION,"Category deleted", ButtonType.OK).show();
        afficher();
        _btn_.setOnAction(this::addcategory);
    }

    @FXML
    private void initdata(ActionEvent event) {
        _delete_btn_.setVisible(true);
        tfcategory.setText(_list_caegory_.getSelectionModel().getSelectedItem().getName());
        _btn_.setText("Modifier");
        _btn_.setOnAction(e -> {
        modifier();
        });
    }

    private void modifier() {
        _list_caegory_.getSelectionModel().getSelectedItem().setName(tfcategory.getText());
        new Category_Service().MODIFY(_list_caegory_.getSelectionModel().getSelectedItem());
        afficher();
        _btn_.setOnAction(this::addcategory);
    }
    
}
