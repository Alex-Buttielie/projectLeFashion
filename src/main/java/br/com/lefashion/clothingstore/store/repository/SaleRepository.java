package br.com.lefashion.clothingstore.store.repository;

import br.com.lefashion.clothingstore.store.domains.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
