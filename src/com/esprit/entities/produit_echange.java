/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author wissem
 */
public class produit_echange {
    private int id ;
    private int id_produit ;
    private int id_commande ;
    private String type ;
    
    private enum type{
        emeteur,recepteur;
    }

    public produit_echange() {
    }

    public produit_echange(int id_produit, int id_commande, String type) {
        this.id_produit = id_produit;
        this.id_commande = id_commande;
        this.type = type;
    }

    public produit_echange(int id, int id_produit, int id_commande, String type) {
        this.id = id;
        this.id_produit = id_produit;
        this.id_commande = id_commande;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getId_commande() {
        return id_commande;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + this.id_produit;
        hash = 11 * hash + this.id_commande;
        hash = 11 * hash + Objects.hashCode(this.type);
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
        final produit_echange other = (produit_echange) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (this.id_commande != other.id_commande) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return "produit_echange{" + "id=" + id + ", id_produit=" + id_produit + ", id_commande=" + id_commande + ", type=" + type + '}';
    }
    
    
}
