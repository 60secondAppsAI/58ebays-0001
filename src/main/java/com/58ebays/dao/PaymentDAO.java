package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.Payment;





public interface PaymentDAO extends GenericDAO<Payment, Integer> {
  
	List<Payment> findAll();
	






}


