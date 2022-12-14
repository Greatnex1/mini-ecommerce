package jolaexpress.africa.repository;

import jolaexpress.africa.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long productId);
}
