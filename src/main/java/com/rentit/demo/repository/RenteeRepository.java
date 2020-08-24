package com.rentit.demo.repository;

import com.rentit.demo.model.Rentee;
import org.springframework.data.repository.CrudRepository;

public interface RenteeRepository extends CrudRepository<Rentee, Integer> {
}
