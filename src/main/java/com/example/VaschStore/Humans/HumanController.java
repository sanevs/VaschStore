package com.example.VaschStore.Humans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "humans")
public class HumanController {
    private final HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping(path = "all")
    public List<Human> findAll()
    {
        return humanService.findAll();
    }

    @GetMapping(path = "{humanEmail}/{humanPassword}")
    public Optional<Human> findByEmailAndPassword(
            @PathVariable String humanEmail,
            @PathVariable String humanPassword)
    {
        return humanService.findByEmailAndPassword(humanEmail, humanPassword);
    }
    @GetMapping(path = "{humanEmail}")
    public Optional<Human> findByEmail(
            @PathVariable String humanEmail)
    {
        return humanService.findByEmail(humanEmail);
    }

    @PostMapping(path = "add")
    public Human add(@RequestBody Human human)
    {
        return humanService.add(human);
    }

    @PostMapping(path = "delete/{humanId}")
    public void deleteById(@PathVariable Long humanId)
    {
        humanService.deleteById(humanId);
    }

}
