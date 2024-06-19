import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product update(int pro_id, Product product) {
        Product existingProduct = entityManager.find(Product.class, pro_id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPricePerUnit(product.getPricePerUnit());
            existingProduct.setActiveForSell(product.isActiveForSell());
            entityManager.merge(existingProduct);
            return existingProduct;
        } else {
            return null; // or handle the case where the product is not found
        }
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = entityManager.find(Product.class, id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPricePerUnit(product.getPricePerUnit());
            existingProduct.setActiveForSell(product.isActiveForSell());
            entityManager.merge(existingProduct);
            return existingProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product getProductById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product createProduct(Product product) {
        entityManager.persist(product);
        return product;
    }
}
