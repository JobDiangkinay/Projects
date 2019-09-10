package com.project0.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project0.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
	
	public BankAccount getAccountById(int id);

}
