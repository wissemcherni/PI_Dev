/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author wissem
 */
public class livraison {
   private int id ;
    public commande commande ;
    private int id_livreur ;
    private LocalDate DATE ;
    
    public livraison() {
    }

    public livraison( commande commande, int id_livreur, LocalDate DATE) {
        this.commande = commande;
        this.id_livreur = id_livreur;
        this.DATE = DATE;
    }

    public livraison(int id, commande commande, int id_livreur, LocalDate DATE) {
        this.id = id;
        this.commande = commande;
        this.id_livreur = id_livreur;
        this.DATE = DATE;
    }

    

    public commande getCommande() {
        return commande;
    }

    public void setCommande(commande commande) {
        this.commande = commande;
    }
    

    public int getId() {
        return id;
    }

   
    public int getId_livreur() {
        return id_livreur;
    }

    public LocalDate getDATE() {
        return DATE;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setDATE(LocalDate DATE) {
        this.DATE = DATE;
    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 97 * hash + this.id;
//        hash = 97 * hash + this.commande;
//        hash = 97 * hash + this.id_livreur;
//        hash = 97 * hash + Objects.hashCode(this.DATE);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final livraison other = (livraison) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (this.commande != other.commande) {
//            return false;
//        }
//        if (this.id_livreur != other.id_livreur) {
//            return false;
//        }
//        return Objects.equals(this.DATE, other.DATE);
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final livraison other = (livraison) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_livreur != other.id_livreur) {
            return false;
        }
        if (!Objects.equals(this.commande, other.commande)) {
            return false;
        }
        return Objects.equals(this.DATE, other.DATE);
    }

    @Override
    public String toString() {
        return "livraison{" + "id=" + id + ", id_commande=" + commande.getId_commande() + ", id_livreur=" + id_livreur + ", DATE=" + DATE + '}';
    }
     
    
    
    
}
