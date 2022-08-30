package com.example.VaschStore.Carts;

import com.example.VaschStore.Persons.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> getByPerson(Person person) {

        return cartRepository.findCartByPerson(person);
    }

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }
}
