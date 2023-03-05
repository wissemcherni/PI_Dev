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

public class Product_Service implements IService<Product> {
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public Product CREATE(Product product){
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO PRODUCT (ID,NAME,DESCRIPTION,SUB_CATEGORY_ID,QUANTITY,USER_ID,LATITUDE,LONGITUDE) VALUES (?,?,?,?,?,?,?,?)");
            product.setId(UUID.randomUUID().toString());
            ps.setString(1,product.getId());
            ps.setString(2,product.getName());
            ps.setString(3,product.getDescription());
            ps.setString(4,product.getSub_category_id());
            ps.setInt(5,product.getQuantity());
            ps.setString(6,product.getUser_id());
            ps.setString(7, product.getLatitude());
            ps.setString(8, product.getLongitude());
            if(ps.execute()){
                return product;
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    public Product READONE(Product product){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PRODUCT WHERE ID = ?");
            ps.setString(1,product.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
            return null;
        }catch (Exception ignored){
            return null;
        }
    }
    
    public Product READONE2(String searchStr){
    try{
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PRODUCT WHERE name LIKE ? OR description LIKE ?");
        ps.setString(1,"%" + searchStr + "%"); // match search string against product name
        ps.setString(2,"%" + searchStr + "%"); // match search string against product description
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
        }
        return null;
    }catch (Exception ignored){
        return null;
    }
}

    
    public HashMap<Integer,Product> READALL(Sub_Category sub_category){
        try{
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PRODUCT WHERE SUB_CATEGORY_ID = ?");
            ps.setString(1,sub_category.getCategory_id());
            ResultSet rs = ps.executeQuery();
            HashMap<Integer,Product> products = new HashMap<>();
            int i = 0;
            while(rs.next()){
                products.put(++i, new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
            return products;
        }catch (Exception ignored){
            return null;
        }
    }

    @Override
    public HashMap<Integer,Product> READALL(){
        try{
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PRODUCT");
            HashMap<Integer,Product> products = new HashMap<>();
            int i = 0;
            while(rs.next()){
                products.put(++i, new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
            return products;
        }catch (Exception ignored){
            return null;
        }
    }
    @Override
    public Product MODIFY(Product product){
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PRODUCT SET NAME = ?, DESCRIPTION = ?, SUB_CATEGORY_ID = ? ,QUANTITY = ? ,USER_ID = ?, LATITUDE = ?, LONGITUDE = ? WHERE ID = ?");
            ps.setString(1,product.getName());
            ps.setString(2,product.getDescription());
            ps.setString(3,product.getSub_category_id());
            ps.setInt(4,product.getQuantity());
            ps.setString(5,product.getUser_id());
            ps.setString(6, product.getLatitude());
            ps.setString(7, product.getLongitude());
            ps.setString(8,product.getId());
            ps.executeUpdate();
            return product;
        }catch (Exception ignored){
            System.out.println(ignored.getMessage());
            return null;
        }
    }
    @Override
    public boolean DELETE(Product product){
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM PRODUCT WHERE ID = ?");
            ps.setString(1, product.getId());
            return ps.execute();
        }catch (Exception ignored){
            return false;
        }
    }

//    public HashMap<Integer, Product> READALL(User user) {
//        try{
//            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM PRODUCT WHERE user_id = ?");
//            ps.setString(1,user.getId());
//            ResultSet rs = ps.executeQuery();
//            HashMap<Integer,Product> products = new HashMap<>();
//            int i = 0;
//            while(rs.next()){
//                products.put(++i, new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
//            }
//            return products;
//        }catch (Exception ignored){
//            return null;
//        }
//    }

    
}
