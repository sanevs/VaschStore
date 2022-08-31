package com.example.VaschStore.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "products")

public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "all")
    public List<Product> findAll()
    {
        return productService.findAll();
    }
    @GetMapping(path = "{productId}")
    public Optional<Product> findById(@PathVariable Long productId){
        return productService.findById(productId);
    }

    @PostMapping(path = "add")
    public void add(@RequestBody Product product)
    {
        productService.add(product);
    }

    @PostMapping(path = "delete/{productId}")
    public void deleteById(@PathVariable Long productId)
    {
        productService.deleteById(productId);
    }
}
