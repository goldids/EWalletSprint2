package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.BankAccount;
import com.cg.entity.Debitcard;

@Transactional
@Repository
public class DebitcardDao {

//	@PersistenceContext
//	EntityManager em;
//	@Override
//	public void create(Debitcard s) {
//		em.persist(s);
//		
//	}
//	@Override
//	public List getdebitcarddetails() {
//		Query q=em.createQuery("from Debitcard d");
//		return q.getResultList();
//	}

}
