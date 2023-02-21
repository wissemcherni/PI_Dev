package gestion_produit.services;

import gestion_produit.IService;
import gestion_produit.entities.*;
import gestion_produit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

public class Category_Service implements IService<Category> {
    private final Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public Category CREATE(Category category){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO CATEGORY (ID,NAME) VALUES (?,?)");
            category.setId(UUID.randomUUID().toString());
            ps.setString(1,category.getId());
            ps.setString(2,category.getName());
            if(ps.execute()){
                return category;
            }
            return null;
        }catch (Exception ignored){
            System.out.println(ignored.getMessage());
            return null;
        }
    }
    @Override
    public Category MODIFY(Category category){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE CATEGORY SET NAME = ? WHERE ID = ?");
            ps.setString(1,category.getName());
            ps.setString(2,category.getId());
            if(ps.execute()){
                return category;
            }
            return null;
        }catch (Exception ignored){
            System.out.println(ignored.getMessage());
            return null;
        }
    }
    public boolean DELETE(Category category){
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM CATEGORY WHERE ID = ? ");
            ps.setString(1,category.getId());
            return ps.execute();
        }catch (Exception ignored){
            return false;
        }
    }



    public HashMap<Integer,Category> READALL(){
        try{
            Statement statement = cnx.createStatement();
            HashMap<Integer,Category> categories = new HashMap<>();
            int i =0;
            ResultSet rs = statement.executeQuery("SELECT * FROM CATEGORY WHERE 1");
            while(rs.next()){
                categories.put(++i,new Category(rs.getString(1),rs.getString(2)));
            }
            return categories;
        }catch (Exception ignored){
            return null;
        }
    }
    public Category READONE(Category category){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM CATEGORY WHERE ID = ?");
            ps.setString(1,category.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                category.setName(rs.getString(2));
                return category;
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
}
