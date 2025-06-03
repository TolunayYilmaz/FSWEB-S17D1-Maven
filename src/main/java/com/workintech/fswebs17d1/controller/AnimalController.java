package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> findAll() {
        return animals.values().stream().toList();
    }

    @GetMapping("/animal/{id}")
    public Animal findOne(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public void createAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/animal/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animal.setId(id);
        animals.put(id, animal);
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animals.remove(id);
    }
}
