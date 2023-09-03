package cours.apprentissage.graphqlproductmanager.business.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductImpl implements IProduct{
    private ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Product product=productRepository.findById(id).orElseThrow(() ->new RuntimeException(String.format("Product not found ",id)));
        return product;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public List<Product> products() {
        return productRepository.findAll();
    }
}
