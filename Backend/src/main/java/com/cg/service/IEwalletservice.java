package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.BankAccount;
import com.cg.entity.Debitcard;
import com.cg.entity.TransactionDetails;
import com.cg.entity.WalletUser;
import com.cg.userException.AddmoneyServiceException;


@Service
public interface IEwalletservice {
	public void createBankdetails(BankAccount s);
	public List getbankdetails();
	public BankAccount getbankdetailbyId(String accountno) throws AddmoneyServiceException;
	public void updatebankamount(double amount,String acc_no) throws AddmoneyServiceException;
	
	
	public void createwalletdetails(WalletUser w);
	public WalletUser getwalletdetailsbyid(int walletid);
	public List walletdetails();
	public void updatewalletamount(double amount,int walletid);
	
	
	public void createdebitdetails(Debitcard d);
	public List getdebitcarddetails();
	
	public void createtransactiondetails(TransactionDetails t);
	public List transactionaldetail(int walletid);
	public TransactionDetails gettransactiondetailbytransactionId(int transactionid);
	
	public String addMoneyviabankaccount(int walletid,double amount) throws AddmoneyServiceException;
	public String addMoneyviadebitcard(int walletid,double amount,String debitcardNo,int cvv,int expirymonth,int expiryyear)throws AddmoneyServiceException;
	public String linkbankaccount(int walletid, String bankaccountno) throws AddmoneyServiceException;
	public String checkenteredAmount(double enteredamount)throws AddmoneyServiceException;
public String Checkbankislinked(int walletid) throws AddmoneyServiceException;	
	
	
}
