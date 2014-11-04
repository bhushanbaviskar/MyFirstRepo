package com.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{
	
}
