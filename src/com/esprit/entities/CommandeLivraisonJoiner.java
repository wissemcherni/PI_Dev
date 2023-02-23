/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wissem
 */
public class CommandeLivraisonJoiner {
    public static List<commande> join(List<commande> commandes, List<livraison> livraisons) {
        List<commande> result = new ArrayList<>();
        for (commande commande : commandes) {
            for (livraison livraison : livraisons) {
                if (commande.getId_commande() == livraison.getCommande().getId_commande()) { 
                    commande.setLivraison(livraison);
                    break;
                }
            }
            result.add(commande);
        }
        return result;
    }
    
}
