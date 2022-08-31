package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import com.example.VaschStore.Persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM CartItem ci WHERE ci.cart_id = ?1", nativeQuery = true)
    List<CartItem> getAllByCart(Cart cart);
}
