package cours.apprentissage.graphqlproductmanager.business.product;

import cours.apprentissage.graphqlproductmanager.business.product.dtos.ProductRequestDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGrapQlController {
    private IProduct iProduct;

    public ProductGrapQlController(IProduct iProduct) {
        this.iProduct = iProduct;
    }
    @QueryMapping
    public List<Product>productList(){
        return iProduct.products();
    }
    @QueryMapping
    public Product getProductById(@Argument Long id){
        return iProduct.findById(id);
    }
    @MutationMapping
    public Product save(@Argument ProductRequestDTO productRequestDTO){
        return iProduct.save(productRequestDTO);
    }
    @MutationMapping
    public Product update(@Argument Long id,@Argument ProductRequestDTO productRequestDTO){
        return iProduct.update(id,productRequestDTO);
    }
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id){
        return iProduct.deleteById(id);
    }
}
