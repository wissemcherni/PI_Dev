/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gestion_boutiquee;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class mainGUI extends Application {
    
      @Override
    public void start(Stage primaryStage) throws IOException {
FXMLLoader loader = new FXMLLoader(getClass().getResource("../controller/Statann.fxml"));        
//FXMLLoader loader = new FXMLLoader(getClass().getResource("../controller/Bienvenue.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../controller/AjoutBoutique.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../controller/AjouterCathegorie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Workshop PIDEV");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
