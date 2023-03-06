package production.x_change.Services.User_Module;

import production.x_change.Models.Password_Reset;
import production.x_change.Models.User;
import production.x_change.Utils.BCrypt;
import production.x_change.Utils.DataSource;
import production.x_change.Utils.MailerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public class Password_Reset_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();
    public Password_Reset CREATE(Password_Reset reset){
        try{
            UPDATE(reset);
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO PASSWORD_RESET (id,email,token,expire_at) VALUES (?,?,?,?)");
            reset.setId(UUID.randomUUID().toString());
            MailerService ms = new MailerService();
            ms.replyMail(reset.getEmail(), reset.getEmail(),reset.getToken(),"Password Reset Attempt");
            ps.setString(1,reset.getId());
            ps.setString(2,reset.getEmail());
            ps.setString(3, BCrypt.hashpw(reset.getToken(),BCrypt.gensalt(13)));
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(30)));
            ps.executeUpdate();
            return reset;
        }catch (Exception ignored){
            return null;
        }
    }
    private void UPDATE(Password_Reset reset){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PASSWORD_RESET SET status = -1 where email = ?");
            ps.setString(1,reset.getEmail());
            ps.executeUpdate();
        }catch (Exception ignored){
        }
    }
    public Password_Reset READONE(Password_Reset reset){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * from PASSWORD_RESET WHERE ID = ? and status = 0 and expire_at<current_timestamp()");
            ps.setString(1,reset.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Password_Reset(rs.getString(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getInt(5));
            }return null;
        }catch (Exception ignored){
            return null;
        }
    }
    public HashMap<Integer,Password_Reset> READALL(User user){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PASSWORD_RESET WHERE EMAIL = ? ORDER BY EXPIRE_AT DESC ");
            ps.setString(1,user.getEmail());
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Password_Reset> password_resets  = new HashMap<>();
            int i = 0;
            while(rs.next()){
                password_resets.put(++i,new Password_Reset(rs.getString(5),rs.getString(1),rs.getString(2),rs.getTimestamp(3),rs.getInt(4)));
            }
            return password_resets;
        }catch (Exception ignored){
            return null;
        }
    }
}
