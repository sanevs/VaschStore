package com.example.VaschStore.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public void deleteById(Long userId) {
        personRepository.deleteById(userId);
    }

    public Optional<Person> findByEmailAndPassword(String userEmail, String userPassword) {
        return personRepository.findByEmailAndPassword(userEmail, userPassword);
    }
}
