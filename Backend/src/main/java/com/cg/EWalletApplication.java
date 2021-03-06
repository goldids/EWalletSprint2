package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.IBankAccountDao;
import com.cg.dao.IDebitcardDao;
import com.cg.dao.IWalletDao;
import com.cg.entity.BankAccount;
import com.cg.entity.Debitcard;
import com.cg.entity.WalletUser;

@SpringBootApplication
public class EWalletApplication implements CommandLineRunner{

	@Autowired
	IDebitcardDao dao;
	public static void main(String[] args){
		SpringApplication.run(EWalletApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
				
		
		BankAccount bank=new BankAccount();
		bank.setAccountNo("1002018781");
//		Debitcard d =new Debitcard();
//		
//		d.setCvv(37);
//		d.setDebitid("2222111188881121");
//		d.setExpiremonth(2);
//		d.setExpireyear(2026);
//		d.setBanks(bank);
//		
//Debitcard d1 =new Debitcard();
//		
//BankAccount bank1=new BankAccount();
//bank1.setAccountNo("10001872181");
//		d1.setCvv(355);
//		d1.setDebitid("1112223334445551");
//		d1.setExpiremonth(8);
//		d1.setExpireyear(2020);
//		d1.setBanks(bank1);
//		
//		
//		dao.save(d); dao.save(d1); 
//		//bank.getDebit().add(d);
//		
//		Debitcard d2 =new Debitcard();
//		BankAccount bank2=new BankAccount();
//		bank2.setAccountNo("10004018251");
//				d2.setCvv(387);
//				d2.setDebitid("12110121012111212");
//				d2.setExpiremonth(8);
//				d2.setExpireyear(2023);
//				d2.setBanks(bank2);
//				
//				
//				 dao.save(d2);
	
		
				
	}

}
