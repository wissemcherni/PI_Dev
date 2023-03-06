package production.x_change.Services.User_Module;

import production.x_change.Models.Deposit;
import production.x_change.Models.Withdraw;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

public class Deposit_Service {
    Connection cnx = DataSource.getInstance().getCnx();

    public Deposit CREATE(Deposit deposit){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO DEPOSIT (ID,AMOUNT,BALANCE_ID,TOKEN) VALUES (?,?,?,?)");
            deposit.setId(UUID.randomUUID().toString());
            ps.setString(1,deposit.getId());
            ps.setDouble(2,deposit.getAmount());
            ps.setString(3,deposit.getBalance_id());
            ps.setString(4,deposit.getToken());
            return deposit;
        }catch (Exception ignored){
            return null;
        }
    }
    public HashMap<Integer, Deposit> READALL(Withdraw withdraw){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM `DEPOSIT`\n WHERE BALANCE_ID = ?");
            ps.setString(1, withdraw.getBalance_id());
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Deposit> deposits = new HashMap<>();
            int i = 0;
            while(rs.next()){
                deposits.put(++i,new Deposit(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getString(4)));
            }
            return deposits;
        }catch (Exception ignored){
            return null;
        }
    }
}
