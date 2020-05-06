package com.cg.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name="Transactiondetails")
public class TransactionDetails {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    @SequenceGenerator(sequenceName = "transaction_sequence", allocationSize = 1, name = "transaction_sequence")
   
	@Id
	@Column
	private int tranid;
	
	@Column
	private double amount;
	
	@Column
	private String accountNo;
	
	
	@Column
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private String trans_time;
	@Column
	private String bankname;
	
	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@JsonBackReference
	@ManyToOne
	private WalletUser walletid;

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public WalletUser getWalletid() {
		return walletid;
	}

	public void setWalletid(WalletUser walletid) {
		this.walletid = walletid;
	}


	

	

	

	public String getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(String trans_time) {
		this.trans_time = trans_time;
	}

	

	public TransactionDetails(int tranid, double amount, String accountNo, String trans_time, String bankname,
			WalletUser walletid) {
		super();
		this.tranid = tranid;
		this.amount = amount;
		this.accountNo = accountNo;
		this.trans_time = trans_time;
		this.bankname = bankname;
		this.walletid = walletid;
	}

	public TransactionDetails() {
		super();
	}
	
	
}
