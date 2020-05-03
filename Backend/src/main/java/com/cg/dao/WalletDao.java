package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Debitcard;
import com.cg.entity.WalletUser;

@Transactional
@Repository
public class WalletDao {

//	@PersistenceContext
//	EntityManager em;
//	@Override
//	public void create(WalletUser s) {
//		
//		em.persist(s);
//		
//	}
//	@Override
//	public List getwalletdetails() {
//		Query q=em.createQuery("from WalletUser s");
//		return q.getResultList();
//	}
//	@Override
//	public void updateWallet(int walletId, double amount) {
//		WalletUser user;
//		user = em.find(WalletUser.class, walletId);
//		
//		
//	}
//	

}
