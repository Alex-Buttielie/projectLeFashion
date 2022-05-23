package br.com.lefashion.clothingstore.store.repository;

import br.com.lefashion.clothingstore.store.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String email);
}
