package com.flatmate.flatmateapp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "flatmate_account")
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	@JsonIgnore
	private String password;

	@OneToMany(mappedBy = "account")
	private Set<Transaction> transactions = new HashSet<>();

	private Account() {}

	public Account(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	public Long getId() { return id; }

	public String getUsername() { return username; }

	public String getPassword() { return password; }

	public Set<Transaction> getTransactions() { return transactions; }

}