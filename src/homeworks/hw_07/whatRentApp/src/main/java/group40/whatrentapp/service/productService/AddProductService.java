package group40.whatrentapp.service.productService;

import group40.whatrentapp.dto.RequestProductDto;
import group40.whatrentapp.entity.Product;
import group40.whatrentapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddProductService {
    private final IProductRepository productRepository;

    public AddProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ResponseEntity<Integer> addProduct(RequestProductDto requestProductDto) {
        Product newProduct = new Product(requestProductDto.getProductName(), requestProductDto.getProductDescription(), requestProductDto.getProductPrice(), requestProductDto.getProductQuantity());
        Integer idNewProduct = productRepository.add(newProduct);
        return new ResponseEntity<>(idNewProduct, HttpStatus.CREATED);
    }
}
