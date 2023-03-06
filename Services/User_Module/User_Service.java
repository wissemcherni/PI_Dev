package production.x_change.Services.User_Module;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import production.x_change.Main.Main;
import production.x_change.Models.Access_Token;
import production.x_change.Models.Role;
import production.x_change.Models.User;
import production.x_change.Services.IService;
import production.x_change.Tasks.Auth_Token_Task;
import production.x_change.Utils.AuthProvider;
import production.x_change.Utils.BCrypt;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class User_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();

    public Access_Token LOGIN(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM USER WHERE EMAIL = ? LIMIT 1");
            ps.setString(1,u.getEmail().toLowerCase());
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                if (BCrypt.checkpw(u.getPassword(), rs.getString("password"))){
                    User user = new User(rs.getString("id"));
                    Main.setUser(user);
                    Auth_Token_Task task = new Auth_Token_Task(user);
                    Thread t = new Thread(task);
                    t.setDaemon(true);
                    t.start();
                    List<Access_Token> tokens = new ArrayList<>();
                    task.valueProperty().addListener((observableValue, old, new_token) -> {
                            if(new_token!= null){
                                tokens.add(new_token);
                            }
                    });
                    while(t.isAlive() || tokens.isEmpty()){
                    }
                    return tokens.get(0);
                }
            }
            return null;
        }catch (Exception ignored){
            System.out.println(ignored.getLocalizedMessage());
            System.out.println("here?");
            return null;
        }
    }
    public Access_Token CREATE(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO USER (id,email,password) values (?,?,?) ");
            u.setId(UUID.randomUUID().toString());
            ps.setString(1, u.getId());
            ps.setString(2,u.getEmail());
            String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt(13));
            ps.setString(3, hashed);
            ps.execute();
                if (LOGIN(u)!=null){
                    return new Access_Token(Main.getAccess_Token());
                }
                else {
                    DELETE(u);
                    return null;
                }

        }catch (Exception ignored){
            return null;
        }
    }
    public User READONE(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM USER WHERE ID = ? LIMIT 1");
            ps.setString(1,u.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getString(1),rs.getString(2),rs.getString(3));
            }else {
                return null;
            }
        }catch (Exception ignored){
            return null;
        }
    }
    public HashMap<Integer,User> READALL(){
        try {
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM USER WHERE 1");
            HashMap<Integer,User> users = new HashMap<>();
            int i = 0;
            while (rs.next()){
                users.put(++i,new User(rs.getString(1), rs.getString(2),rs.getString(3) ));
            }
            return  users;
        }catch (Exception ignored){
            return null;
        }
    }
    public boolean DELETE (User u){
        try {
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM USER WHERE ID = ?");
            ps.setString(1,u.getId());
            ps.execute();
            return true;
        }catch (Exception ignored){
            return false;
        }
    }
    public User MODIFY(User u){
        try {
            PreparedStatement ps = cnx.prepareStatement("UPDATE USER SET EMAIL = ?, PASSWORD = ? WHERE ID = ? ");
            ps.setString(1,u.getEmail());
            String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt(13));
            ps.setString(2, hashed);
            ps.setString(3,u.getId());
            ps.execute();
            return u;
        }catch (Exception ignored){
            return null;
        }
    }


}
