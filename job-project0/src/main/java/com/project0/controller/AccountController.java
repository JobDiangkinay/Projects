package com.project0.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.data.AccountRepository;
import com.project0.model.Account;
import com.project0.service.AccountService;

@RestController
@Transactional
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable int id) {
		return accountService.getAccountById(id);
	}
	
	@GetMapping("/account")
	public ArrayList<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/account/login/{username}/{password}")
	public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
		return accountService.logIn(username, password);
	}
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
}
