package production.x_change.Services.User_Module;

import production.x_change.Main.Main;
import production.x_change.Models.Access_Token;
import production.x_change.Models.User;
import production.x_change.Utils.BCrypt;
import production.x_change.Utils.DataSource;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Access_Token_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Access_Token CREATE(Access_Token access_token){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO PERSONAL_ACCESS_TOKEN (ID,USER_ID,TOKEN,_DEVICE_,created_at) VALUES (?,?,?,?,?)");
            access_token.setId(UUID.randomUUID().toString());
            ps.setString(1,access_token.getId());
            ps.setString(2,access_token.getUser_id());
            String token = BCrypt.hashpw(access_token.getToken(), BCrypt.gensalt(13));
            ps.setString(3,token);
            ps.setString(4,access_token.getDevice());
            Timestamp now = new Timestamp(System.currentTimeMillis());
            Main.setAccessTokenTime(format.format(now));
            ps.setTimestamp(5,now);
            ps.executeUpdate();
            return access_token;
        }catch (Exception ignored){
            return null;
        }
    }

    public Access_Token READONE(String id, String access_token, String token_time) {
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT ID,TOKEN FROM PERSONAL_ACCESS_TOKEN WHERE user_id = ? and  DELETED_AT is null and _DEVICE_ = 'SOFTWARE' and created_at = ?");
            ps.setString(1,id);
            ps.setString(2,token_time);
            ResultSet rs = ps.executeQuery();
            HashSet<Access_Token> tokens = new HashSet<>();
            while (rs.next()){
                    tokens.add(new Access_Token(rs.getString("ID"),rs.getString("TOKEN")));
            }
            return  tokens.stream().filter(token -> BCrypt.checkpw(access_token,token.getToken())).findAny().get();
        }catch (Exception ignored){
            return null;
        }
    }
    public void REVOKE(Access_Token token){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PERSONAL_ACCESS_TOKEN SET DELETED_AT = CURRENT_TIMESTAMP() WHERE ID = ?  ");
            ps.setString(1,token.getId());
            ps.executeUpdate();
        }catch (Exception ignored){

        }
    }
    public void DELETE(String id, String access_token, String token_time){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PERSONAL_ACCESS_TOKEN SET DELETED_AT = CURRENT_TIMESTAMP() WHERE ID = ? ");
            ps.setString(1,READONE(id,access_token,token_time).getId());
            ps.execute();
        }catch (Exception ignored){
        }
    }
    public HashMap<Integer,Access_Token> READALL(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PERSONAL_ACCESS_TOKEN WHERE USER_ID = ? ORDER BY CREATED_AT DESC");
            ps.setString(1,u.getId());
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Access_Token> tokens = new HashMap<>();
            int i = 0;
            while(rs.next()){
                tokens.put(++i,new Access_Token(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getTimestamp(6)));
            }
            return tokens;
        }catch (Exception ignored){
            return null;
        }
    }
}
