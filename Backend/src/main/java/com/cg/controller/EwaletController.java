package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.BankAccount;
import com.cg.entity.Debitcard;
import com.cg.entity.TransactionDetails;
import com.cg.entity.WalletUser;
import com.cg.service.IEwalletservice;
import com.cg.userException.AddmoneyServiceException;

@Component
@RestController
@CrossOrigin
@RequestMapping("/Ewallet")
public class EwaletController {
	
	@Autowired
	IEwalletservice service;
	
	@RequestMapping("bank")
	public List getbankdetails()
	{
		return  service.getbankdetails();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/bankdetails")
	public String addbankdetails(@RequestBody BankAccount s)
	{
		
		service.createBankdetails(s);
		return "added";
	}
	
	
	
	

	@RequestMapping("/wallet/{walletid}")
	public WalletUser getwalletdetails(@PathVariable int walletid)
	{
	
		return  service.getwalletdetailsbyid(walletid);
	}
	
	@RequestMapping("/transaction/{transactionid}")
	public TransactionDetails getTransactiondetail(@PathVariable int transactionid)
	{
	
		return  service.gettransactiondetailbytransactionId(transactionid);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/walletdetails")
	public String addwalletdetails(@RequestBody WalletUser w)
	{
		
		service.createwalletdetails(w);
		return "added";
	}
	
	
	
	
	
	
	@RequestMapping("/debitcard")
	public List debitcarddetails()
	{
		return  service.getdebitcarddetails();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/debitcarddetails")
	public String adddebitcarddetails(@RequestBody Debitcard d)
	{
		
		service.createdebitdetails(d);
		return "added";
	}
	
	
	
	
	@RequestMapping(value="/wallet")
	public List wallet()
	{
		return  service.walletdetails();
	}
	
	@RequestMapping(value="/addmoney/{walletid}/{amount}")
	public String addmoneyviabankaccount(@PathVariable int walletid,@PathVariable double amount) throws AddmoneyServiceException
	{
		return  service.addMoneyviabankaccount(walletid, amount);
	}
	@RequestMapping(value="/addmoneydebit/{walletid}/{amount}/{cardno}/{cvv}/{expirymonth}/{expiryyear}")
	public String addmoneyviadebitcard(@PathVariable int walletid,@PathVariable double amount,@PathVariable String cardno, @PathVariable int cvv, @PathVariable int expirymonth,@PathVariable int expiryyear)throws AddmoneyServiceException
	{
		return  service.addMoneyviadebitcard(walletid,amount, cardno,cvv,expirymonth,expiryyear);
	}
	@RequestMapping(value="/linkbankaccount/{walletid}/{accountno}")
	public String linkbankaccount(@PathVariable int walletid,@PathVariable String accountno)
	{
		return  service.linkbankaccount(walletid, accountno);
	}
	@RequestMapping(value="/transactiondetails/{walletid}")
	public List gettransactiondetails(@PathVariable int walletid)
	{
		return  service.transactionaldetail(walletid);
	}
	@RequestMapping(value="/amount/{amount}")
	public String checkenteredamount(@PathVariable double amount) throws AddmoneyServiceException
	{
		return  service.checkenteredAmount(amount);
	}
	}
