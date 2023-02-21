package gestion_produit.services;


import gestion_produit.IService;
import gestion_produit.entities.Category;
import gestion_produit.entities.Sub_Category;
import gestion_produit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

public class Sub_Category_Service implements IService<Sub_Category> {
    private final Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public Sub_Category CREATE(Sub_Category sub_category){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO SUB_CATEGORY (ID,NAME,CATEGORY_ID) values (?,?,?)");
            sub_category.setId(UUID.randomUUID().toString());
            ps.setString(1,sub_category.getId());
            ps.setString(2,sub_category.getName());
            ps.setString(3,sub_category.getCategory_id());
            if(ps.execute()){
                return sub_category;
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    public Sub_Category READONE(Sub_Category sub_category){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM SUB_CATEGORY WHERE ID = ?");
            ps.setString(1,sub_category.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Sub_Category(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    
  
    
    
    public HashMap<Integer,Sub_Category> READALL(){
        try{
            ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM SUB_CATEGORY WHERE 1");
            HashMap<Integer,Sub_Category> sub_categories = new HashMap<>();
            int i = 0;
            while(rs.next()){
                sub_categories.put(++i,new Sub_Category(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return sub_categories;
        }catch (Exception ignored){
            return null;
        }
    }
    public HashMap<Integer,Sub_Category> READALL(Category category){
        try{
           PreparedStatement ps = cnx.prepareStatement("SELECT * FROM SUB_CATEGORY WHERE CATEGORY_ID = ?");
           ps.setString(1,category.getId());
           ResultSet rs = ps.executeQuery();
            HashMap<Integer,Sub_Category> sub_categories = new HashMap<>();
            int i = 0;
            while(rs.next()){
                sub_categories.put(++i,new Sub_Category(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return sub_categories;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    public Sub_Category MODIFY(Sub_Category sub_category){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE SUB_CATEGORY SET NAME = ? CATEGORY_ID = ? WHERE ID=?");
            sub_category.setId(UUID.randomUUID().toString());
            ps.setString(1,sub_category.getName());
            ps.setString(2,sub_category.getCategory_id());
            ps.setString(3,sub_category.getId());
            if(ps.execute()){
                return sub_category;
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    public boolean DELETE(Sub_Category sub_category){
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM SUB_CATEGORY WHERE ID = ?");
            ps.setString(1,sub_category.getId());
            return ps.execute();
        }catch (Exception ignored){
            return false;
        }
    }

}
