package com.cg.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.BankAccount;
import com.cg.entity.WalletUser;

@Repository
public interface IWalletDao extends CrudRepository< WalletUser, Integer>{
//	public void create(WalletUser s);
//	public List getwalletdetails();
//	public void updateWallet(int walletId,double amount);
}
