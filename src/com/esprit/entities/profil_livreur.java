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
public class profil_livreur {
    private int id_livreur ;
    private String secteur ;
    private String volume ;
    private String moy_livraison ; 

    public profil_livreur() {
    }

    public profil_livreur(String secteur, String volume, String moy_livraison) {
        this.secteur = secteur;
        this.volume = volume;
        this.moy_livraison = moy_livraison;
    }

    public profil_livreur(int id_livreur, String secteur, String volume, String moy_livraison) {
        this.id_livreur = id_livreur;
        this.secteur = secteur;
        this.volume = volume;
        this.moy_livraison = moy_livraison;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public String getSecteur() {
        return secteur;
    }

    public String getVolume() {
        return volume;
    }

    public String getMoy_livraison() {
        return moy_livraison;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setMoy_livraison(String moy_livraison) {
        this.moy_livraison = moy_livraison;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id_livreur;
        hash = 19 * hash + Objects.hashCode(this.secteur);
        hash = 19 * hash + Objects.hashCode(this.volume);
        hash = 19 * hash + Objects.hashCode(this.moy_livraison);
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
        final profil_livreur other = (profil_livreur) obj;
        if (this.id_livreur != other.id_livreur) {
            return false;
        }
        if (!Objects.equals(this.secteur, other.secteur)) {
            return false;
        }
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        return Objects.equals(this.moy_livraison, other.moy_livraison);
    }

    @Override
    public String toString() {
        return "profil_livreur{" + "id_livreur=" + id_livreur + ", secteur=" + secteur + ", volume=" + volume + ", moy_livraison=" + moy_livraison + '}';
    }
    
    
}
