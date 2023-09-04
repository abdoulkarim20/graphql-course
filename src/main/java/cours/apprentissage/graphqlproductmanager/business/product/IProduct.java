package cours.apprentissage.graphqlproductmanager.business.product;

import cours.apprentissage.graphqlproductmanager.business.product.dtos.ProductRequestDTO;

import java.util.List;

public interface IProduct {
    Product save(ProductRequestDTO product);
    Product update(Long id,ProductRequestDTO productRequestDTO);
    Product findById(Long id);
    Boolean deleteById(Long id);
    List<Product>products();
}
