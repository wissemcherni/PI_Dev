/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion_produit;

import gestion_produit.entities.Category;
import gestion_produit.entities.Pricing;
import gestion_produit.entities.Product;
import gestion_produit.entities.Sub_Category;
import gestion_produit.services.Category_Service;
import gestion_produit.services.Product_Service;
import gestion_produit.services.Sub_Category_Service;
import gestion_produit.services.pricing_services;
import java.util.UUID;

/**
 *
 * @author Mohamed Akrem
 */
public class Gestion_produit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
     
     // *********************Pricing*********************************
    // pricing_services service  = new pricing_services();
    // Pricing pricing = new Pricing("1410455a-ee7f-4e90-87b8-28e82f3fe3fb", 6.6, null);
    // service.CREATE(pricing);
    
    
  
    
  
   
            /// new Category_Service().MODIFY(new Category( "Category22 ","b8f084be-a259-4ff3-99d5-ca0f58c52b42"));
            
                // *********************Category*********************************
  //  new Category_Service().CREATE(new Category( "Category122 "));
     //  new Category_Service().CREATE(new Category( "Category1 "));
  //   new Category_Service().MODIFY(new Category("3f940f52-8ead-49f8-a070-682d6fd44421","Categorie ***22-23"));
            
            //************** sub_category***************** ; 
     //  new Sub_Category_Service().CREATE(new Sub_Category("Sub category1", "43ede3b9-5d30-4f5f-8598-01d0627e4bfe"));
    // new Sub_Category_Service().DELETE(new sub_category("");
     //  new Sub_Category_Service().CREATE(new Sub_Category("Sub category1", "43ede3b9-5d30-4f5f-8598-01d0627e4bfe"));
    
    
    //**************Product***************** ;  
   
    //new Product_Service().CREATE(new Product("aaaaaaaaaaaa", "Ghali barsha barcha barcha", "4a815466-4ab2-4d40-93e8-298dac928011", 88, "5c0515f7-79e0-4f84-a998-bb2c9a8f048a", "30.000", "25.0255"));
    //new Product_Service().MODIFY(new Product("58a9df32-4cd8-4a65-a994-adb9cc9f2d65", "name produit 1", "description","4a815466-4ab2-4d40-93e8-298dac928011",88,"5c0515f7-79e0-4f84-a998-bb2c9a8f048a", "30.000", "25.0255"));
   //new Product_Service().CREATE(new Product("iPhone 15 Pro ++ MAX", "Ghali barsha barcha barcha", "4a815466-4ab2-4d40-93e8-298dac928011", 88, "5c0515f7-79e0-4f84-a998-bb2c9a8f048a", "30.000", "25.0255"));
    // new Product_Service().DELETE(new product("")  );
   // System.out.println(new Product_Service().READALL());
   
       System.out.println(" afficher produit");
   System.out.println(new Product_Service().READALL());
   System.out.println("*****************************************************");
   System.out.println(" afficher category");
    System.out.println("*****************************************************");
   System.out.println(new Category_Service().READALL());
   System.out.println(" sub category");
    System.out.println("*****************************************************");
       
            
            
            
    }
    
}
