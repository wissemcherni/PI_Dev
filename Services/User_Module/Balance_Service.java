package production.x_change.Services.User_Module;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import production.x_change.Models.Balance;
import production.x_change.Models.User;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Balance_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();

    public Balance READONE(User u){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM BALANCE WHERE USER_ID = ?");
            ps.setString(1,u.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Balance(rs.getString(1),rs.getString(2),rs.getDouble(3));
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    
}
