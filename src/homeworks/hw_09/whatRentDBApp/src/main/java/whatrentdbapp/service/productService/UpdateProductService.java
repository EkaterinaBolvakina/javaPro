package group40.whatrentdbapp.service.productService;

import group40.whatrentdbapp.dto.RequestProductDto;
import group40.whatrentdbapp.entity.Product;
import group40.whatrentdbapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService implements IUpdateProductService {
    private final IProductRepository productRepository;

    public UpdateProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Product> updateProduct(Integer productId, RequestProductDto requestProductDto) {
        Product productForUpdate = new Product(productId, requestProductDto.getProductName(), requestProductDto.getProductDescription(), requestProductDto.getProductPrice(), requestProductDto.getProductQuantity());
        if (productRepository.existsById(productId)) {
        Product updatedProduct = productRepository.save(productForUpdate);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
