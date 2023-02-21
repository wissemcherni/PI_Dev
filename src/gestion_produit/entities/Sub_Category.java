package gestion_produit.entities;

import gestion_produit.services.Category_Service;

public class Sub_Category {
    private String id;
    private String name;
    private String category_id;


    public Sub_Category() {
    }
    public Sub_Category(String name, String category_id) {
        this.name = name;
        this.category_id = category_id;
    }

    public Sub_Category(String id) {
        this.id = id;
    }

    public Sub_Category(String id, String name, String category_id) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
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

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    Category getCategory() {
        return new Category_Service().READONE(new Category(this.category_id,null));
    }
}
