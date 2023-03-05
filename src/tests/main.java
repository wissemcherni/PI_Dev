/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tests;
import entities.categorie;
import entities.event;
import entities.achatticket;
import service.*;


/**
 *
 * @author Maha Maatoug
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
         serviceevent sv1 = new serviceevent();
          sv1.ajouter(new event("Jasser", "Wissem"));
          //sv1.ajouter(new event(50,"Jasser", "Wissem",1500));
        //   sv1.ajouter(new event(50,"LAC", "MAHA",10));
        //     servicecategorie sc1 = new servicecategorie();
           //  sc1.ajouter(new categorie((50), "Wissem"));
          //  sc1.modifier(new categorie(5, "info"));
     //   sv1.modifier(new event(5, "MAHA", "MAHOUTA",60));
       // sv1.supprimer(new event(50));
       // System.out.println(sv1.afficher());
         serviceachatticket sa1 = new serviceachatticket();
         sa1.ajouter(new achatticket(5,6,8,9));
       
           
    }
}
