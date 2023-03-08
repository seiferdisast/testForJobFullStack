package com.seifer.fruitshop.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seifer.fruitshop.model.*;
import com.seifer.fruitshop.repositories.*;

@RestController
@RequestMapping("/fruitcontroller")
public class FruitController {

    @Autowired
    private FruitRepo fruitRepo;

    @GetMapping()
    // implement method for do list fonr size certain quantity
    public List<Fruit> getAllFruits() {
        return fruitRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(fruitRepo.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Fruit fruit) {
        try {
            return new ResponseEntity<>(fruitRepo.save(fruit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Fruit updatedFruit) {

        Optional<Fruit> optionalFruit = fruitRepo.findById(id);

        if (optionalFruit != null) {
            Fruit existingFruit = optionalFruit.get();

            existingFruit.setType(updatedFruit.getType());
            existingFruit.setQuantity(updatedFruit.getQuantity());
            existingFruit.setPrice(updatedFruit.getPrice());

            Fruit savedFruit = fruitRepo.save(existingFruit);
            return new ResponseEntity<>(savedFruit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Fruit> fruitToDelete = fruitRepo.findById(id);
        try {
            fruitRepo.deleteById(id);
            return new ResponseEntity<>(fruitToDelete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
