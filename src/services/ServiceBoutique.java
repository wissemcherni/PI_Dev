/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Boutique;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author user
 */
public class ServiceBoutique implements IService<Boutique> {
    
    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Boutique p) {
         System.out.println("aaaaa");
        String req = "INSERT INTO `Boutique` (`surface`, `localisation`, `secteur`, `etat`, `descriptionb`) VALUES('"+p.getSurface()+"', '"+p.getLocalisation()+"' , '"+p.getSecteur()+"', '"+p.getEtat()+"', '"+p.getDescriptionb()+"');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Boutique ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Boutique b ) {
        String req = "UPDATE  Boutique SET surface='"+b.getSurface()+"', localisation= '"+b.getLocalisation()+"', secteur= '"+b.getSecteur()+"', etat= '"+b.getEtat()+"', descriptionb= '"+b.getDescriptionb()+"' WHERE id="+b.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("boutique modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int p) {
        String req = "DELETE FROM Boutique WHERE id='"+p+"'";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Boutique supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Boutique> afficher() {
        List<Boutique> list = new ArrayList<>();
        
        String req = "SELECT * FROM Boutique";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Boutique(result.getInt("id"), result.getInt("surface"), result.getString("localisation"), result.getString("secteur"), result.getString("etat"), result.getString("descriptionb")));
               
            }
            System.out.println("Boutique récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    @Override
    public Boutique rechercher(int p) {
       Boutique b=null ;
    
        String req = "SELECT * FROM Boutique WHERE `id` ='"+ p+"' ;";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                b=(new Boutique(result.getInt("id"), result.getInt("surface"), result.getString("localisation"), result.getString("secteur"), result.getString("etat"), result.getString("descriptionb")));
               
            }
            System.out.println("Boutique récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return b;
    
    }}