/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pidev.Entity.Produit;
import pidev.Utils.DataSource;

/**
 *
 * @author elaab
 */
public class Produit_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();
    
    public List<Produit> READALL(){
        try{
            PreparedStatement ps = cnx.prepareStatement("select * from produit");
            ResultSet rs = ps.executeQuery();
            List<Produit> produits = new ArrayList<>(); 
            while(rs.next()){
                produits.add(new Produit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            return produits;
        }catch(Exception ignored){
            return null;
        }
    }
    
}
