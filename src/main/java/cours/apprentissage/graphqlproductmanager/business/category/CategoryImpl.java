package cours.apprentissage.graphqlproject.business.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryImpl implements ICategory{
    private CategoryRepository categoryRepository;

    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}
