package com.yourcodereview.java01.yourpersonalfinancesbot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	long currencyAmount;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCurrencyAmount(long currencyAmount) {
		this.currencyAmount = currencyAmount;
	}
	
	public long getCurrencyAmount() {
		return currencyAmount;
	}
	
}
