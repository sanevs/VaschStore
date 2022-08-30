package com.example.VaschStore.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")

public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "all")
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @PostMapping(path = "add")
    public void addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
    }
}
