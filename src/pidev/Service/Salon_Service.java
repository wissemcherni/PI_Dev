/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.Service;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pidev.Entity.Produit;
import pidev.Entity.Salon;
import pidev.Utils.DataSource;


/**
 *
 * @author elaab
 */
public class Salon_Service implements IService<Salon> {

    
    private final Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Salon t) {
        System.out.println("inserting");
        try {
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO SALON (produit_id,date_expiration,description,max_jetons) VALUES (?,?,?,?)");
            ps.setInt(1, t.getProduit_id());
            ps.setDate(2, t.getDate_expiration());
            ps.setString(3, t.getDescription());
            ps.setInt(4, t.getMax_jetons());
            ps.executeUpdate();
            System.out.println("ajout effectueé ");
        } catch (SQLException ignored) {
            System.out.println(ignored.getMessage());
        }
        
    }

    @Override
    public void supprimer(Salon t) {
        try {
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM SALON WHERE ID = ?");
            ps.setInt(1, t.getId());
            ps.executeUpdate();
        } catch (SQLException ignored) {

        }
    }

    @Override
    public void modifier(Salon t) {
        try {
            if (JOptionPane.showConfirmDialog(null, "confirmer la modification", "modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                PreparedStatement ps = cnx.prepareStatement("UPDATE `salon` SET produit_id= ?,date_expiration= ?,description= ?,max_jetons= ? WHERE id = ?");
                ps.setInt(1, t.getProduit_id());
                ps.setDate(2, t.getDate_expiration());
                ps.setString(3, t.getDescription());
                ps.setInt(4, t.getMax_jetons());
                ps.setInt(5, t.getId());
                System.out.println(t);
                //int x = ps.executeUpdate();
                System.out.println("t" + ps.execute());
                //System.out.println(x);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "erreur de modifier!!!");
            {

                System.out.println(e);
                System.out.println(e.getMessage());

            }
        }
    }

    public List<Salon> afficher() {
        List<Salon> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM Salon where date_expiration > CURRENT_DATE;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Salon s = new Salon();
                s.setId(rs.getInt("id"));
              //  s.setDate_ajout(rs.getTimestamp("date_ajout"));
                s.setDate_expiration(rs.getDate("date_expiration"));
                s.setDescription(rs.getString("description"));
                s.setMax_jetons(rs.getInt("max_jetons"));
                s.setProduit_id(rs.getInt("produit_id"));
                s.setP(getProduit(s));
                list.add(s);
            }
            System.out.println("Salon !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    /*   
  @Override
   public HashMap<Integer, Salon> afficher() {
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SALON");
            HashMap<Integer, Salon> salons = new HashMap<>();
            int i = 0;
            while (rs.next()) {
                salons.put(++i, new Salon(rs.getInt("id"), rs.getInt(2), rs.getString(4), rs.getDate(3), rs.getInt(5), rs.getTimestamp(6)));
            }
            return salons;
        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
            return null;
        }
    }
     */
    public Produit getProduit(Salon s) {
        try {
            PreparedStatement ps = cnx.prepareStatement("select * from produit where id = ? ");
            ps.setInt(1, s.getProduit_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Produit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
            return null;
        } catch (Exception ignored) {
            return null;
        }
    }

    // public User getUser(Salon s) {
    //   try {
    //         PreparedStatement ps = cnx.prepareStatement("select u.* from user u inner join produit p inner join salon s where p.id = ? and p.user_id = u.id limit 1 ");
    //     ps.setInt(1, s.getProduit_id());
    //   ResultSet rs = ps.executeQuery();
    // if (rs.next()) {
    //   return new User(rs.getInt(1), rs.getString(2));
    //}
    //return null;
    //} catch (SQLException ignored) {
    //  return null;
    //}
/*
    @Override
    public HashMap<Integer, Salon> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
     */
    @Override
    public List<Salon> Afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
public Printable generatePrintable(Salon salon) {
    return new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }
            graphics.drawString("Description : " + salon.getDescription(), 100, 100);
            graphics.drawString("Date d'expiration : " + salon.getDateExpiration().toString(), 100, 120);
            graphics.drawString("Nombre maximal de jetons : " + salon.getMaxJetons(), 100, 140);
            graphics.drawString("Date d'ajout : " + salon.getDateAjout().toString(), 100, 160);
            return PAGE_EXISTS;
        }
    };
}
   /*
    public void sendEmail(String recipient, String subject, String body) throws MessagingException {
        // Créer les propriétés pour la connexion SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Créer une session pour la connexion SMTP
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("votre-email@gmail.com", "votre-mot-de-passe");
            }
        });

        // Créer le message à envoyer
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("votre-email@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(body);

        // Envoyer le message
        Transport.send(message);
    }}
    */
    // ...



}


