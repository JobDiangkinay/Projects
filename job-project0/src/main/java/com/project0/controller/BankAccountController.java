package com.project0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project0.data.BankAccountRepository;
import com.project0.model.BankAccount;

public class BankAccountController {
	
	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@GetMapping("/bankaccount/{id}")
	public BankAccount getBankAccountById(@PathVariable int id) {
		return bankAccountRepository.getAccountById(id);
	}
	
	@PostMapping("/bankaccount/")
	public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}

}
