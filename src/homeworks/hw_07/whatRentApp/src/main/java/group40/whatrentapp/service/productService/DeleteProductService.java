package group40.whatrentapp.service.productService;

import group40.whatrentapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {
    private final IProductRepository productRepository;

    public DeleteProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Boolean> deleteProductById(Integer productId) {
        boolean deleteResult = productRepository.deleteById(productId);
        if (deleteResult) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
