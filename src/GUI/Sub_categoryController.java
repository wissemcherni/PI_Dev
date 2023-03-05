/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import gestion_produit.entities.Category;
import gestion_produit.entities.Sub_Category;
import gestion_produit.services.Category_Service;
import gestion_produit.services.Sub_Category_Service;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;





/**
 * FXML Controller class
 *
 * @author Mohamed Akrem
 */
public class Sub_categoryController implements Initializable {

    @FXML
    private TextField Sub_Category;
    @FXML
    private ComboBox<Category> _categories_;
    @FXML
    private ListView<Sub_Category> sub_categories;
    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        
    }    

    @FXML
    private void back (ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(ProduitController.class.getResource("Category.fxml"));
        Parent component = loader.load();
        ((Button)event.getSource()).getScene().setRoot(component);
    }

    @FXML
    private void add_Sub_Category(ActionEvent event) {
      try{
          Sub_Category_Service c = new Sub_Category_Service();
        Sub_Category cat = c.CREATE(new Sub_Category (Sub_Category.getText(), _categories_.getSelectionModel().getSelectedItem().getId()));
        JOptionPane.showMessageDialog(null, " ajoutée  Category !");
        afficher();
        }catch(Exception ignored){
            new Alert(Alert.AlertType.WARNING, "Select Category", ButtonType.OK).show();

        }
      

        
    }
    private void afficher(){
        List<Category>  categories = new Category_Service().READALL().values().stream().collect(Collectors.toList());
        _categories_.getItems().clear();
        _categories_.getItems().setAll(categories);
        List<Sub_Category>  subs = new Sub_Category_Service().READALL().values().stream().collect(Collectors.toList());
        sub_categories.getItems().setAll(subs);
        Sub_Category.clear();
        add.setVisible(true);
        update.setVisible(false);
        delete.setVisible(false);
    }
    private Sub_Category updating;
    @FXML
    private void initData(MouseEvent event) {
        Sub_Category.setText(sub_categories.getSelectionModel().getSelectedItem().getName());
        updating = sub_categories.getSelectionModel().getSelectedItem();
        Category cat = new Category();
        cat.setId(sub_categories.getSelectionModel().getSelectedItem().getCategory_id());
        _categories_.setValue(cat);
        add.setVisible(false);
        update.setVisible(true);
        delete.setVisible(true);
    }

    @FXML
    private void update_(ActionEvent event) {
        updating.setCategory_id(_categories_.getSelectionModel().getSelectedItem().getId());
        updating.setName(Sub_Category.getText());
        new Sub_Category_Service().MODIFY(updating);
        new Alert(Alert.AlertType.INFORMATION, "Sub Category updated", ButtonType.OK).show();
        afficher();
    }

    @FXML
    private void delete_(ActionEvent event) {
         new Sub_Category_Service().DELETE(updating);
       afficher();
         new Alert(Alert.AlertType.INFORMATION, "Sub Category Deleted", ButtonType.OK).show();
    }
    
}
