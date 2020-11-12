package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.User;
import org.springframework.dao.DataAccessException;

public interface JpaUserRepository {

    User add(User user) throws DataAccessException;
}
