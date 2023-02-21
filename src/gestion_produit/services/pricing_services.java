/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_produit.services;

import gestion_produit.IService;
import gestion_produit.entities.Pricing;
import gestion_produit.entities.Product;
import gestion_produit.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.UUID;

/**
 *
 * @author Mohamed Akrem
 */
public class pricing_services {
    
       Connection cnx = DataSource.getInstance().getCnx();
       
          public Pricing CREATE(Pricing pricing){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO Pricing (ID,product_id,price,created_at) VALUES (?,?,?,?)");
            pricing.setId(UUID.randomUUID().toString());
            ps.setString(1,pricing.getId());
            ps.setString(2,pricing.getProduct_id());
            ps.setDouble(3,pricing.getPrice());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
           
            if(ps.execute()){
                return pricing;
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    
    
  
  
    
}
