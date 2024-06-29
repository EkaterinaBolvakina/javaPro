package group40.whatrentapp.repository;

import group40.whatrentapp.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    Integer add(Product product);
    boolean update(Product productForUpdate);
    boolean deleteById(Integer id);
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);
    List<Product> findByPrice(Double price);
    List<Product> findByQuantity(Integer quantity);
    List<Product> findByPriceInterval(Double priceMin, Double priceMax);
    List<Product> findByQuantityInterval(Integer quantityMin, Integer quantityMax);

}
