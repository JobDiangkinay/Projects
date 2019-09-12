package com.project0.service;

import java.util.ArrayList;

import com.project0.model.BankAccount;

public interface BankAccountService {
	public BankAccount getBankAccountById(int id);
	public ArrayList<BankAccount> getAllBankAccount();
	public BankAccount createBankAccount(BankAccount bankAccount);

}
