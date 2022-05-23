package br.com.lefashion.clothingstore.store.repository;

import br.com.lefashion.clothingstore.store.domains.Brand;
import br.com.lefashion.clothingstore.store.domains.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
