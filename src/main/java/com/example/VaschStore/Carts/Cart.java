package com.example.VaschStore.Carts;


import com.example.VaschStore.Humans.Human;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Human.class)
    private Human human;

    public Cart() {
    }

    public Cart(Human human) {
        this.human = human;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", human=" + human +
                '}';
    }
}
