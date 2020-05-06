package com.cg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.TransactionDetails;

@Repository
public interface ITransactionDao extends CrudRepository<TransactionDetails, Integer>{

}
