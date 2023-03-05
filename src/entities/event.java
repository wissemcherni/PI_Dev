/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Maha Maatoug
 */
public class event {

    /**
     * @param args the command line arguments
     */
     private int id;
  
    private String localisation;
      private String Description;
    private int prix;

    public event(int id) {
        this.id = id;
    }
 public event(String localisation, String Description) {
        this.localisation = localisation;
        this.Description= Description;
    }
     
    public event(int id, String localisation, String Description, int prix) {
        this.id = id;
        this.localisation= localisation;
        this.Description = Description;
        this.prix = prix;
    }

   public event( String localisation, String Description, int prix) {
  
        this.localisation= localisation;
        this.Description = Description;
        this.prix = prix;
    }

    public event() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    

    

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.localisation);
       hash = 53 * hash + Objects.hashCode(this.Description);
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
        final event other = (event) obj;
        if (!Objects.equals(this.localisation, other.localisation)) {
            return false;
        }
        return Objects.equals(this.Description, other.Description);
    }

    @Override
    public String toString() {
       return "event{" + "id=" + id + ", localisation=" + localisation + ",Description=" + Description+ " prix=" + prix + '}';
    }
}


