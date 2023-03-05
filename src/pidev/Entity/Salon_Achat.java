/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Entity;

/**
 *
 * @author elaab
 */
public class Salon_Achat {
    private int id;
    private int salon_id;
    private int quantity;
    private int user_id;
    private int prix_calculer;

    public Salon_Achat() {
    }

    public Salon_Achat(int id, int salon_id, int quantity, int user_id, int prix_calculer) {
        this.id = id;
        this.salon_id = salon_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.prix_calculer = prix_calculer;
    }
    public Salon_Achat( int salon_id, int quantity, int user_id, int prix_calculer) {
       
        this.salon_id = salon_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.prix_calculer = prix_calculer;
    }

    public void setPrix_calculer(int prix_calculer) {
        this.prix_calculer = prix_calculer;
    }

    public int getPrix_calculer() {
        return prix_calculer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(int salon_id) {
        this.salon_id = salon_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
}
