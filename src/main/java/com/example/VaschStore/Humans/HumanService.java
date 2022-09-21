package com.example.VaschStore.Humans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.*;
import java.util.List;
import java.util.Optional;

@Service
public class HumanService {
    private final HumanRepository humanRepository;
    private final PasswordEncoder passwordEncoder;
    private final int admin = 1;

    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public ResponseEntity<List<Human>> findAll(Long humanId) {
        if(checkAccess(humanId))
            return new ResponseEntity<>(humanRepository.findAll(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    private boolean checkAccess(Long humanId)
    {
        Optional<Human> humanOptAdmin = humanRepository.findById(humanId);
        return humanOptAdmin.isPresent() && humanOptAdmin.get().getRole().getId() == admin;
    }

    public ResponseEntity<Human> add(Human human) {
        //email exists?
        Optional<Human> optionalHuman = humanRepository.findByEmail(human.getEmail());
        if(optionalHuman.isPresent())
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        human.setPassword(passwordEncoder.encode(human.getPassword()));
        return new ResponseEntity<>(humanRepository.save(human), HttpStatus.OK);
    }

    public ResponseEntity<Optional<Human>> findByEmailAndPassword(String humanEmail, String humanPassword) {
        Optional<Human> optionalHuman = findByEmail(humanEmail);
        if(optionalHuman.isPresent() &&
                passwordEncoder.matches(humanPassword, optionalHuman.get().getPassword()))
            return new ResponseEntity<>(optionalHuman, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    public Optional<Human> findByEmail(String humanEmail) {
        return humanRepository.findByEmail(humanEmail);
    }
}
