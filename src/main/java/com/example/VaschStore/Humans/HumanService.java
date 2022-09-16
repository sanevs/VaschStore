package com.example.VaschStore.Humans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumanService {
    private final HumanRepository humanRepository;

    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public List<Human> findAll() {
        return humanRepository.findAll();
    }

    public Human add(Human human) {
        return humanRepository.save(human);
    }

    public void deleteById(Long humanId) {
        humanRepository.deleteById(humanId);
    }

    public Optional<Human> findByEmailAndPassword(String humanEmail, String humanPassword) {
        return humanRepository.findByEmailAndPassword(humanEmail, humanPassword);
    }

    public Optional<Human> findByEmail(String humanEmail) {
        return humanRepository.findByEmail(humanEmail);
    }
}
