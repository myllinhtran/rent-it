package com.rentit.demo.controller;

import com.rentit.demo.model.Image;
import com.rentit.demo.model.Renter;
import com.rentit.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class ImageController {

    @Autowired
    private ImageRepository repository;

    @GetMapping(path = "/images")
    public @ResponseBody
    Iterable<Image> getAllImages() {
        return repository.findAll(); // This returns a JSON or XML with the renters
    }

    @GetMapping(path = "/images/{id}")
    public Optional<Image> getImage(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/images")
    public Image createImage(@RequestBody Image image) {
        return repository.save(image);
    }

    @PutMapping(path = "/images")
    public Image updateImage(@RequestBody Image image) {
        return repository.save(image);
    }

    @DeleteMapping(path = "/images/{id}")
    @ResponseBody
    public String deleteImage(@PathVariable("id") Integer id) throws Exception {
        repository.deleteById(id);
        return MessageFormat.format("Image with ID {0} has been deleted.", id);
    }
}
