package production.x_change.Services.User_Module;

import production.x_change.Models.Profile;
import production.x_change.Models.User;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

public class Profile_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();

    public Profile findOrCreate(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT USER_ID FROM PROFILE WHERE USER_ID = ? ");
            ps.setString(1,u.getId());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO PROFILE (ID,USER_ID) VALUES (?,?)");
                String ID = UUID.randomUUID().toString();
                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, u.getId());
                preparedStatement.execute();
            }
            return new Profile(u.getId());

        }catch (Exception ignored){
            return null;
        }
    }
    public Profile UPDATE(Profile profile){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PROFILE SET F_NAME = ? , L_NAME = ?  ,CONTACT = ? ,BIRTHDATE = ?  WHERE USER_ID = ?");
            ps.setString(1, profile.getF_name());
            ps.setString(2, profile.getL_name());
            ps.setString(3, profile.getContact());
            ps.setTimestamp(4, profile.getBirthdate());
            ps.setString(5,profile.getUser_id());
            ps.execute();
            return profile;
        }catch (Exception ignored){
            System.out.println(ignored);
            return null;
        }
    }
    public Profile READONE(User user) {
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PROFILE WHERE USER_ID = ? LIMIT 1");
            ps.setString(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Profile(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6));
            }
            return null;
        }catch(Exception ignored){
            return null;
        }
    }
    public HashMap<Integer,Profile> READALL(){
        try{
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PROFILE WHERE 1");
            int i = 0;
            HashMap<Integer,Profile> profiles = new HashMap<>();
            while(rs.next()){
                profiles.put(++i,new Profile(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6)));
            }
            return profiles;
        }catch (Exception ignored){
            return null;
        }
    }
}
