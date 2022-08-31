package com.example.VaschStore.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "users")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "all")
    public List<Person> findAll()
    {
        return personService.findAll();
    }

    @GetMapping(path = "{userEmail}/{userPassword}")
    public Optional<Person> findByEmailAndPassword(
            @PathVariable String userEmail,
            @PathVariable String userPassword)
    {
        return personService.findByEmailAndPassword(userEmail, userPassword);
    }

    @PostMapping(path = "add")
    public void add(@RequestBody Person person)
    {
        personService.add(person);
    }

    @PostMapping(path = "delete/{userId}")
    public void deleteById(@PathVariable Long userId)
    {
        personService.deleteById(userId);
    }
}
