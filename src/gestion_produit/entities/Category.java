package gestion_produit.entities;

public class Category {
    private String id;
    private String name;
    public Category(){
    }
    
    
    @Override
    public String toString() {
        return "Product{" + "id Category=" + id + ", name=" + name + '}';
    }
    
    



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
