package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAllByCart(Cart cart) {
        return cartItemRepository.getAllByCart(cart);
    }

    public void add(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public void deleteById(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clear() {
        cartItemRepository.deleteAll();
    }
}
