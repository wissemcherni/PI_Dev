/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Boutique;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        String req = "UPDATE  Boutique SET surface='"+b.getSurface()+"', localisation= '"+b.getLocalisation()+"', etat= '"+b.getEtat()+"', descriptionb= '"+b.getDescriptionb()+"' WHERE secteur= '"+b.getSecteur()+"'";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("boutique modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(String p) {
        String req = "DELETE FROM Boutique WHERE secteur= '"+p+"'";
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
  public boolean existeDeja(String type) {
    // établir une connexion à la base de données
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean existe = false;
    try {
        // préparer la requête SQL pour chercher un enregistrement avec le même type
        ps = cnx.prepareStatement("SELECT * FROM Boutique WHERE secteur = ?");
        ps.setString(1, type);
        // exécuter la requête et vérifier s'il y a des résultats
        rs = ps.executeQuery();
        if (rs.next()) {
            existe = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // fermer la connexion et les ressources JDBC
      //  if (rs != null) try { rs.close(); } catch (SQLException e) {}
        //if (ps != null) try { ps.close(); } catch (SQLException e) {}
        //if (cnx != null) try { cnx.close(); } catch (SQLException e) {}
    }
    return existe;
}
public static boolean estUniquementDesLettres(String chaine) {
    // Expression régulière pour matcher des lettres en minuscules et majuscules
    String regex = "[a-zA-Z]+";
    return chaine.matches(regex);
}

    @Override
    public Boutique rechercher(String p) {
       Boutique b=null ;
    
        String req = "SELECT * FROM Boutique WHERE `secteur` ='"+ p+"' ;";
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
    
    }






}