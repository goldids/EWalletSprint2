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
	ITransactionDao transactiondetaildao;

	/**********************************************************************************************************************
	 * Method:       createdebitdetails
	 * description:  Add the details of bank like acoount number, Account balance, BankName, phone number and Account holder name in the bank table
	 * @return 		Nothing returns
	 * created by 	 Goldi D Singh
	 * created date  26-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public void createBankdetails(BankAccount refbankaccount) {
		bankdao.save(refbankaccount);
		
	}
	
	/**********************************************************************************************************************
	 * Method:       getbankdetails
	 * description:  Fetch all the bank details as each row specifies each account number detail. This function will fetch and get the details as in the form of list frm the bank table
	 * @return 		Nothing returns
	 * created by 	 Goldi D Singh
	 * created date  26-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public List getbankdetails() {
		List<BankAccount>refbankaccount = new ArrayList<>();
		bankdao.findAll().forEach(refbankaccount::add);
		return refbankaccount;
		
	}
	/**********************************************************************************************************************
	 * Method:       createwalletdetails
	 * description:  Add the details of wallet like walletid,amount, bank detail to the walletuser table
	 * @return 		Nothing returns
	 * created by 	 Goldi D Singh
	 * created date  26-April-2020
	 * **********************************************************************************************************************
	 * */
	
	@Override
	public void createwalletdetails(WalletUser refofwalletuser) {
		walletdao.save(refofwalletuser);
		
	}
	
	/**********************************************************************************************************************
	 * Method:       createdebitdetails
	 * description:  Add the details of debitcard like card no,cvv,expiry year,expiry month and bank detail to the debitcard table
	 * @return 		Nothing returns
	 * created by 	 Goldi D Singh
	 * created date  26-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public void createdebitdetails(Debitcard refofdebitcard) {
		debitdao.save(refofdebitcard);
		
	}
	
	/**********************************************************************************************************************
	 * Method:       createtransactiondetails
	 * description:  Add the details of transaction like transaction Id , Amount, Bank account number, Bank name to the transactiondetail table
	 * @return 		Nothing returns
	 * created by 	 Goldi D Singh
	 * created date  26-April-2020
	 * **********************************************************************************************************************
	 * */
	
	@Override
	public void createtransactiondetails(TransactionDetails refoftransactiondetails) {
		transactiondetaildao.save(refoftransactiondetails);
		
	}
	
	/**********************************************************************************************************************
	 * Method:       getwalletdetailsbyid
	 * description:  if the entered wallet id is not present in the walletuser table then this means that user is newly registered and hence their amount will be 0 otherwise it will get the wallet detail of the particular walletid
	 * @return 			wallet details of the particular wallet id
	 * created by		Goldi D Singh
	 * created date		26-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public WalletUser getwalletdetailsbyid(int walletid) {
		WalletUser walletuser =walletdao.findById(walletid).orElse(null);
		if(walletuser==null)
		{
			
			WalletUser tempwalletuser=new WalletUser();
			
			tempwalletuser.setWalletId(walletid);
			tempwalletuser.setAmount(0.0);
			tempwalletuser.setBank(null);
			walletdao.save(tempwalletuser);
			 tempwalletuser=walletdao.findById(walletid).orElse(null);
			return tempwalletuser;
		}

		else
		{
			
			return walletuser;
		}
			
		
	}
	/**********************************************************************************************************************
	 * Method:       getdebitcarddetails
	 * description:  This will get all the detail of the debitcard details from the debitcard table
	 * @return 			the list of debit card details present in the debit card table
	 * @throws			AddmoneyServiceException-if the bank balance is less than rs.1000
	 * 												if the amount entered by the user is greater than bank balance
	 * created by		Goldi D Singh
	 * created date		26-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public List getdebitcarddetails() {
		List<Debitcard> debitcards = new ArrayList<>();
		debitdao.findAll().forEach(debitcards::add);
		return debitcards;
	}
	
	
	/**********************************************************************************************************************
	 * Method:       updatebankamount
	 * description:  Bank amount will get debited with amount which user has provided.This is the part of method which get used in the method "addmoneyviabank"
	 * @return       Nothing returns
	 * created by		Goldi D Singh
	 * created date		26-April-2020
	 * **********************************************************************************************************************
	 * */

	@Override
	public void updatebankamount(double amount, String accountno)throws AddmoneyServiceException{
		BankAccount bank;
		
		bank=bankdao.findById(accountno).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		if(bank.getBankbal()<1000.0)
			throw new AddmoneyServiceException("Cannot make Transaction.Your Bank balance is below 1000.");
		if(bank.getBankbal()<amount)
			throw new AddmoneyServiceException("Insufficient Balance in your bank");
		double updatebankbalance=bank.getBankbal()-amount;
		bank.setBankbal(updatebankbalance);
		bankdao.save(bank);
		
		
	}
	/**********************************************************************************************************************
	 * Method:       updatewalletamount
	 * description:  Wallet amount will get credited with amount which user has provided.This is the part of method which get used in the method "addmoneyviabank"
	 * @return 			Nothing returns
	 * created by		Goldi D Singh
	 * created date		27-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public void updatewalletamount(double amount, int walletid) {
		WalletUser walletuser;
		walletuser = walletdao.findById(walletid).orElse(null);
		double updatewalletamount = walletuser.getAmount()+amount;
		walletuser.setAmount(updatewalletamount);
		walletdao.save(walletuser);
		
	}
	/**********************************************************************************************************************
	 * Method:       
	 * description:		In this method user can make their add money with their bank only if their walletid is linked with the bank otherwise not.
	 *   				in this first bank amount is debit and then credit to the wallet account
	 * @return 			the transaction Id when transaction is done
	 * @throws			AddmoneyServiceException-if the user wallet id is not linked with the bank account and tries to add money with the bank
	 * created by		Goldi D Singh
	 * created date		27-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public String addMoneyviabankaccount(int walletid, double amount) throws AddmoneyServiceException{
		WalletUser walletuser;
		walletuser= walletdao.findById(walletid).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		
		if(walletuser.getBank().getAccountNo()=="NA")
			throw new AddmoneyServiceException("Bank Account is not linked");
		String accountno =walletuser.getBank().getAccountNo();
	
		updatebankamount(amount, accountno);

		updatewalletamount(amount, walletid);
		TransactionDetails refoftransactiondetail =new TransactionDetails();
		refoftransactiondetail.setAmount(amount);
		refoftransactiondetail.setAccountNo(walletuser.getBank().getAccountNo());
		refoftransactiondetail.setBankname(walletuser.getBank().getBankname());
		Date dateNow = new Date();
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
		refoftransactiondetail.setTrans_time(objectOfSimpleDateFormat.format(dateNow));

		refoftransactiondetail.setWalletid(walletuser);
		createtransactiondetails(refoftransactiondetail);
		int transactionid=refoftransactiondetail.getTranid();
		return (Integer.toString(transactionid));
		
	
	}
	/**********************************************************************************************************************
	 * Method:     		addMoneyviadebitcard 
	 * description:  	In this method wallet user can make transaction by using their debitcard details like debit card number, cvv, expiry month and expiry year
	 * 					in this first bank amount is debit and then credit to the wallet account
	 * @return 			the transaction Id when transaction is done
	 * @throws			AddmoneyServiceException-when user enter their wrong Debitcard detail			
	 * created by		Goldi D Singh
	 * created date		28-April-2020
	 * **********************************************************************************************************************
	 * */
	
	@Override
	public String addMoneyviadebitcard(int walletid, double amount,String debitcardNo,int cvv,int expirymonth,int expiryyear)throws AddmoneyServiceException{
		WalletUser walletuser=new WalletUser();
		Debitcard detailsofdebitcard=new Debitcard();
		detailsofdebitcard = debitdao.findById(debitcardNo).orElseThrow(()->new AddmoneyServiceException("Cannot make transaction !You have entered Wrong Detail"));
		boolean cvvcheck,expirymonthcheck,expiryyearcheck;
		cvvcheck=detailsofdebitcard.getCvv()==cvv;
		expirymonthcheck=detailsofdebitcard.getExpiremonth()==expirymonth;
		expiryyearcheck=detailsofdebitcard.getExpireyear()==expiryyear;
		if(cvvcheck && expirymonthcheck && expiryyearcheck)
		{
		walletuser= walletdao.findById(walletid).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		
		String accountno =detailsofdebitcard.getBanks().getAccountNo();
		
		updatebankamount(amount, accountno);

		updatewalletamount(amount, walletid);
		
		TransactionDetails refoftransactiondetail =new TransactionDetails();
		refoftransactiondetail.setAmount(amount);
		refoftransactiondetail.setAccountNo(detailsofdebitcard.getBanks().getAccountNo());
		refoftransactiondetail.setBankname(detailsofdebitcard.getBanks().getBankname());

		Date dateNow = new Date();
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
		refoftransactiondetail.setTrans_time(objectOfSimpleDateFormat.format(dateNow));

		refoftransactiondetail.setWalletid(walletuser);
		createtransactiondetails(refoftransactiondetail);
		int transactionid=refoftransactiondetail.getTranid();
		return (Integer.toString(transactionid));
		
		}
		else
		{
			throw new AddmoneyServiceException("Cannot make transaction !You have entered Wrong Detail");
		}
		
	}
	/**********************************************************************************************************************
	 * Method:       walletdetails
	 * description:  fetch all the row of wallet detail from the walletuser table
	 * @return 			the list of the walletuser
	 * created by		Goldi D Singh
	 * created date		28-April-2020
	 * **********************************************************************************************************************
	 * */

	@Override
	public List walletdetails() {
		List<WalletUser>walletdetails = new ArrayList<>();
		walletdao.findAll().forEach(walletdetails::add);
		return walletdetails;
	}
	/**********************************************************************************************************************
	 * Method:       linkbankaccount
	 * description:  If the particular wallet user is not linked with the bank account is not linked then they can link their wallet account
	 * @return 		 If walletId is already linked then "already linked" message will sent otherwise it will link the walletid with bank account and "Linked Successfully" message will be sent
	 * @throws		 AddmoneyServiceException-if user have provide the bank account which will not present in the bank table
	 * created by		Goldi D Singh
	 * created date		28-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public String linkbankaccount(int walletid, String bankaccountno) throws AddmoneyServiceException {
		WalletUser walletuser =new WalletUser();
		walletuser= walletdao.findById(walletid).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		if(walletuser.getBank()!=null)
			return "already Linked";
		BankAccount bankdetails=new BankAccount();
		bankdetails=bankdao.findById(bankaccountno).orElseThrow(()->new AddmoneyServiceException("You Have Entered Invalid Account Number"));
		bankdetails.setAccountNo(bankaccountno);
		walletuser.setBank(bankdetails);
		walletdao.save(walletuser);
		return "Linked Succesfully!";
	}
	/**********************************************************************************************************************
	 * Method:      transactionaldetail
	 * description:  fetch all the row of transaction detail done by the particular walletuser
	 * @return 		the list of the transaction details
	 * created by	Goldi D Singh
	 * created date 28-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public List transactionaldetail(int walletid) {
		WalletUser walletuser =new WalletUser();
		walletuser=getwalletdetailsbyid(walletid);
		
		List<TransactionDetails>transactiondetails = new ArrayList<>();
		transactiondetails=walletuser.getTransId();
		return transactiondetails;
		
	}
	/**********************************************************************************************************************
	 * Method:       	gettransactiondetailbytransactionId
	 * description:  	fetch the particular row of Transaction detail of which transactionId is provided
	 * @return 			Transaction detail of particular transactionId 
	 * created by 	 	Goldi D Singh
	 * created date		28-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public TransactionDetails gettransactiondetailbytransactionId(int transactionid) {
		TransactionDetails transactiondetail=transactiondetaildao.findById(transactionid).orElse(null);
		return transactiondetail;
	}
	/**********************************************************************************************************************
	 * Method:       checkenteredAmount
	 * description:  Confirms weather the amount entered by the user is 0 or not
	 * @return 		 the verified amount
	 * @throws		 AddmoneyServiceException- if amount entered by the user is 0
	 * created by 	 Goldi D Singh
	 * created date  28-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public String checkenteredAmount(double enteredamount)throws AddmoneyServiceException{
		if(enteredamount<=0)
			throw new AddmoneyServiceException("Amount Entered must be greater than 0");
		else
		{ 
			return Double.toString(enteredamount);
		}
	}

	/**********************************************************************************************************************
	 * Method:       checkbankislinked
	 * description:  Confirms wheather the walletId is linked with the bank account or not
	 * @return 		 the information about whether the wallet is is linked or not
	 * @throws		 AddmoneyServiceException- if walletId is not present in the table and also when account is not linked with the bank account
	 * created by	 Goldi D Singh
	 * created date  28-April-2020
	 * **********************************************************************************************************************
	 * */
	@Override
	public String Checkbankislinked(int walletid) throws AddmoneyServiceException {
		WalletUser walletuser =new WalletUser();
		walletuser= walletdao.findById(walletid).orElseThrow(()->new AddmoneyServiceException("Id Not Found"));
		if(walletuser.getBank()!=null)
			return "already Linked";
		else
			throw new AddmoneyServiceException("Link your bank account");
		
	}
/**********************************************************************************************************************
 * Method:       getbankdetailbyId
 * description:  fetch the particular row of bank detail of which Account number is provided
 * @return 		 Bank detail of particular account number
 * @throws		 AddmoneyServiceException- it is raised if the particular account number detail is not present in the bank table
 * created by	 Goldi D Singh
 * created date  28-April-2020
 * **********************************************************************************************************************
 * */
	@Override
	public BankAccount getbankdetailbyId(String accountno) throws AddmoneyServiceException {
		BankAccount bankuser =new BankAccount();
		bankuser= bankdao.findById(accountno).orElseThrow(()->new AddmoneyServiceException("Invalid Account Number"));
		return bankuser;
	}
	
	

}
