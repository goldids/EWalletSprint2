package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name="Bankaccount")
public class BankAccount {

	@Id
	@Column
	private String accountNo;
	
	@Column
	private String phoneNo;
	
	@Column
	private double bankbal;
	
	@Column
	private String bankname;
	@Column
	private String accountholdername;
	
	@JsonBackReference
	@OneToMany(mappedBy="banks")
	private List<Debitcard> debit =new ArrayList<Debitcard>();
	
	@JsonBackReference
	@OneToMany(mappedBy="bankuser")
	private List<WalletUser> walletuser = new ArrayList<WalletUser>();
	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public double getBankbal() {
		return bankbal;
	}



	public void setBankbal(double bankbal) {
		this.bankbal = bankbal;
	}



	public String getBankname() {
		return bankname;
	}



	public void setBankname(String bankname) {
		this.bankname = bankname;
	}



	public List<Debitcard> getDebit() {
		return debit;
	}



	public void setDebit(List<Debitcard> debit) {
		this.debit = debit;
	}



	public BankAccount() {
		super();
	}




	public List<WalletUser> getWalletuser() {
		return walletuser;
	}



	public void setWalletuser(List<WalletUser> walletuser) {
		this.walletuser = walletuser;
	}



	public BankAccount(String accountNo, String phoneNo, double bankbal, String bankname, String accountholdername,
			List<Debitcard> debit, List<WalletUser> walletuser) {
		super();
		this.accountNo = accountNo;
		this.phoneNo = phoneNo;
		this.bankbal = bankbal;
		this.bankname = bankname;
		this.accountholdername = accountholdername;
		this.debit = debit;
		this.walletuser = walletuser;
	}



	public String getAccountholdername() {
		return accountholdername;
	}



	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}



	


}
