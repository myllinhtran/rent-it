package com.rentit.demo.repository;


import com.rentit.demo.model.User;
import com.rentit.demo.repository.jpa.JpaUserRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaUserRepository, CrudRepository<User, Integer> {
}
