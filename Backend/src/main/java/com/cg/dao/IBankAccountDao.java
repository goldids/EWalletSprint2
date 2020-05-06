package com.cg.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.BankAccount;

@Repository
public interface IBankAccountDao extends CrudRepository<BankAccount, String>{
}
