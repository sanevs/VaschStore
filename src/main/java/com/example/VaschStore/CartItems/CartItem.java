package com.example.VaschStore.CartItems;

import com.example.VaschStore.Carts.Cart;
import com.example.VaschStore.Products.Product;
import com.example.VaschStore.Sizes.Size;

import javax.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Cart.class)
    private Cart cart;

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @ManyToOne(targetEntity = Size.class)
    private Size size;

    private int quantity;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product, Size size, int quantity) {
        this.cart = cart;
        this.product = product;
        this.size = size;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cart=" + cart +
                ", product=" + product +
                ", size=" + size +
                ", quantity=" + quantity +
                '}';
    }
}
