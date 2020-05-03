package com.cg.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
@Table(name="Debitcard")
public class Debitcard {
	@Id
	@Column
	private String debitid;
	
	@Column
	private int cvv;
	
	@Column
	private int expiremonth;
	
	@Column
	private int expireyear;
	

	@JsonManagedReference
	@ManyToOne
	private BankAccount banks;
	
	@ManyToMany
	private List<WalletUser> wallet;
	

	
	public Debitcard() {
		super();
	}



	public String getDebitid() {
		return debitid;
	}



	public void setDebitid(String debitid) {
		this.debitid = debitid;
	}



	public int getCvv() {
		return cvv;
	}



	public void setCvv(int cvv) {
		this.cvv = cvv;
	}



	public int getExpiremonth() {
		return expiremonth;
	}



	public void setExpiremonth(int expiremonth) {
		this.expiremonth = expiremonth;
	}



	public int getExpireyear() {
		return expireyear;
	}



	public void setExpireyear(int expireyear) {
		this.expireyear = expireyear;
	}



	



	public BankAccount getBanks() {
		return banks;
	}



	public void setBanks(BankAccount banks) {
		this.banks = banks;
	}



	public List<WalletUser> getWallet() {
		return wallet;
	}



	public void setWallet(List<WalletUser> wallet) {
		this.wallet = wallet;
	}



	public Debitcard(String debitid, int cvv, int expiremonth, int expireyear, BankAccount banks,
			List<WalletUser> wallet) {
		super();
		this.debitid = debitid;
		this.cvv = cvv;
		this.expiremonth = expiremonth;
		this.expireyear = expireyear;
		this.banks = banks;
		this.wallet = wallet;
	}







		
}
