package group40.whatrentdbapp.service.productService;


import group40.whatrentdbapp.dto.RequestProductDto;
import group40.whatrentdbapp.entity.Product;
import group40.whatrentdbapp.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddProductService implements IAddProductService {
    private final IProductRepository productRepository;

    public AddProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Product> addProduct(RequestProductDto requestProductDto) {
        Product newProduct = new Product(requestProductDto.getProductName(), requestProductDto.getProductDescription(), requestProductDto.getProductPrice(), requestProductDto.getProductQuantity());
        Product savedNewProduct = productRepository.save(newProduct);
        return new ResponseEntity<>(savedNewProduct, HttpStatus.CREATED);
    }
}
