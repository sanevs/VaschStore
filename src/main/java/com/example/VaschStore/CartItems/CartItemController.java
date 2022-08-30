package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cartItems")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping(path = "allByCart")
    public List<CartItem> getAllByCart(@RequestBody Cart cart)
    {
        return cartItemService.getAllByCart(cart);
    }
}