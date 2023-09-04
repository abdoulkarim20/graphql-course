package cours.apprentissage.graphqlproductmanager.business.product;

import cours.apprentissage.graphqlproductmanager.business.category.Categorie;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    @ManyToOne
    private Categorie categorie;

    public Product() {
    }

    public Product(Long id, String name, Double price, Integer quantity, Categorie categorie) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
