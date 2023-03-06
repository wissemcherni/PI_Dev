/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.lang.String;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author user
 */
public class StatannController implements Initializable {

    @FXML
    private PieChart PieChart;
      ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
    private Connection cnx = DataSource.getInstance().getCnx();
    
    @FXML
    private Button retourbienvenue;

   

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
    try {
        String secteur = "secteur"; // Remplacez "secteur" par la valeur que vous souhaitez.
        stat(secteur);
        PieChart.setData(data);
    } catch (SQLException ex) {
        Logger.getLogger(StatannController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void stat(String secteur) throws SQLException {
    data = FXCollections.observableArrayList();
    String requete = "SELECT c.type, b.surface " +
                     "FROM Boutique b " +
                     "INNER JOIN Cathegorie c ON b.cathegorie_id = c.id " +
                     "WHERE b.secteur = ? " +
                     "GROUP BY c.type";
    PreparedStatement pst = cnx.prepareStatement(requete);
    pst.setString(1, secteur);
    ResultSet rs = pst.executeQuery();
    double totalSurface = 0;
    while (rs.next()) {
        totalSurface += rs.getDouble("surface");
    }
    double volumineux = totalSurface * 0.3;
    double fragile = totalSurface * 0.1;
    double alimentaire = totalSurface * 0.1;
    double simple = totalSurface * 0.3;
    double autres = totalSurface * 0.2;
    rs.beforeFirst();
    while (rs.next()) {
        String type = rs.getString("type");
        double surface = rs.getDouble("surface");
        if (type.equals("Volumineux")) {
            data.add(new PieChart.Data(type, surface * volumineux / totalSurface));
        } else if (type.equals("Fragile")) {
            data.add(new PieChart.Data(type, surface * fragile / totalSurface));
        } else if (type.equals("Alimentaire")) {
            data.add(new PieChart.Data(type, surface * alimentaire / totalSurface));
        } else if (type.equals("Simple")) {
            data.add(new PieChart.Data(type, surface * simple / totalSurface));
        } else {
            data.add(new PieChart.Data(type, surface * autres / totalSurface));
        }
    }
}




    @FXML
    private void retourbienvenue(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Bienvenue.fxml"));
        Parent root = loader.load();
        PieChart.getScene().setRoot(root);
        BienvenueController dpc = loader.getController();
       
        
    }
}
