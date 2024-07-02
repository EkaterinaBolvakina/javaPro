package group40.whatrentdbapp.service.productService;


import group40.whatrentdbapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteDeleteProductService implements IDeleteProductService {
    private final IProductRepository productRepository;

    public DeleteDeleteProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Integer productId) {

        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
