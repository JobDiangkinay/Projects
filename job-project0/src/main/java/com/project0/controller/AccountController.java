package com.project0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.data.AccountRepository;
import com.project0.model.Account;

@RestController
@Transactional
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable int id) {
		return accountRepository.getAccountById(id);
	}
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
}
