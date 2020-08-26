package com.rentit.demo.controller;

import com.rentit.demo.model.Rentee;
import com.rentit.demo.repository.RenteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class RenteeController {

    @Autowired
    private RenteeRepository repository;

    @GetMapping(path = "/rentees")
    public @ResponseBody
    Iterable<Rentee> getAllRentees() {
        return repository.findAll(); // This returns a JSON or XML with the renters
    }

    @GetMapping(path = "/rentees/{id}")
    public Optional<Rentee> getRentee(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/rentees")
    public Rentee createRentee(@RequestBody Rentee rentee) {
        return repository.save(rentee);
    }

    @PutMapping(path = "/rentees")
    public Rentee updateRentee(@RequestBody Rentee rentee) {
        return repository.save(rentee);
    }

    @DeleteMapping(path = "/rentees/{id}")
    @ResponseBody
    public String deleteRentee(@PathVariable("id") Integer id) throws Exception {
        repository.deleteById(id);
        return MessageFormat.format("Rentee with ID {0} has been deleted.", id);
    }
}
