package ro.tachor.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tachor.product.productservice.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
