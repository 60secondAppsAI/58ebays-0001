package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.Subscription;





public interface SubscriptionDAO extends GenericDAO<Subscription, Integer> {
  
	List<Subscription> findAll();
	






}


