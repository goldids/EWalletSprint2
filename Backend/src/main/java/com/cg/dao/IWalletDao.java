package com.cg.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.BankAccount;
import com.cg.entity.WalletUser;

@Repository
public interface IWalletDao extends CrudRepository< WalletUser, Integer>{
}
