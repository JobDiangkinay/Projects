package com.project0.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "usertype")
	private String accountType;
	@Column(name = "saltpassword")
	private byte[] saltPassword;
	@Column(name = "hashpassword")
	private byte[] hashPassword;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "person")
	private Person person;
	@Transient
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public byte[] getSaltPassword() {
		return saltPassword;
	}

	public void setSaltPassword(byte[] saltPassword) {
		this.saltPassword = saltPassword;
	}

	public byte[] getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(byte[] hashPassword) {
		this.hashPassword = hashPassword;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Account(int id, String userName, String accountType, byte[] saltPassword, byte[] hashPassword,
			Person person) {
		super();
		this.id = id;
		this.username = userName;
		this.accountType = accountType;
		this.saltPassword = saltPassword;
		this.hashPassword = hashPassword;
		this.person = person;
	}

}
