package com.cg.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IBankAccountDao;
import com.cg.dao.IDebitcardDao;
import com.cg.dao.ITransactionDao;
import com.cg.dao.IWalletDao;
import com.cg.entity.BankAccount;
import com.cg.entity.Debitcard;
import com.cg.entity.TransactionDetails;
import com.cg.entity.WalletUser;
import com.cg.userException.AddmoneyServiceException;
@Service
public class EWalletservice implements IEwalletservice{

	@Autowired
	IBankAccountDao bankdao;
	
	@Autowired
	IDebitcardDao debitdao;
	
	@Autowired
	IWalletDao walletdao;
	@Autowired
	ITransactionDao transdao;

	@Override
	public void createBankdetails(BankAccount s) {
		bankdao.save(s);
		
	}
	
	@Override
	public List getbankdetails() {
		List<BankAccount>bank = new ArrayList<>();
		bankdao.findAll().forEach(bank::add);
		return bank;
		
	}
	@Override
	public void createwalletdetails(WalletUser w) {
		walletdao.save(w);
		
	}
	@Override
	public void createdebitdetails(Debitcard d) {
		debitdao.save(d);
		
	}
	
	@Override
	public void createtransactiondetails(TransactionDetails t) {
		transdao.save(t);
		
	}
	@Override
	public WalletUser getwalletdetailsbyid(int walletid) {
		WalletUser walletuser =walletdao.findById(walletid).orElse(null);
		if(walletuser==null)
		{
			
			WalletUser walletuser1=new WalletUser();
			walletuser1.setWalletId(walletid);
			walletuser1.setAmount(0.0);
			
			walletdao.save(walletuser1);
			 walletuser1=walletdao.findById(walletid).orElse(null);
			return walletuser1;
		}
//		walletdao.findAll().forEach(walletusers::add);
		else
		{
			
			return walletuser;
		}
			
		
	}

	@Override
	public List getdebitcarddetails() {
		List<Debitcard> debitcards = new ArrayList<>();
		debitdao.findAll().forEach(debitcards::add);
		return debitcards;
	}

	@Override
	public void updatebankamount(double amount, String acc_no)throws AddmoneyServiceException{
		BankAccount bank;
		
		bank=bankdao.findById(acc_no).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		if(bank.getBankbal()<1000.0)
			throw new AddmoneyServiceException("Cannot make Transaction.Your Bank balance is below 1000.");
		if(bank.getBankbal()<amount)
			throw new AddmoneyServiceException("Insufficient Balance in your bank");
		double updatebal=bank.getBankbal()-amount;
		bank.setBankbal(updatebal);
		bankdao.save(bank);
		
		
	}

	@Override
	public void updatewalletamount(double amount, int walletid) {
		WalletUser walletuser;
		walletuser = walletdao.findById(walletid).orElse(null);
		double updatewalletamount = walletuser.getAmount()+amount;
		walletuser.setAmount(updatewalletamount);
		walletdao.save(walletuser);
		
	}

