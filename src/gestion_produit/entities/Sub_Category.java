package gestion_produit.entities;

import gestion_produit.services.Category_Service;
import java.util.Objects;

public class Sub_Category {
    private String id;

    @Override
    public String toString() {
        return name ;
    }
    private String name;
    private String category_id;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sub_Category other = (Sub_Category) obj;
        return Objects.equals(this.id, other.id);
    }


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
