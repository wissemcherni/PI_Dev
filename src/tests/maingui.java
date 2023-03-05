/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tests;
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
 * @author Maha Maatoug
 */
public class maingui  extends Application{
     @Override
    public void start(Stage primaryStage) throws IOException {
    //  FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutevent.fxml"));
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutachatticket.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Workshop PIDEV");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        launch(args);
    }
}
