package cours.apprentissage.graphqlproject.business.category;

import java.util.List;

public interface ICategory {
    Category save(Category category);
    Category update(Category category);
    Category findById(Long id);
    Boolean deleteById(Long id);
    List<Category>categories();
}
