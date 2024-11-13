package com.58ebays.dao;

import java.util.List;

import com.58ebays.dao.GenericDAO;
import com.58ebays.domain.Auction;





public interface AuctionDAO extends GenericDAO<Auction, Integer> {
  
	List<Auction> findAll();
	






}


