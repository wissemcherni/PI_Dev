/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author wissem
 */
public class livraison {
   private int id ;
    private int id_commande ;
    private int id_livreur ;
    private Date DATE ;

    public livraison() {
    }

    public livraison(int id_commande, int id_livreur, Date DATE) {
        this.id_commande = id_commande;
        this.id_livreur = id_livreur;
        this.DATE = DATE;
    }

    public livraison(int id, int id_commande, int id_livreur, Date DATE) {
        this.id = id;
        this.id_commande = id_commande;
        this.id_livreur = id_livreur;
        this.DATE = DATE;
    }

    public int getId() {
        return id;
    }

    public int getId_commande() {
        return id_commande;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.id_commande;
        hash = 97 * hash + this.id_livreur;
        hash = 97 * hash + Objects.hashCode(this.DATE);
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
        if (this.id_commande != other.id_commande) {
            return false;
        }
        if (this.id_livreur != other.id_livreur) {
            return false;
        }
        return Objects.equals(this.DATE, other.DATE);
    }

    @Override
    public String toString() {
        return "livraison{" + "id=" + id + ", id_commande=" + id_commande + ", id_livreur=" + id_livreur + ", DATE=" + DATE + '}';
    }
     
    
    
    
}
