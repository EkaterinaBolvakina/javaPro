package group40.whatrentdbapp.service.productService;

import group40.whatrentdbapp.entity.Product;
import group40.whatrentdbapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindProductService implements IFindProductService {
    private final IProductRepository productRepository;

    public FindProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        List<Product> allProducts = productRepository.findAll();
        if (!allProducts.isEmpty()) {
            return new ResponseEntity<>(allProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allProducts, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<Product> findById(Integer id) {
        Optional<Product> foundedProductOptional = productRepository.findById(id);
        if (foundedProductOptional.isPresent()) {
            return new ResponseEntity<>(foundedProductOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findByName(String productName) {
        List<Product> allProductsFoundedByName = productRepository.findAllByNameContains(productName);

        if (!allProductsFoundedByName.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allProductsFoundedByName, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findByDescription(String productDescription) {
        List<Product> allProductsFoundedByDescription = productRepository.findAllByDescriptionContains(productDescription);

        if (!allProductsFoundedByDescription.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByDescription, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allProductsFoundedByDescription, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findByPrice(Double productPrice) {
        List<Product> allProductsFoundedByPrice = productRepository.findAllByPriceEquals(productPrice);

        if (!allProductsFoundedByPrice.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByPrice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allProductsFoundedByPrice, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findByQuantity(Integer productQuantity) {
        List<Product> allProductsFoundedByQuantity = productRepository.findAllByQuantityEquals(productQuantity);

        if (!allProductsFoundedByQuantity.isEmpty()) {
            return new ResponseEntity<>(allProductsFoundedByQuantity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allProductsFoundedByQuantity, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findByPriceInterval(Double productPriceMin, Double productPriceMax) {
        List<Product> productsFoundedByPriceInterval = productRepository.findAllByPriceBetween(productPriceMin, productPriceMax);

        if (!productsFoundedByPriceInterval.isEmpty()) {
            return new ResponseEntity<>(productsFoundedByPriceInterval, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(productsFoundedByPriceInterval, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<Product>> findByQuantityInterval(Integer productQuantityMin, Integer productQuantityMax) {
        List<Product> foundedProductsByQuantityInterval = productRepository.findAllByQuantityBetween(productQuantityMin, productQuantityMax);

        if (!foundedProductsByQuantityInterval.isEmpty()) {
            return new ResponseEntity<>(foundedProductsByQuantityInterval, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(foundedProductsByQuantityInterval, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
