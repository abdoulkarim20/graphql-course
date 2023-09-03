package cours.apprentissage.graphqlproductmanager;

import cours.apprentissage.graphqlproductmanager.business.category.Categorie;
import cours.apprentissage.graphqlproductmanager.business.category.CategoryRepository;
import cours.apprentissage.graphqlproductmanager.business.product.Product;
import cours.apprentissage.graphqlproductmanager.business.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class GraphqlproductmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlproductmanagerApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository){
        return args -> {
            Random random=new Random();
            List.of("Computer","Printer","Smartphone").forEach(category->{
                Categorie categoryToSave=Categorie.builder().name(category).build();
                categoryRepository.save(categoryToSave);
            });
            categoryRepository.findAll().forEach(category -> {
                for (int i=0;i<10;i++){
                    Product product= Product.builder()
                            .name("computer"+i)
                            .price(1000+Math.random()*50000)
                            .quantity(random.nextInt(100))
                            .categorie(category)
                            .build();
                    productRepository.save(product);
                }
            });
        };
    }

}
