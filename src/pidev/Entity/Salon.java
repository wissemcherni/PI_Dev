/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Entity;

import java.sql.Date;
import java.sql.Timestamp;
import pidev.Service.Salon_Achat_Service;
import pidev.Service.Salon_Service;

/**
 *
 * @author elaab
 */
public class Salon {
    private int id;
    private Produit p;

    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public Salon() {
    }

    public Salon(int id) {
        this.id = id;
    }
    private int produit_id;
    private String description;
    private Date date_expiration;
    private int max_jetons;
    private Timestamp date_ajout;
      private String to;
    private String from;
    private String subject;
    private String body;

    public Salon(Timestamp timestamp, String string, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Timestamp getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Timestamp date_ajout) {
        this.date_ajout = date_ajout;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public int getMax_jetons() {
        return max_jetons;
    }

    public void setMax_jetons(int max_jetons) {
        this.max_jetons = max_jetons;
    }

    public Salon(int id, int produit_id, String description, Date date_expiration, int max_jetons,Timestamp t) {
        this.id = id;
        this.produit_id = produit_id;
        this.description = description;
        this.date_expiration = date_expiration;
        this.max_jetons = max_jetons;
        this.date_ajout = t;
    }

    public Salon(int produit_id, String description, Date date_expiration, int max_jetons) {
        this.produit_id = produit_id;
        this.description = description;
        this.date_expiration = date_expiration;
        this.max_jetons = max_jetons;
    }

    public Salon(int id, Produit p, int produit_id, String description, Date date_expiration, int max_jetons, Timestamp date_ajout, String to, String from, String subject, String body) {
        this.id = id;
        this.p = p;
        this.produit_id = produit_id;
        this.description = description;
        this.date_expiration = date_expiration;
        this.max_jetons = max_jetons;
        this.date_ajout = date_ajout;
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
    }
    

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
   
    
    //totqal mta les jetons
   /* public Integer getTotal_Achat(){
        return ((new Salon_Achat_Service().afficher(new Salon_Achat(id))).values().stream().mapToInt(achat->achat.getQuantity()).sum());
    }
*/
    @Override
    public String toString() {
        return "Salon{" + "id=" + id + ", produit_id=" + produit_id + ", description=" + description + ", date_expiration=" + date_expiration + ", max_jetons=" + max_jetons + ", date_ajout=" + date_ajout + '}';
    }

    public Object getDateExpiration() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaxJetons() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getDateAjout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
