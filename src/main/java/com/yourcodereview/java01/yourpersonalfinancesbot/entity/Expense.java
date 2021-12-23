package com.yourcodereview.java01.yourpersonalfinancesbot.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	long amount;
	ExpenseCategory expenseCategory;
	BankAccount sourceBankAccount;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}
	
	public void setSourceBankAccount(BankAccount sourceBankAccount) {
		this.sourceBankAccount = sourceBankAccount;
	}
	
	public BankAccount getSourceBankAccount() {
		return sourceBankAccount;
	}
	
}
