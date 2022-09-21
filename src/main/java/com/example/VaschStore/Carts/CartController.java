package com.example.VaschStore.Carts;

import com.example.VaschStore.Humans.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "carts")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(path = "getByPerson")
    public Optional<Cart> getByPerson(@RequestBody Human human)
    {
        return cartService.getByPerson(human);
    }

    @PostMapping(path = "add")
    public Cart add(@RequestBody Cart cart)
    {
        return cartService.add(cart);
    }
}
