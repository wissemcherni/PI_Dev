/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import gestion_produit.entities.Category;
import gestion_produit.entities.Product;
import gestion_produit.entities.Sub_Category;
import gestion_produit.services.Category_Service;
import gestion_produit.services.Product_Service;
import gestion_produit.services.Sub_Category_Service;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

import javafx.scene.input.KeyEvent;


/**
 * FXML Controller class
 *
 * @author Mohamed Akrem
 */


public class ProduitController implements Initializable {
    //************ComboBox********************************************
    
    //********************************************************************
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
   
  
    @FXML
    private ComboBox<Sub_Category> _list_sub_category_;
    @FXML
    private Label errorLabel;
    @FXML
    private Label errorLabeldesc;
    @FXML
    private TextField search_bar;
    @FXML
    private AnchorPane paneMain;
    
    
    /**
     * Initializes the controller class.
     */
    //new Categories********************************************
 
     //***************************************
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         search_bar.textProperty().addListener((observable, oldValue, newValue) -> {
            if(search_bar.getText().isEmpty()){
                 list_produis.getItems().setAll((new Product_Service().READALL().values()).stream().collect(Collectors.toList()));
            }else {
                 list_produis.getItems().setAll((new Product_Service().READALL().values()).stream().filter(product -> {return product.getName().toLowerCase().contains(newValue.toLowerCase());}).collect(Collectors.toList()));

            }
        });
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
        afficher();
 
      /////
      
      ToggleSwitch button = new ToggleSwitch();
       
      
      SimpleBooleanProperty isOn = button.switchOnProperty();
        isOn.addListener((observable,oldValue,newValue) -> {
    if(newValue){
        button.getScene().getRoot().getStylesheets().add(getClass().getResource("../Styles.css").toString());
        System.out.println("Adding the css");
    }
        else{
         button.getScene().getRoot().getStylesheets().remove(getClass().getResource("../Styles.css").toString());
        System.out.println("Removing the css");
    }
});


        paneMain.getChildren().add(button);
    
      
      
      
      
      
      
      
      
        ///
    }    
    
    
    
    
    
    
   public void handleSearchButtonClick(ActionEvent event) {
    String searchStr =tfnom.getText(); // get the search string from the UI (e.g., a TextField)
   // Product result = READONE2(searchStr); // call the search function with the search string
     Product result = new Product_Service().READONE2(searchStr); // call the READONE2 function to search for the product
    if(result != null) {
         System.out.println(new Product_Service().READONE2(searchStr));
    } else {
        // display an error message if the search result is not found
    }
}
   
   @FXML


    
    
    
    
    
    public void validateInput() {
        String name = tfnom.getText().trim();

        if (name.isEmpty()) {
            errorLabel.setText("Name is required");
            return;
        }

        if (!name.matches("[a-zA-Z]+")) {
            errorLabel.setText("Name should contain only alphabets");
            return;
        }

        // perform some action with valid input
    }
    
    
    @FXML
     public void validateInputdesc() {
        String description = tfdesc.getText().trim();

        if (description.length() > 100) {
            errorLabeldesc.setText("Description should not exceed 100 characters");
            return;
        }
       

        // perform some action with valid input
    }
    
     
     
     
     
    /*
      public void validateInputcombo() {
        Sub_Category selectedItem = _list_sub_category_.getSelectionModel().getSelectedItem();

        if (_list_sub_category_.getSelectionModel().getSelectedItem().getId()==null) {
            errorLabel.setText("Please select an item from the list");
            return;
        }

        // perform some action with valid input
    }
    */
    //***********************************
   
    
   /* private void CREATE(ActionEvent event) throws IOException {
        Product_Service p = new Product_Service();
        p.CREATE(new Product(tfnom.getText(),tfdesc.getText()));
        
        JOptionPane.showMessageDialog(null, " ajoutée !");
        
      
     
    }
*/
    
    
    
    
 private void afficher(){
        List<Sub_Category>  categories = (new Sub_Category_Service().READALL().values()).stream().collect(Collectors.toList());
        _list_sub_category_.getItems().setAll(categories);
    }
  

    @FXML
    private void produit() {
        Product_Service p = new Product_Service();
        Product pr = p.CREATE(new Product(tfnom.getText(),tfdesc.getText() ,_list_sub_category_.getSelectionModel().getSelectedItem().getId(),Integer.parseInt(quantity.getText()),"5c0515f7-79e0-4f84-a998-bb2c9a8f048a", "70.00", "555.55"));
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
        JOptionPane.showMessageDialog(null, " ajoutée !");
         tfnom.clear();
        tfdesc.clear();
        quantity.clear();
        afficher();
       
        
    }
    
    @FXML
    private void InitModification(MouseEvent event) {
        Product product = list_produis.getSelectionModel().getSelectedItem();
        tfnom.setText(product.getName());
        tfdesc.setText(product.getDescription());
        _list_sub_category_.setValue(null);
        quantity.setText(String.valueOf(product.getQuantity()));
        _list_sub_category_.setValue(new Sub_Category(product.getSub_category_id()));
        _btn_.setText("Modifier");
        _detele_btn_.setVisible(true);
        _btn_.setOnAction(e -> {
            modifier();
             afficher();
        });
    }
    
    
    
    private void modifier(){
        Product product = list_produis.getSelectionModel().getSelectedItem();
        product.setName(tfnom.getText());
        product.setDescription(tfdesc.getText());
        product.setSub_category_id(_list_sub_category_.getSelectionModel().getSelectedItem().getId());
        product.setQuantity(Integer.parseInt(quantity.getText()));
        new Product_Service().MODIFY(product);
        new Alert(Alert.AlertType.INFORMATION,"Modification avec success",ButtonType.OK).show();
        List<Product> products = (new Product_Service().READALL().values()).stream().collect(Collectors.toList());
        list_produis.getItems().setAll(products);
        _btn_.setText("Ajouter");
         tfnom.clear();
        tfdesc.clear();
    _list_sub_category_.setValue(null);
        quantity.clear();
        _detele_btn_.setVisible(false);
        _btn_.setOnAction(e -> {
            produit();
          afficher();   
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
