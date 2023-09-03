package cours.apprentissage.graphqlproductmanager.business.product;

import java.util.List;

public interface IProduct {
    Product save(Product product);
    Product update(Product product);
    Product findById(Long id);
    Boolean deleteById(Long id);
    List<Product>products();
}
