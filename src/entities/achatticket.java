/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package entities;

/**
 *
 * @author Maha Maatoug
 */
public class achatticket {

    /**
     * @param args the command line arguments
     */
    private int id;
    private int id_participant;
    private int nb_ticket;
   
    private int prix;
     public achatticket(int id, int id_participant, int nb_ticket,int prix) {
        this.id = id;
        this.id_participant=id_participant;
        this.nb_ticket = nb_ticket;
       
        this.prix=prix;
    }
public achatticket( int nb_ticket,int prix) {
      
        this.nb_ticket = nb_ticket;
       
        this.prix=prix;
    }
    public int getId() {
        return id;
    }

    public int getId_participant() {
        return id_participant;
    }

    public int getNb_ticket() {
        return nb_ticket;
    }

    

    public int getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_participant(int id_participant) {
        this.id_participant = id_participant;
    }

    public void setNb_ticket(int nb_ticket) {
        this.nb_ticket = nb_ticket;
    }

    

    public void setPrix(int prix) {
        this.prix = prix;
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
        final achatticket other = (achatticket) obj;
        if (this.id_participant != other.id_participant) {
            return false;
        }
        return this.nb_ticket == other.nb_ticket;
    }

    @Override
    public String toString() {
        return "achatticket{" + "nb_ticket=" + nb_ticket + ", prix=" + prix + '}';
    }
     
}

     

