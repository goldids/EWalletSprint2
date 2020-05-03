package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.BankAccount;

@Transactional
@Repository
public class BankAccountDao {
//
//	@PersistenceContext
//	EntityManager em;
//	@Override
//	public void create(BankAccount s) {
//		
//	
//		
//		em.persist(s);
//	}
//	@Override
//	public List getbankdetails() {
//		Query q=em.createQuery("from BankAccount s");
//		return q.getResultList();
//	}

}
