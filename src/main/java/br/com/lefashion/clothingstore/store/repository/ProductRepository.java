package br.com.lefashion.clothingstore.store.repository;

import br.com.lefashion.clothingstore.store.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
