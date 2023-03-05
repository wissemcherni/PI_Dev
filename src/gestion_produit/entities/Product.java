package gestion_produit.entities;

import gestion_produit.services.Category_Service;
import gestion_produit.services.Sub_Category_Service;

public class Product {
    private String id;
    private String name;
    private String description;
    private String sub_category_id;
    private Integer quantity;
    private String user_id;
    private String latitude;
    private String longitude;

    public Product() {
    }

   

    public Product( String name, String description) {
      
        this.name = name;
        this.description = description;
    }

   

    @Override
    public String toString() {
        return "Product [Category: "+new Sub_Category_Service().READONE(new Sub_Category(sub_category_id)).getCategory().getName()+", Sub Category:" +new Sub_Category_Service().READONE(new Sub_Category(sub_category_id)).getName()+ ", name=" + name + ", description=" + description + ", quantity="+quantity+"]";
    }

    public Product(String name, String description, String sub_category_id, Integer quantity, String user_id, String latitude, String longitude) {
        this.name = name;
        this.description = description;
        this.sub_category_id = sub_category_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Product(String id, String name, String description, String sub_category_id, Integer quantity, String user_id, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sub_category_id = sub_category_id;
        this.quantity = quantity;
        this.user_id = user_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

 
}
