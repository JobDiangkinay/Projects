package com.project0.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.data.AccountRepository;
import com.project0.model.Account;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account getAccountById(int id) {
		return accountRepository.getAccountById(id);
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		return (ArrayList<Account>) accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		Account newAccount = account;
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		newAccount.setSaltPassword(salt);
		System.out.println(newAccount.getSaltPassword());
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(salt);

			byte[] hashedPassword = md.digest(newAccount.getPassword().getBytes(StandardCharsets.UTF_8));
			newAccount.setHashPassword(hashedPassword);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return accountRepository.save(newAccount);
	}
	
	@Override
	public String logIn(String username, String password) {
		try {
			Account curAccount = accountRepository.getAccountByUsername(username);
			byte[] hashPassword = curAccount.getHashPassword();
			byte[] hashSalt = curAccount.getSaltPassword();
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-512");
			md.update(hashSalt);
			byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
			if (Arrays.equals(hashedPassword, hashPassword)) {
				return "true";
			}
			return "false";
		}catch(Exception ex) {
			return "false";
		}
	}
	
}
