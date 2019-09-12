package com.project0.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project0.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	public Account getAccountById(int id);
	public Account getAccountByUsername(String username);
	
}
