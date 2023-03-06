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
public class Cathegorie {
    
 private int id;
    private String type ;
    private String descriptionc ;

   

    public Cathegorie(String type, String descriptionc) {
        this.type = type;
        this.descriptionc = descriptionc;
    }

    public Cathegorie(int id, String type, String descriptionc) {
        this.id = id;
        this.type = type;
        this.descriptionc = descriptionc;
    }

    public void setDescriptionc(String descriptionc) {
        this.descriptionc = descriptionc;
    }
    

    public Cathegorie(String type) {
        this.type = type;
    }

    public Cathegorie(int id) {
        this.id = id;
    }
    

    
    public Cathegorie(int id, String type) {
        this.id = id;
        this.type = type;
    }
    

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionc() {
        return descriptionc;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.descriptionc);
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
        final Cathegorie other = (Cathegorie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.descriptionc, other.descriptionc);
    }

   
    @Override
    public String toString() {
        return "Cathegorie{" + "id=" + id + ", type=" + type + ", descriptionc=" + descriptionc + '}';
    }

    
    
    


    
}

