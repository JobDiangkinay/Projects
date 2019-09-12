package com.project0.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project0.data.BankAccountRepository;
import com.project0.model.BankAccount;
import com.project0.service.BankAccountService;

@RestController
@Transactional
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@GetMapping("/bankaccount/{id}")
	public BankAccount getBankAccountById(@PathVariable int id) {
		return bankAccountService.getBankAccountById(id);
	}
	
	@GetMapping("/bankaccount")
	public ArrayList<BankAccount> getAllBankAccount(){
		return (ArrayList<BankAccount>) bankAccountService.getAllBankAccount();
	}
	
	@PostMapping("/bankaccount/")
	public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
		return bankAccountService.createBankAccount(bankAccount);
	}

}
