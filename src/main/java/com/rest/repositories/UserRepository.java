package com.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.entities.User;

@Repository
public interface  UserRepository extends CrudRepository<User, Integer>{

}
