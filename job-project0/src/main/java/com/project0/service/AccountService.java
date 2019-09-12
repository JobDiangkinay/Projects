package com.project0.service;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;

import com.project0.model.Account;

public interface AccountService {

	public Account getAccountById(@PathVariable int id);
	public ArrayList<Account> getAllAccounts();
	public Account createAccount(Account account);
	public String logIn(String username, String password);
}
