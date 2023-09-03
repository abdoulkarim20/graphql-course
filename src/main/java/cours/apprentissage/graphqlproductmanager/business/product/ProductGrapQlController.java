package cours.apprentissage.graphqlproductmanager.business.product;

import org.springframework.graphql.data.method.annotation.Argument;
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
    Product getProductById(@Argument Long id){
        return iProduct.findById(id);
    }
}
