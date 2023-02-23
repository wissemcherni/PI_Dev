/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Cathegorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**descriptionc 
 *
 * @author userp.getDescriptionc
 */
public class ServiceCathegorie implements IService<Cathegorie> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Cathegorie p) {
        String req = "INSERT INTO Cathegorie(type) VALUES('"+p.getType()+"','"+p.getDescriptionc()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Cathegorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Cathegorie p) {
        String req = "UPDATE  Cathegorie SET Type= '"+p.getType()+"''"+p.getDescriptionc()+"' WHERE id="+p.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Cathegorie modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Cathegorie p) {
        String req = "DELETE FROM Cathegorie WHERE id="+p.getId();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Cathegorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Cathegorie> afficher() {
        List<Cathegorie> list = new ArrayList<>();
        
        String req = "SELECT * FROM Cathegorie";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
               list.add(new Cathegorie(result.getInt("id"), result.getString("type"), result.getString("descriptionc")));
            
            }
            System.out.println("Cathegorie récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}

    
    
    
