package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.Watchlist;
import com.58ebays.dto.WatchlistDTO;
import com.58ebays.dto.WatchlistSearchDTO;
import com.58ebays.dto.WatchlistPageDTO;
import com.58ebays.dto.WatchlistConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface WatchlistService extends GenericService<Watchlist, Integer> {

	List<Watchlist> findAll();

	ResultDTO addWatchlist(WatchlistDTO watchlistDTO, RequestDTO requestDTO);

	ResultDTO updateWatchlist(WatchlistDTO watchlistDTO, RequestDTO requestDTO);

    Page<Watchlist> getAllWatchlists(Pageable pageable);

    Page<Watchlist> getAllWatchlists(Specification<Watchlist> spec, Pageable pageable);

	ResponseEntity<WatchlistPageDTO> getWatchlists(WatchlistSearchDTO watchlistSearchDTO);
	
	List<WatchlistDTO> convertWatchlistsToWatchlistDTOs(List<Watchlist> watchlists, WatchlistConvertCriteriaDTO convertCriteria);

	WatchlistDTO getWatchlistDTOById(Integer watchlistId);







}





