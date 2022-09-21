package com.example.VaschStore.Humans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "all/{humanId}")
    public ResponseEntity<List<Human>> findAll(@PathVariable Long humanId)
    {
        return humanService.findAll(humanId);
    }

    @GetMapping(path = "{humanEmail}/{humanPassword}")
    public ResponseEntity<Optional<Human>> findByEmailAndPassword(
            @PathVariable String humanEmail,
            @PathVariable String humanPassword)
    {
        return humanService.findByEmailAndPassword(humanEmail, humanPassword);
    }
    @GetMapping(path = "{humanEmail}")
    public Optional<Human> findByEmail(@PathVariable String humanEmail)
    {
        return humanService.findByEmail(humanEmail);
    }

    @PostMapping(path = "add")
    public ResponseEntity<Human> add(@RequestBody Human human)
    {
        return humanService.add(human);
    }
}
