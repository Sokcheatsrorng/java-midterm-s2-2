import java.util.List;

public interface ProductService {
    Product updateProduct(Long id, Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
