package com.cg.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name="Walletaccount")
public class WalletUser {

	@Id
	@Column
	private int walletId;
	
	@Column
	private double amount;
	
	@JsonManagedReference 
	@ManyToOne
	private BankAccount bankuser;
	
	@ManyToMany(mappedBy="wallet")
	private List<Debitcard> debit;
	
	@JsonManagedReference
	@OneToMany(mappedBy="walletid")
	private List<TransactionDetails> transId;

	
	public List<TransactionDetails> getTransId() {
		return transId;
	}

	public void setTransId(List<TransactionDetails> transId) {
		this.transId = transId;
	}

	

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BankAccount getBank() {
		return bankuser;
	}

	public void setBank(BankAccount bankuser) {
		this.bankuser = bankuser;
	}

	public List<Debitcard> getDebit() {
		return debit;
	}

	public void setDebit(List<Debitcard> debit) {
		this.debit = debit;
	}

	public WalletUser() {
		super();
	}
	public WalletUser(int walletId, double amount, BankAccount bankuser, List<Debitcard> debit,
			List<TransactionDetails> transId) {
		super();
		this.walletId = walletId;
		this.amount = amount;
		this.bankuser = bankuser;
		this.debit = debit;
		this.transId = transId;
	}
	

	
}
