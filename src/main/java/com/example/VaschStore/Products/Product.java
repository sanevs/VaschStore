package com.example.VaschStore.Products;

import com.example.VaschStore.Categories.Category;
import com.example.VaschStore.Sizes.Size;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private String image;

    @ManyToOne(targetEntity = Size.class)
    private Size size;

    @ManyToOne(targetEntity = Category.class)

    private Category category;


    public Product() {
    }

    public Product(String name, Long price, String image, Size size, Category category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.size = size;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", size=" + size +
                ", category=" + category +
                '}';
    }
}
