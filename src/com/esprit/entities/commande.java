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
public class commande {
    private int id_commande ;
    private String statut;
    private int id_depot ;
    private String emiteur ;
    private String type ;
       
   private enum statut{
        livre,non_livre;
    }
    
   private enum type{
        echange,vente;
    }

    public commande() {
    }

    public commande(String statut, int id_depot, String emiteur, String type) {
        this.statut = statut;
        this.id_depot = id_depot;
        this.emiteur = emiteur;
        this.type = type;
    }

    public commande(int id_commande, String statut, int id_depot, String emiteur, String type) {
        this.id_commande = id_commande;
        this.statut = statut;
        this.id_depot = id_depot;
        this.emiteur = emiteur;
        this.type = type;
    }

    public int getId_commande() {
        return id_commande;
    }

    public String getStatut() {
        return statut;
    }

    public int getId_depot() {
        return id_depot;
    }

    public String getEmiteur() {
        return emiteur;
    }

    public String getType() {
        return type;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setId_depot(int id_depot) {
        this.id_depot = id_depot;
    }

    public void setEmiteur(String emiteur) {
        this.emiteur = emiteur;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_commande;
        hash = 53 * hash + Objects.hashCode(this.statut);
        hash = 53 * hash + this.id_depot;
        hash = 53 * hash + Objects.hashCode(this.emiteur);
        hash = 53 * hash + Objects.hashCode(this.type);
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
        final commande other = (commande) obj;
        if (this.id_commande != other.id_commande) {
            return false;
        }
        if (this.id_depot != other.id_depot) {
            return false;
        }
        if (!Objects.equals(this.statut, other.statut)) {
            return false;
        }
        if (!Objects.equals(this.emiteur, other.emiteur)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return "statut=" + statut + ", id_depot=" + id_depot + ", emiteur=" + emiteur + ", type=" + type + '}';
    }
    




}
