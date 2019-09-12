package com.project0.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.data.BankAccountRepository;
import com.project0.model.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountRepository bankAccountRepo;

	@Override
	public BankAccount getBankAccountById(int id) {
		return bankAccountRepo.getAccountById(id);
	}

	@Override
	public ArrayList<BankAccount> getAllBankAccount() {
		return (ArrayList<BankAccount>) bankAccountRepo.findAll();
	}

	@Override
	public BankAccount createBankAccount(BankAccount bankAccount) {
		return bankAccountRepo.save(bankAccount);
	}
	

}
