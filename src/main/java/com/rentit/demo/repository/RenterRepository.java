package com.rentit.demo.repository;


import com.rentit.demo.model.Renter;
import org.springframework.data.repository.CrudRepository;

public interface RenterRepository extends CrudRepository<Renter, Integer> {
}
