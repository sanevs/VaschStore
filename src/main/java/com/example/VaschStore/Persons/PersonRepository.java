package com.example.VaschStore.Persons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM Person p WHERE p.email = ?1 AND p.password = ?2", nativeQuery = true)
    Optional<Person> findByEmailAndPassword(String userEmail, String userPassword);
}
