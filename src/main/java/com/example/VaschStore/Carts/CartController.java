package com.example.VaschStore.Carts;

import com.example.VaschStore.Persons.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "carts")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "getByPerson")
    public Optional<Cart> getByPerson(@RequestBody Person person)
    {
        return cartService.getByPerson(person);
    }

    @PostMapping(path = "add")
    public void add(@RequestBody Cart cart)
    {
        cartService.add(cart);
    }
}
