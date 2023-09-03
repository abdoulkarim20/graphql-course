package cours.apprentissage.graphqlproductmanager.business.category;

import java.util.List;

public interface ICategory {
    Categorie save(Categorie categorie);
    Categorie update(Categorie categorie);
    Categorie findById(Long id);
    Boolean deleteById(Long id);
    List<Categorie>categories();
}
