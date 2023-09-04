package cours.apprentissage.graphqlproductmanager.business.product.mappers;

import cours.apprentissage.graphqlproductmanager.business.product.Product;
import cours.apprentissage.graphqlproductmanager.business.product.dtos.ProductRequestDTO;
import cours.apprentissage.graphqlproductmanager.utils.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper extends EntityMapper<ProductRequestDTO, Product> {
    @Mapping(target = "categorieId",source = "categorie.id")
    ProductRequestDTO toDto(Product product);

}

