package com.rentit.demo.repository.rest;

import com.rentit.demo.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {
}
