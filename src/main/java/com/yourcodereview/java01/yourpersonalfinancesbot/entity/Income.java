package com.yourcodereview.java01.yourpersonalfinancesbot.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	long amount;
	IncomeSource incomeSource;
	
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
	
	public void setIncomeSource(IncomeSource incomeSource) {
		this.incomeSource = incomeSource;
	}
	
	public IncomeSource getIncomeSource() {
		return incomeSource;
	}
	
}
