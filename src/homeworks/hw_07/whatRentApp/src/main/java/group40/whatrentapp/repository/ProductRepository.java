package group40.whatrentapp.repository;

import group40.whatrentapp.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private Integer productId = 0;
    private Map<Integer, Product> productsDatabase = new HashMap<>();

    @Override
    public Integer add(Product product) {
        product.setId(++productId);
        productsDatabase.put(productId, product);
        return productId;
    }

    @Override
    public boolean update(Product productForUpdate) {
        if (productsDatabase.containsKey(productForUpdate.getId())) {
            productsDatabase.put(productForUpdate.getId(), productForUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        return productsDatabase.remove(id) != null;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productsDatabase.values());
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.ofNullable(productsDatabase.get(id));
    }

    @Override
    public List<Product> findByName(String name) {
        return productsDatabase.values().stream()
                .filter(product -> product.getName().equals(name))
                .toList();
    }

    @Override
    public List<Product> findByDescription(String description) {
        return productsDatabase.values().stream()
                .filter(product -> product.getDescription().equals(description))
                .toList();
    }

    @Override
    public List<Product> findByPrice(Double price) {
        return productsDatabase.values().stream()
                .filter(product -> product.getPrice().equals(price))
                .toList();
    }

    @Override
    public List<Product> findByQuantity(Integer quantity) {
        return productsDatabase.values().stream()
                .filter(product -> product.getQuantity().equals(quantity))
                .toList();
    }

    @Override
    public List<Product> findByPriceInterval(Double priceMin, Double priceMax) {
        return productsDatabase.values().stream()
                .filter(product -> product.getPrice() <= priceMax && product.getPrice() >= priceMin)
                .toList();
    }

    @Override
    public List<Product> findByQuantityInterval(Integer quantityMin, Integer quantityMax) {
        return productsDatabase.values().stream()
                .filter(product -> product.getQuantity() <= quantityMax && product.getQuantity() >= quantityMin)
                .toList();
    }

}
