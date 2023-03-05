/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Entity;

/**
 *
 * @author elaab
 */
public class User {
   private int id;
    private String name;
    private String prenom;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", prenom=" + prenom + '}';
    }

  
         public User(int id, String name, String prenom) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
         }
}
