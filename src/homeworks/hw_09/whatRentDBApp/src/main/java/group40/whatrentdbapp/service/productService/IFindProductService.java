package group40.whatrentdbapp.service.productService;

import group40.whatrentdbapp.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindProductService {
    ResponseEntity<List<Product>> findAll();
    ResponseEntity<Product> findById(Integer id);
    ResponseEntity<List<Product>> findByName(String productName);
    ResponseEntity<List<Product>> findByDescription(String productDescription);
    ResponseEntity<List<Product>> findByPrice(Double productPrice);
    ResponseEntity<List<Product>> findByQuantity(Integer productQuantity);
    ResponseEntity<List<Product>> findByPriceInterval(Double productPriceMin, Double productPriceMax);
    ResponseEntity<List<Product>> findByQuantityInterval(Integer productQuantityMin, Integer productQuantityMax);
}
