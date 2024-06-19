import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product update(int pro_id, Product product);

    Product updateProduct(Long id, Product product);

    Product getProductById(Long id);

    Product createProduct(Product product);
}
