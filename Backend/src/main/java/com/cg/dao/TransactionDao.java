package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.TransactionDetails;

@Transactional
@Repository
public class TransactionDao{

//
//	@PersistenceContext
//	EntityManager em;
//	@Override
//	public void create(TransactionDetails t) {
//		em.persist(t);
//		
//	}

}
