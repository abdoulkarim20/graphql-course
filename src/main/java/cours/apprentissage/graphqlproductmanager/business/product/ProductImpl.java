package cours.apprentissage.graphqlproductmanager.business.product;

import cours.apprentissage.graphqlproductmanager.business.category.Categorie;
import cours.apprentissage.graphqlproductmanager.business.category.ICategory;
import cours.apprentissage.graphqlproductmanager.business.product.dtos.ProductRequestDTO;
import cours.apprentissage.graphqlproductmanager.business.product.mappers.ProductRequestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductImpl implements IProduct{
    private final ProductRepository productRepository;
    private final ICategory iCategory;
    private final ProductRequestMapper productRequestMapper;

    public ProductImpl(ProductRepository productRepository, ICategory iCategory, ProductRequestMapper productRequestMapper) {
        this.productRepository = productRepository;
        this.iCategory = iCategory;
        this.productRequestMapper = productRequestMapper;
    }
    @Override
    public Product save(ProductRequestDTO productRequestDTO) {
        Product product=productRequestMapper.toEntity(productRequestDTO);
        /**Nous recuperons la categorie par son id*/
        Categorie categorie=iCategory.findById(productRequestDTO.getCategorieId());
        product.setCategorie(categorie);
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id,ProductRequestDTO productRequestDTO) {
        Product product=productRequestMapper.toEntity(productRequestDTO);
        product.setId(id);
        /**Nous recuperons la categorie par son id*/
        Categorie categorie=iCategory.findById(productRequestDTO.getCategorieId());
        product.setCategorie(categorie);
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Product product=productRepository.findById(id).orElseThrow(() ->new RuntimeException(String.format("Product not found ",id)));
        return product;
    }

    @Override
    public Boolean deleteById(Long id) {
        Product product=productRepository.findById(id).orElseThrow(() ->new RuntimeException(String.format("Product not found ",id)));
        productRepository.delete(product);
        return true;
    }

    @Override
    public List<Product> products() {
        return productRepository.findAll();
    }
}
