/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pidev.Entity.Salon;
import pidev.Entity.Salon_Achat;
import pidev.Entity.User;
import pidev.Utils.DataSource;

/**
 *
 * @author elaab
 */
public class Salon_Achat_Service implements IService<Salon_Achat> {

    private Connection cnx = DataSource.getInstance().getCnx();
///achat jeton bc

    @Override
    public void ajouter(Salon_Achat t) {
        try {
            PreparedStatement ps;
            ps = cnx.prepareStatement("INSERT INTO SALON_ACHAT(salon_id,quantity,user_id,prix_calcule) VALUES (?,?,?,?)");
            ps.setInt(1, t.getSalon_id());
            ps.setInt(2, t.getQuantity());
            ps.setInt(3, t.getUser_id());
            ps.setInt(4, t.getPrix_calculer());
            ps.executeUpdate();
        } catch (SQLException ignored) {

        }
    }

    @Override
    public void supprimer(Salon_Achat t) {
        try {
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM SALON_ACHAT WHERE id = ?");
            ps.setInt(1, t.getId());
            ps.executeUpdate();
        } catch (Exception ignored) {

        }
    }

    @Override
    public void modifier(Salon_Achat t) {

    }

    public User findUserById(int id) {
        try {
            String requete = "SELECT * FROM user where id = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                return u;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Salon_Achat> Afficher() {
        List<Salon_Achat> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM salon_achat";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Salon_Achat s = new Salon_Achat();
                s.setId(rs.getInt("id"));
                s.setSalon_id(rs.getInt("salon_id"));
                s.setUser_id(rs.getInt("user_id"));
                s.setPrix_calculer(rs.getInt("prix_calcule"));

                list.add(s);
            }
            System.out.println("Salon Achat !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public List<Salon_Achat> AfficherBySalon(int id) {
        List<Salon_Achat> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM salon_achat where salon_id = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Salon_Achat s = new Salon_Achat();
                s.setId(rs.getInt("id"));
                s.setSalon_id(rs.getInt("salon_id"));
                s.setUser_id(rs.getInt("user_id"));
                s.setPrix_calculer(rs.getInt("prix_calcule"));

                list.add(s);
            }
            System.out.println("Salon Achat !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public int getLastPrice() {
        try {
            String requete = "SELECT * FROM salon_achat order by id desc limit 1";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("prix_calcule");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return -1;
    }

}
/*
    public HashMap<Integer, Salon_Achat> afficher(Salon_Achat t) {
        try{
            PreparedStatement pst = cnx.prepareStatement("SELECT * FROM salon_achat where salon_id = ?");
            pst.setInt(1,t.getSalon_id());
            ResultSet rs = pst.executeQuery();
            HashMap<Integer,Salon_Achat> achats = new HashMap<>();
            int i =0 ;
            while(rs.next()){
                achats.put(++i,new Salon_Achat(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
            return achats;
        }catch(Exception ignored){
            System.out.println(ignored.getMessage());
            return null;
        }
    }
 */
 /*  @Override
    public HashMap<Integer, Salon_Achat> afficher() {
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALON where 1");
            HashMap<Integer,Salon_Achat> achats = new HashMap<>();
            int i =0 ;
            while(rs.next()){
                achats.put(++i,new Salon_Achat(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
            return achats;
        }catch(Exception ignored){
            return null;
        }    }
    
}

    @Override
    public List<Salon_Achat> Afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 }
 */
