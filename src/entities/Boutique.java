/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Boutique {
    
 
    private int id;
    private int surface;
    private String localisation;
    private String secteur;
    private String etat;
    private String descriptionb;

    public Boutique(int surface, String localisation, String etat, String descriptionb) {
        this.surface = surface;
        this.localisation = localisation;
        this.etat = etat;
        this.descriptionb = descriptionb;
    }
    

    public Boutique(int surface, String localisation, String secteur, String etat, String descriptionb) {
        this.surface = surface;
        this.localisation = localisation;
        this.secteur = secteur;
        this.etat = etat;
        this.descriptionb = descriptionb;
    }
    

    public Boutique(String localisation, String secteur, String etat, String descriptionb) {
        this.localisation = localisation;
        this.secteur = secteur;
        this.etat = etat;
        this.descriptionb = descriptionb;
    }
    

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescriptionb() {
        return descriptionb;
    }

    public void setDescriptionb(String descriptionb) {
        this.descriptionb = descriptionb;
    }
    

    public Boutique(int id, int surface, String localisation, String secteur, String etat, String description) {
        this.id = id;
        this.surface = surface;
        this.localisation = localisation;
        this.secteur = secteur;
        this.etat = etat;
        this.descriptionb = description;
    }
    
    

    public Boutique() {
    }
    

    public Boutique(int surface, String localisation) {
        this.surface = surface;
        this.localisation = localisation;
    }
    

    public Boutique(int id) {
        this.id = id;
    }
    

    public Boutique(int id, int surface, String localisation) {
        this.id = id;
        this.surface = surface;
        this.localisation = localisation;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.surface;
        hash = 71 * hash + Objects.hashCode(this.localisation);
        hash = 71 * hash + Objects.hashCode(this.secteur);
        hash = 71 * hash + Objects.hashCode(this.etat);
        hash = 71 * hash + Objects.hashCode(this.descriptionb);
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
        final Boutique other = (Boutique) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.surface != other.surface) {
            return false;
        }
        if (!Objects.equals(this.localisation, other.localisation)) {
            return false;
        }
        if (!Objects.equals(this.secteur, other.secteur)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return Objects.equals(this.descriptionb, other.descriptionb);
    }

    @Override
    public String toString() {
        return "Boutique{" + "id=" + id + ", surface=" + surface + ", localisation=" + localisation + ", secteur=" + secteur + ", etat=" + etat + ", descriptionb=" + descriptionb + '}';
    }

 
   
  

    
    
}

  


