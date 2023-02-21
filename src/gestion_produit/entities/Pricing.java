package gestion_produit.entities;

import java.sql.Timestamp;

public class Pricing {
    private String id;
    private String product_id;
    private Double price;
    private Timestamp created_at;

    public Pricing() {
    }

    public Pricing(String product_id, Double price, Timestamp created_at) {
        this.product_id = product_id;
        this.price = price;
        this.created_at = created_at;
    }

    public Pricing(String id, String product_id, Double price, Timestamp created_at) {
        this.id = id;
        this.product_id = product_id;
        this.price = price;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
