package com.example.VaschStore.Carts;

import com.example.VaschStore.Persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    //@Query("SELECT c FROM Cart c WHERE c.person = ?1")
    Optional<Cart> findCartByPerson(Person person);
}
