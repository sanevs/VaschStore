package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "cartItems")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping(path = "allByCart")
    public List<CartItem> getAllByCart(@RequestBody Cart cart)
    {
        return cartItemService.getAllByCart(cart);
    }

    @PostMapping(path = "add")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CartItem add(@RequestBody CartItem cartItem)
    {
        return cartItemService.add(cartItem);
    }

    @PostMapping(path = "delete/{cartItemId}")
    public void deleteById(@PathVariable Long cartItemId)
    {
        cartItemService.deleteById(cartItemId);
    }

    @PostMapping(path = "clearByCartId/{cartId}")
    public void clear(@PathVariable Long cartId)
    {
        cartItemService.clear(cartId);
    }
}
