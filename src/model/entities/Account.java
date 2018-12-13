package model.entities;

import model.exceptions.DomainExceptions;
import model.exceptions.NotEnoughBalance;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		balance = balance - amount;
	}
	
	public void withdraw(Double amount) throws DomainExceptions, NotEnoughBalance {
		if(amount > getWithdrawLimit()) {
			throw new DomainExceptions("The amount exceeds withdraw limit");
		}
		else if(amount > getBalance()) {
			throw new NotEnoughBalance("Not enough balance");
		}
		else {
		balance = balance - amount;
		}
	}
	
	
}
