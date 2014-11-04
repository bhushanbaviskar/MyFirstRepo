package com.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Account;
import com.rest.repositories.AccountRepository;

@Service
public class AccountServiceImpl {
	
	@Autowired
	AccountRepository accountRepo;
	
	public String saveAccountDetails(Account accountDetails) {
		accountRepo.save(accountDetails);
		return ":)";
	}
}
