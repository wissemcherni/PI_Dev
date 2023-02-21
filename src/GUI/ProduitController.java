/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import gestion_produit.entities.Product;
import gestion_produit.services.Product_Service;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohamed Akrem
 */
public class ProduitController implements Initializable {

    @FXML
    private TextField tfnom;
  
    @FXML
    private TextField quantity;
    @FXML
    private Button _detele_btn_;
    @FXML
    private ListView<Product> list_produis;
    @FXML
    private Button _btn_;
    @FXML
    private TextArea tfdesc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
    }    
   /* private void CREATE(ActionEvent event) throws IOException {
        Product_Service p = new Product_Service();
        p.CREATE(new Product(tfnom.getText(),tfdesc.getText()));
        
        JOptionPane.showMessageDialog(null, " ajoutée !");
        
      
     
    }
*/

  

    @FXML
    private void produit() {
        Product_Service p = new Product_Service();
        Product pr = p.CREATE(new Product(tfnom.getText(),tfdesc.getText() ,"4a815466-4ab2-4d40-93e8-298dac928011",Integer.parseInt(quantity.getText()),"5c0515f7-79e0-4f84-a998-bb2c9a8f048a", "70.00", "555.55"));
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
        JOptionPane.showMessageDialog(null, " ajoutée !");
         tfnom.clear();
        tfdesc.clear();
        quantity.clear();
       
        
    }
    
    @FXML
    private void InitModification(MouseEvent event) {
        Product product = list_produis.getSelectionModel().getSelectedItem();
        tfnom.setText(product.getName());
        tfdesc.setText(product.getDescription());
        quantity.setText(String.valueOf(product.getQuantity()));
        _btn_.setText("Modifier");
        _detele_btn_.setVisible(true);
        _btn_.setOnAction(e -> {
            modifier();
        });
    }
    private void modifier(){
        Product product = list_produis.getSelectionModel().getSelectedItem();
        product.setName(tfnom.getText());
        product.setDescription(tfdesc.getText());
        product.setQuantity(Integer.parseInt(quantity.getText()));
        new Product_Service().MODIFY(product);
        new Alert(Alert.AlertType.INFORMATION,"Modification avec success",ButtonType.OK).show();
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
        _btn_.setText("Ajouter");
         tfnom.clear();
        tfdesc.clear();
        quantity.clear();
        _detele_btn_.setVisible(false);
        _btn_.setOnAction(e -> {
            produit();
        });
    }
    @FXML
    private void delete(ActionEvent event) {
        new Product_Service().DELETE(list_produis.getSelectionModel().getSelectedItem());
        new Alert(Alert.AlertType.INFORMATION,"Suppression avec success",ButtonType.OK).show();
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
        tfnom.clear();
        tfdesc.clear();
        quantity.clear();
         _btn_.setText("Ajouter");
        _detele_btn_.setVisible(false);
        _btn_.setOnAction(e -> {
            produit();
        });
    }

    @FXML
    private void back(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(ProduitController.class.getResource("Category.fxml"));
        Parent component = loader.load();
        _btn_.getScene().setRoot(component);
    }

    
    
    
    
    
}
