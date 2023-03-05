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
public class categorie {

    /**
     * @param args the command line arguments
     */
   private int id;
   private String type;
     public categorie(int id) {
        this.id = id;
    }
 public categorie(String type) {
        this.type= type;
        
    }
     
    public categorie(int id, String type) {
        this.id = id;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

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
        final categorie other = (categorie) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return "categorie{" + "id=" + id + ", type=" + type + '}';
    }
    

}
