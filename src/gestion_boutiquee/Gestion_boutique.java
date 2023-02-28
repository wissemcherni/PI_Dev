/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion_boutiquee;

import entities.Boutique;
import entities.Cathegorie;
import services.ServiceBoutique;
import services.ServiceCathegorie;

/**
 *
 * @author user
 */
public class Gestion_boutique {

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ServiceBoutique sb1 = new ServiceBoutique();
        
        sb1.ajouter(new Boutique(2525, "hatem"));
        sb1.ajouter(new Boutique(4,444, "Ahmed"));
        sb1.ajouter(new Boutique(1,444, "maram"));
        ServiceCathegorie sc1 = new ServiceCathegorie();
        sb1.supprimer(new Boutique(1));
        System.out.println(sb1.afficher());
        
        sc1.modifier(new Cathegorie(1,"meublembadlaa"));

        sc1.supprimer(new Cathegorie(3));
        System.out.println(sc1.afficher());
      
        //sp1.supprimer(new Personne(1));
        
    }
    
}
