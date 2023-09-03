package cours.apprentissage.graphqlproductmanager.business.category;

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
    public Categorie save(Categorie categorie) {
        return categoryRepository.save(categorie);
    }

    @Override
    public Categorie update(Categorie categorie) {
        return categoryRepository.save(categorie);
    }

    @Override
    public Categorie findById(Long id) {
        Categorie categorie =categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return categorie;
    }

    @Override
    public Boolean deleteById(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Categorie> categories() {
        return categoryRepository.findAll();
    }
}
