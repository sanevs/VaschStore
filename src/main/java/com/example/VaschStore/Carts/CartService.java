package com.example.VaschStore.Carts;

import com.example.VaschStore.Humans.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> getByPerson(Human human) {
        return cartRepository.getByPerson(human);
    }

    public Cart add(Cart cart) {
        return cartRepository.save(cart);
    }
}
