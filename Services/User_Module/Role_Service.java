package production.x_change.Services.User_Module;

import production.x_change.Models.Role;
import production.x_change.Models.User;
import production.x_change.Services.IService;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

public class Role_Service implements IService<Role> {
    private final Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public Role CREATE(Role r){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO ROLE (ID,USER_ID,ROLE) VALUES (?,?,?)");
            r.setId(UUID.randomUUID().toString());
            ps.setString(1,r.getId());
            ps.setString(2,r.getUser_id());
            ps.setString(3,r.getRole());
            ps.execute();
            return r;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public HashMap<Integer, Role> READALL() {
        try{
            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("select * from role where 1");
            int i =0;
            HashMap<Integer,Role> roles = new HashMap<>();
            while(rs.next()){
                roles.put(++i,new Role(rs.getString("id"),rs.getString("user_id"),rs.getString("role")));
            }
            return roles;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public Role READONE(Role role) {
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM ROLE WHERE ID = ?");
            ps.setString(1,role.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Role(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }

    public HashMap<Integer,Role>READALL(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM ROLE WHERE USER_ID = ? ");
            ps.setString(1,u.getId());
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Role> roles = new HashMap<>();
            int i = 0;
            while(rs.next()){
                roles.put(++i,new Role(rs.getString(1),u.getId(),rs.getString(3)));
            }
            return roles;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    public boolean DELETE(Role r){
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM ROLE WHERE ID = ?");
            ps.setString(1,r.getId());
            ps.executeUpdate();
            return true;
        }catch (Exception ignored){
            return false;
        }
    }

    @Override
    public Role MODIFY(Role role) {
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE ROLE SET ROLE = ? WHERE ID = ?");
            ps.setString(1,role.getRole());
            ps.setString(2,role.getUser_id());
            if(ps.execute()){
                return role;
            }
            return null;
        }catch(Exception ignored) {
            return null;
        }
    }
}