	@Override
	public String addMoneyviabankaccount(int walletid, double amount) throws AddmoneyServiceException{
		WalletUser walletuser;
		walletuser= walletdao.findById(walletid).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		String acc_no =walletuser.getBank().getAccountNo();
		//updatebankamount(amount, acc_no);
BankAccount bank;
		
		bank=bankdao.findById(acc_no).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		if(bank.getBankbal()<1000.0)
			throw new AddmoneyServiceException("Cannot make Transaction.Your Bank balance is below 1000.");
		if(bank.getBankbal()<amount)
			throw new AddmoneyServiceException("Insufficient Balance in your bank");
		double updatebal=bank.getBankbal()-amount;
		bank.setBankbal(updatebal);
		bankdao.save(bank);
		updatewalletamount(amount, walletid);
		TransactionDetails t =new TransactionDetails();
		t.setAmount(amount);
		t.setAccountNo(walletuser.getBank().getAccountNo());
		t.setBankname(walletuser.getBank().getBankname());
		Date dateNow = new Date( );
	    
		/*
		 * To set date in specific format
		 */
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    t.setTrans_time(objectOfSimpleDateFormat.format(dateNow));

		t.setWalletid(walletuser);
		createtransactiondetails(t);
		int t1=t.getTranid();
		String s = Integer.toString(t1);
		return s;
	
	}

	
	@Override
	public String addMoneyviadebitcard(int walletid, double amount,String debitcardNo,int cvv,int expirymonth,int expiryyear)throws AddmoneyServiceException{
		WalletUser walletuser=new WalletUser();
		Debitcard debit=new Debitcard();
		debit = debitdao.findById(debitcardNo).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		boolean cvvcheck,expirymonthcheck,expiryyearcheck;
		cvvcheck=debit.getCvv()==cvv;
		expirymonthcheck=debit.getExpiremonth()==expirymonth;
		expiryyearcheck=debit.getExpireyear()==expiryyear;
		if(cvvcheck && expirymonthcheck && expiryyearcheck)
		{
		walletuser= walletdao.findById(walletid).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		String acc_no =debit.getBanks().getAccountNo();
		
		//updatebankamount(amount, acc_no);
		BankAccount bank;
		
		bank=bankdao.findById(acc_no).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		if(bank.getBankbal()<1000.0)
			throw new AddmoneyServiceException("Cannot make Transaction.Your Bank balance is below 1000.");
		if(bank.getBankbal()<amount)
			throw new AddmoneyServiceException("Insufficient Balance in your bank");
		double updatebal=bank.getBankbal()-amount;
		bank.setBankbal(updatebal);
		bankdao.save(bank);
		updatewalletamount(amount, walletid);
		TransactionDetails t =new TransactionDetails();
		t.setAmount(amount);
		t.setAccountNo(walletuser.getBank().getAccountNo());
		t.setBankname(walletuser.getBank().getBankname());

		Date dateNow = new Date( );
	    
		/*
		 * To set date in specific format
		 */
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    t.setTrans_time(objectOfSimpleDateFormat.format(dateNow));

		t.setWalletid(walletuser);
		createtransactiondetails(t);
		int t1=t.getTranid();
		String s = Integer.toString(t1);
		return s;
		}
		else
		{
			throw new AddmoneyServiceException("Cannot make transaction !You have entered Wrong Detail");
		}
		
	}

	@Override
	public List walletdetails() {
		List<WalletUser>wallet = new ArrayList<>();
		walletdao.findAll().forEach(wallet::add);
		return wallet;
	}

	@Override
	public String linkbankaccount(int walletid, String bankaccountno) {
		WalletUser walletuser =new WalletUser();
		walletuser= walletdao.findById(walletid).orElse(null);
		if(walletuser.getBank()!=null)
			return "already Linked";
		BankAccount bank=new BankAccount();
		bank.setAccountNo(bankaccountno);
		walletuser.setBank(bank);
		walletdao.save(walletuser);
		return "linked";
	}

	@Override
	public List transactionaldetail(int walletid) {
		WalletUser walletuser =new WalletUser();
		walletuser=getwalletdetailsbyid(walletid);
		
		List<TransactionDetails>transactiondetails = new ArrayList<>();
		transactiondetails=walletuser.getTransId();
		return transactiondetails;
		
	}

	@Override
	public TransactionDetails gettransactiondetailbytransactionId(int transactionid) {
		TransactionDetails transactiondetail=transdao.findById(transactionid).orElse(null);
		return transactiondetail;
	}

	@Override
	public String checkenteredAmount(double enteredamount)throws AddmoneyServiceException{
		if(enteredamount<=0)
			throw new AddmoneyServiceException("Amount Entered must be greater than 0");
		else
		{ 
			return Double.toString(enteredamount);
		}
	}
	
	

}
