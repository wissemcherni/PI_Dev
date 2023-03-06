package production.x_change.Services.One_For_All;

import production.x_change.Models.*;
import production.x_change.Services.IService;
import production.x_change.Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

public class Picture_Service implements IService<Picture> {
    private final Connection cnx = DataSource.getInstance().getCnx();
    public Picture CREATE(Picture picture){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO PICTURE (ID,PICTUREABLE_TYPE,PICTUREABLE_ID,URL) VALUES (?,?,?,?)");
            picture.setId(UUID.randomUUID().toString());
            ps.setString(1,picture.getId());
            ps.setString(2,picture.getPicture_type());
            ps.setString(3,picture.getPicture_id());
            ps.setString(4,picture.getUrl());
            ps.execute();
            return picture;
        }catch (Exception ignored){
            System.out.println(ignored);
            return null;
        }
    }

    @Override
    public HashMap<Integer, Picture> READALL() {
        try{
            PreparedStatement ps = cnx.prepareStatement("select * from picture where 1");
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Picture> pictures = new HashMap<>();
            int i = 0;
            while(rs.next()){
                pictures.put(++i,new Picture(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            return pictures;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public Picture READONE(Picture picture) {
        try{
            PreparedStatement ps = cnx.prepareStatement("select * from picture where id = ?");
            ps.setString(1,picture.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Picture(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }

    public Picture GETONE(Object o){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PICTURE WHERE pictureable_id = ? and pictureable_type = ? order by created_at desc limit 1");
            if(o instanceof Profile){
                ps.setString(1,((Profile) o).getId());
                ps.setString(2,"profile");
            }else if(o instanceof Product){
                ps.setString(1,((Product) o).getId());
                ps.setString(2,"product");
            }else if(o instanceof Category){
                ps.setString(1,((Category) o).getId());
                ps.setString(2,"category");
            }
            else if(o instanceof Sub_Category){
                ps.setString(1,((Sub_Category) o).getId());
                ps.setString(2,"sub_category");
            }
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Picture(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            return null;
        }catch (Exception ignored){
            System.out.println(ignored.getLocalizedMessage());
            return null;
        }
    }
    public HashMap<Integer,Picture> READALL(Object o){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PICTURE WHERE pictureable_id = ? and pictureable_type = ? order by created_at desc");
            if(o instanceof Profile){
                ps.setString(1,((Profile) o).getId());
                ps.setString(2,"profile");
            }else if(o instanceof Product){
                ps.setString(1,((Product) o).getId());
                ps.setString(2,"product");
            }else if(o instanceof Category){
                ps.setString(1,((Category) o).getId());
                ps.setString(2,"category");
            }
            else if(o instanceof Sub_Category){
                ps.setString(1,((Sub_Category) o).getId());
                ps.setString(2,"sub_category");
            }
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Picture> pictures = new HashMap<>();
            int i = 0;
            while(rs.next()){
                pictures.put(++i,new Picture(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4))) ;
            }
            return pictures;
        }catch (Exception ignored){
            return null;
        }
    }
    public Picture MODIFY(Picture picture){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PICTURE SET created_at =current_timestamp() WHERE ID = ?");
            ps.setString(1,picture.getId());
            ps.executeUpdate();
            return picture;
        }catch (Exception ignored){
            System.out.println(ignored.getLocalizedMessage());
            return null;
        }
    }
    public boolean DELETE(Picture picture){
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM PICTURE WHERE ID = ?");
            ps.setString(1,picture.getId());
            return ps.execute();
        }catch (Exception ignored){
            return false;
        }
    }
}
