/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pi_dev;

import com.esprit.entities.commande;
import com.esprit.entities.livraison;
import com.esprit.entities.produit_echange;
import com.esprit.entities.profil_livreur;
import com.esprit.services.Service_commande;
import com.esprit.services.Service_livraison;
import com.esprit.services.Service_produit_echange;
import com.esprit.services.Service_profil_livreur;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author wissem
 */
public class PI_dev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Service_commande c1 =new Service_commande();
        //c1.ajouter(new commande("non_livre",1245,"test1","vente"));
        
        Service_profil_livreur pl1 =new Service_profil_livreur();
        //pl1.ajouter(new profil_livreur("megrine","300cm²","berline"));
        //pl1.ajouter(new profil_livreur("megrine","550cm²","berlingo"));
        //pl1.modifier(new profil_livreur (1,"ben arous","500cm²","berline"));
        //pl1.supprimer(new profil_livreur(1));
        Service_produit_echange pc1=new Service_produit_echange();
        //pc1.ajouter(new produit_echange(12345,45755,"emeteur"));
        //pc1.modifier(new produit_echange(3,666,777,"recepteur") );
        //pc1.supprimer(new produit_echange(2));
        //System.out.println(pc1.afficher());
        Service_livraison sl2=new Service_livraison();
       String str="2023-04-21";  
       Date date=Date.valueOf(str);//converting string into sql date   
        //sl2.ajouter(new livraison(new commande(2),132145,date));
       
    //Service_profil_livreur service = new Service_profil_livreur();
    //String secteur = "megrine";
    //int nbLivreursDansSecteur = service.filtrerParSecteur(secteur);
    //System.out.println("Nombre de livreurs dans le secteur " + secteur + " : " + nbLivreursDansSecteur);
    
    
    
/*int id_livreur = 5;
profil_livreur pl = service.chercher(id_livreur);
if (pl != null) {
    System.out.println("- Secteur : " + pl.getSecteur());
    System.out.println("- Volume : " + pl.getVolume());
    System.out.println("- Moyenne de livraison : " + pl.getMoy_livraison());
} else {
    System.out.println("Aucun profil de livreur trouvé pour cette l'ID " );
}*/
Service_profil_livreur service = new Service_profil_livreur();
    //List<profil_livreur> listeProfilLivreur = service.afficher();

    // Test de la fonction de recherche par id_livreur
    /*Optional<profil_livreur> profilLivreurTrouve = service.rechercherParId(1);
    profilLivreurTrouve.ifPresent(System.out::println); // affiche le profil livreur trouvé

    // Test de la fonction de filtre par secteur
    String secteurRecherche = "megrine";
    long nbLivreursDansSecteur = service.filtrerParSecteur(secteurRecherche, listeProfilLivreur);
    System.out.println("Il y a " + nbLivreursDansSecteur + " livreurs dans le secteur de " + secteurRecherche);*/
    
    //Service_profil_livreur service = new Service_profil_livreur();
    /*String secteurRecherche = "megrine";
    int count = service.countLivreurBySecteur(secteurRecherche);
    System.out.println("Nombre de livreurs dans le secteur de "+ secteurRecherche +" est : " + count);
    
    Optional<profil_livreur> optional = service.rechercherParId(3);
if (optional.isPresent()) {
    profil_livreur pl = optional.get();
    String secteur = pl.getSecteur();
    String volume = pl.getVolume();
    String moy_livraison = pl.getMoy_livraison();
    System.out.println("Secteur : " + secteur + " | Volume : " + volume + " | Moyenne de livraison : " + moy_livraison);
} else {
    System.out.println("Aucun profil de livreur trouvé avec l'ID_livreur spécifié");
}/*
    
   
    
    
    /*Service_commande sc = new Service_commande();
//sc.afficherParType("vente");
sc.afficherCommandesNonLivrees();*/

}
    
    
}
