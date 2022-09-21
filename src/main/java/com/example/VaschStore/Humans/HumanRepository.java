package com.example.VaschStore.Humans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
    @Query(value = "SELECT * FROM Human h WHERE h.email = ?1", nativeQuery = true)
    Optional<Human> findByEmail(String humanEmail);
}
