package cours.apprentissage.graphqlproductmanager.business.category;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryGrapQlController {
    private ICategory iCategory;

    public CategoryGrapQlController(ICategory iCategory) {
        this.iCategory = iCategory;
    }
    @QueryMapping
    List<Categorie>categories(){
        return iCategory.categories();
    }
    @QueryMapping
    Categorie getCategorieById(@Argument Long id){
        return iCategory.findById(id);
    }
}
