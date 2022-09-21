package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM CartItem ci WHERE ci.cart_id = ?1", nativeQuery = true)
    List<CartItem> getAllByCart(Cart cart);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CartItem ci WHERE ci.cart_id = ?1", nativeQuery = true)
    void deleteAllByCart(Long cartId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CartItem ci SET quantity = ?1 WHERE ci.id = ?2", nativeQuery = true)
    void update(Integer quantity, Long id);
}
