package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public CartItem add(CartItem cartItem) {

        List<CartItem> cartItems = getAllByCart(cartItem.getCart());
        Optional<CartItem> cartItemOptionalDB = cartItems
                .stream().filter(ci ->
                        ci.getProduct().getId() == cartItem.getProduct().getId() &&
                        ci.getSize().getId() == cartItem.getSize().getId())
                .findFirst();
        if(cartItemOptionalDB.isPresent())
        {
            CartItem cartItemDB = cartItemOptionalDB.get();
            cartItemDB.setQuantity(cartItemDB.getQuantity() + 1);
            cartItemRepository.update(
                    cartItemDB.getQuantity(),
                    cartItemDB.getId());
            return cartItemDB;
        }
        cartItem.setQuantity(1);
        return cartItemRepository.saveAndFlush(cartItem);
    }

    public void deleteById(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clear(Long cartId) {
        cartItemRepository.deleteAllByCart(cartId);
    }
}
