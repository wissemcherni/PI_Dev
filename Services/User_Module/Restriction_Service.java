package production.x_change.Services.User_Module;

import production.x_change.Models.Restriction;
import production.x_change.Services.IService;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

public class Restriction_Service implements IService<Restriction> {
    private final Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public Restriction CREATE(Restriction restriction) {
        try{
            PreparedStatement ps = cnx.prepareStatement("INSET INTRO  RESTRICTION (ID,USER_ID,CAUSE,R_START,R_END) VALUES (?,?,?,?,?)");
            restriction.setId(UUID.randomUUID().toString());
            ps.setString(1,restriction.getId());
            ps.setString(2,restriction.getUser_id());
            ps.setString(3,restriction.getCause());
            ps.setTimestamp(4,restriction.getR_start());
            ps.setTimestamp(5,restriction.getR_end());
            return restriction;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public HashMap<Integer, Restriction> READALL() {
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RESTRICTION WHERE 1");
            HashMap<Integer,Restriction> restrictions = new HashMap<>();
            int i =0;
            while(rs.next()){
                restrictions.put(++i,new Restriction(rs.getString(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getTimestamp(5)));
            }
            return restrictions;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public Restriction READONE(Restriction restriction) {
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM RESTRICTION WHERE ID = ?");
            ps.setString(1,restriction.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Restriction(rs.getString(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getTimestamp(5));
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public boolean DELETE(Restriction restriction) {
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM RESTRICTION WHERE ID = ?");
            ps.setString(1,restriction.getId());
            return ps.execute();
        }catch (Exception ignored){
            return false;
        }
    }

    @Override
    public Restriction MODIFY(Restriction restriction) {
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE RESTRICTION SET USER_ID = ? , CAUSE = ? ,R_START = ?, R_END = ? WHERE ID = ?");
            ps.setString(1,restriction.getUser_id());
            ps.setString(2,restriction.getCause());
            ps.setTimestamp(3,restriction.getR_start());
            ps.setTimestamp(4,restriction.getR_end());
            ps.setString(5,restriction.getId());
            return restriction;
        }catch (Exception ignored){
            return null;
        }
    }
}
