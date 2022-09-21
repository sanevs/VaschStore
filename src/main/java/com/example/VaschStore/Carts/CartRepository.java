package com.example.VaschStore.Carts;

import com.example.VaschStore.Humans.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "SELECT * FROM Cart c WHERE c.human_id = ?1", nativeQuery = true)
    Optional<Cart> getByPerson(Human human);
}
