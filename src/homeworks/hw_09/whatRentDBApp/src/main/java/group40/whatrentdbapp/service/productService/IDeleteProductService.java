package group40.whatrentdbapp.service.productService;

import org.springframework.http.ResponseEntity;

public interface IDeleteProductService {

    ResponseEntity<Void> deleteProductById(Integer productId);

}
