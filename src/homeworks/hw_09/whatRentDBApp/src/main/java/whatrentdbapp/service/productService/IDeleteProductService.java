package group40.whatrentdbapp.service.productService;

import group40.whatrentdbapp.dto.RequestProductDto;
import group40.whatrentdbapp.entity.Product;
import org.springframework.http.ResponseEntity;

public interface IDeleteProductService {

    ResponseEntity<Void> deleteProductById(Integer productId);

}
