/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Entity;

/**
 *
 * @author elaab
 */
public class Produit {
    private int id;

    public Produit(String nom, int prix, int user_id) {
        this.nom = nom;
        this.prix = prix;
        this.user_id = user_id;
    }

    public Produit(int id, String nom, int prix, int user_id) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.user_id = user_id;
    }
    private String nom;
    private int prix;
    private int user_id;
  
    @Override
    public String toString() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
}
