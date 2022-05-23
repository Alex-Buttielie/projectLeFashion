package br.com.lefashion.clothingstore.store.repository;

import br.com.lefashion.clothingstore.store.domains.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
