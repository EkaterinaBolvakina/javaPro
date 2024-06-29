package group40.whatrentapp.service.productService;

import group40.whatrentapp.dto.RequestProductDto;
import group40.whatrentapp.entity.Product;
import group40.whatrentapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService {
    private final IProductRepository productRepository;

    public UpdateProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Boolean> updateProduct(RequestProductDto requestProductDto) {
        Product productForUpdate = new Product(requestProductDto.getProductId(), requestProductDto.getProductName(), requestProductDto.getProductDescription(), requestProductDto.getProductPrice(), requestProductDto.getProductQuantity());

        boolean updateResult = productRepository.update(productForUpdate);
        if (updateResult) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
