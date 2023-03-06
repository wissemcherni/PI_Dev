package production.x_change.Services.User_Module;

import production.x_change.Models.Withdraw;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

public class Withdraw_Service {
    private final Connection cnx = DataSource.getInstance().getCnx();

    public Withdraw CREATE(Withdraw withdraw){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO `withdraw` (`id`, `amount`, `balance_id`, `token`) VALUES (?,?,?,?)");
            withdraw.setId(UUID.randomUUID().toString());
            ps.setString(1,withdraw.getId());
            ps.setDouble(2,withdraw.getAmount());
            ps.setString(3,withdraw.getBalance_id());
            ps.setString(4,withdraw.getToken());
            ps.execute();
            return withdraw;
        }catch (Exception ignored){
            return null;
        }
    }
    public HashMap<Integer,Withdraw> READALL(Withdraw withdraw){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM `withdraw`\n WHERE BALANCE_ID = ?");
            ps.setString(1, withdraw.getBalance_id());
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Withdraw> withdraws = new HashMap<>();
            int i = 0;
            while(rs.next()){
                withdraws.put(++i,new Withdraw(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4)));
            }
            return withdraws;
        }catch (Exception ignored){
            return null;
        }
    }
}
