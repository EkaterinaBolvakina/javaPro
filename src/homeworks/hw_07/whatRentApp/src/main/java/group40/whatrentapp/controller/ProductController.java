package group40.whatrentapp.controller;

import group40.whatrentapp.dto.RequestProductDto;
import group40.whatrentapp.entity.Product;
import group40.whatrentapp.service.productService.AddProductService;
import group40.whatrentapp.service.productService.DeleteProductService;
import group40.whatrentapp.service.productService.FindProductService;
import group40.whatrentapp.service.productService.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final AddProductService addProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final FindProductService findProductService;

    @Autowired
    public ProductController(AddProductService addProductService, UpdateProductService updateProductService, DeleteProductService deleteProductService, FindProductService findProductService) {
        this.addProductService = addProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.findProductService = findProductService;
    }

    @PostMapping("/addNew")
    public ResponseEntity<Integer> addProduct(@RequestBody RequestProductDto requestProductDto) {
        return addProductService.addProduct(requestProductDto);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProduct(@RequestBody RequestProductDto requestProductDto) {
        return updateProductService.updateProduct(requestProductDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable Integer id) {
        return deleteProductService.deleteProductById(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return findProductService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer id) {
        return findProductService.findById(id);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Product>> findProductByName(@RequestParam(value = "productName") String name) {
        return findProductService.findByName(name);
    }

    @GetMapping("/findByDescription")
    public ResponseEntity<List<Product>> findProductByDescription(@RequestParam(value = "productDescription") String description) {
        return findProductService.findByDescription(description);
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<List<Product>> findProductByPrice(@RequestParam(value = "productPrice") Double price) {
        return findProductService.findByPrice(price);
    }

    @GetMapping("/findByPrice-Min-Max")
    public ResponseEntity<List<Product>> findProductByPriceInterval(@RequestParam(value = "priceMin") Double priceMin, @RequestParam(value = "priceMax") Double priceMax) {
        return findProductService.findByPriceInterval(priceMin, priceMax);
    }

    @GetMapping("/findByQuantity")
    public ResponseEntity<List<Product>> findProductByQuantity(@RequestParam(value = "productQuantity") Integer productQuantity) {
        return findProductService.findByQuantity(productQuantity);
    }

    @GetMapping("/findByQuantity-Min-Max")
    public ResponseEntity<List<Product>> findProductByQuantityInterval(@RequestParam(value = "quantityMin") Integer quantityMin, @RequestParam(value = "quantityMax") Integer quantityMax) {
        return findProductService.findByQuantityInterval(quantityMin, quantityMax);
    }

}
