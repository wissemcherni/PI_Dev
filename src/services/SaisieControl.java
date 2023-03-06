/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import utils.DataSource;

/**
 *
 * @author user
 */
public class SaisieControl {
        private Connection cnx = DataSource.getInstance().getCnx();

    
      // Vérifie si le champ est vide ou non
    public static boolean estNonVide(TextField textField, String messageErreur) {
        boolean estValide = !textField.getText().trim().isEmpty();
        if (!estValide) {
            afficherAlerte(Alert.AlertType.ERROR, messageErreur);
            textField.requestFocus();
        }
        return estValide;
    }

    // Vérifie si le champ est unique ou non
    public static boolean estUnique(TextField textField, String messageErreur, String valeur) {
        boolean estValide = true;
        // recherche dans la base de données si la valeur existe déjà
        // si oui, estValide devient false
        if (valeur.equals(textField.getText())) {
            return true;
        }
        if (!estValide) {
            afficherAlerte(Alert.AlertType.ERROR, messageErreur);
            textField.requestFocus();
        }
        return estValide;
    }

    // Vérifie si la longueur du champ est valide
    public static boolean estLongueurValide(TextField textField, String messageErreur, int longueur) {
        boolean estValide = textField.getText().trim().length() <= longueur;
        if (!estValide) {
            afficherAlerte(Alert.AlertType.ERROR, messageErreur);
            textField.requestFocus();
        }
        return estValide;
    }

    // Afficher une alerte avec le message d'erreur
    private static void afficherAlerte(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean verifierUnicite(String valeur) {
    boolean estUnique = true;
    String requete = "SELECT * FROM table WHERE secteur = ?";
    try {
        PreparedStatement statement = cnx.prepareStatement(requete);
        statement.setString(1, valeur);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            estUnique = false;
        }
        result.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return estUnique;
}

    
}
    
