package com.58ebays.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.58ebays.dao.GenericDAO;
import com.58ebays.service.GenericService;
import com.58ebays.service.impl.GenericServiceImpl;
import com.58ebays.dao.ShoppingCartDAO;
import com.58ebays.domain.ShoppingCart;
import com.58ebays.dto.ShoppingCartDTO;
import com.58ebays.dto.ShoppingCartSearchDTO;
import com.58ebays.dto.ShoppingCartPageDTO;
import com.58ebays.dto.ShoppingCartConvertCriteriaDTO;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import com.58ebays.service.ShoppingCartService;
import com.58ebays.util.ControllerUtils;





@Service
public class ShoppingCartServiceImpl extends GenericServiceImpl<ShoppingCart, Integer> implements ShoppingCartService {

    private final static Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

	@Autowired
	ShoppingCartDAO shoppingCartDao;

	


	@Override
	public GenericDAO<ShoppingCart, Integer> getDAO() {
		return (GenericDAO<ShoppingCart, Integer>) shoppingCartDao;
	}
	
	public List<ShoppingCart> findAll () {
		List<ShoppingCart> shoppingCarts = shoppingCartDao.findAll();
		
		return shoppingCarts;	
		
	}

	public ResultDTO addShoppingCart(ShoppingCartDTO shoppingCartDTO, RequestDTO requestDTO) {

		ShoppingCart shoppingCart = new ShoppingCart();

		shoppingCart.setShoppingCartId(shoppingCartDTO.getShoppingCartId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		shoppingCart = shoppingCartDao.save(shoppingCart);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<ShoppingCart> getAllShoppingCarts(Pageable pageable) {
		return shoppingCartDao.findAll(pageable);
	}

	public Page<ShoppingCart> getAllShoppingCarts(Specification<ShoppingCart> spec, Pageable pageable) {
		return shoppingCartDao.findAll(spec, pageable);
	}

	public ResponseEntity<ShoppingCartPageDTO> getShoppingCarts(ShoppingCartSearchDTO shoppingCartSearchDTO) {
	
			Integer shoppingCartId = shoppingCartSearchDTO.getShoppingCartId(); 
 			String sortBy = shoppingCartSearchDTO.getSortBy();
			String sortOrder = shoppingCartSearchDTO.getSortOrder();
			String searchQuery = shoppingCartSearchDTO.getSearchQuery();
			Integer page = shoppingCartSearchDTO.getPage();
			Integer size = shoppingCartSearchDTO.getSize();

	        Specification<ShoppingCart> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, shoppingCartId, "shoppingCartId"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<ShoppingCart> shoppingCarts = this.getAllShoppingCarts(spec, pageable);
		
		//System.out.println(String.valueOf(shoppingCarts.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(shoppingCarts.getTotalPages()));
		
		List<ShoppingCart> shoppingCartsList = shoppingCarts.getContent();
		
		ShoppingCartConvertCriteriaDTO convertCriteria = new ShoppingCartConvertCriteriaDTO();
		List<ShoppingCartDTO> shoppingCartDTOs = this.convertShoppingCartsToShoppingCartDTOs(shoppingCartsList,convertCriteria);
		
		ShoppingCartPageDTO shoppingCartPageDTO = new ShoppingCartPageDTO();
		shoppingCartPageDTO.setShoppingCarts(shoppingCartDTOs);
		shoppingCartPageDTO.setTotalElements(shoppingCarts.getTotalElements());
		return ResponseEntity.ok(shoppingCartPageDTO);
	}

	public List<ShoppingCartDTO> convertShoppingCartsToShoppingCartDTOs(List<ShoppingCart> shoppingCarts, ShoppingCartConvertCriteriaDTO convertCriteria) {
		
		List<ShoppingCartDTO> shoppingCartDTOs = new ArrayList<ShoppingCartDTO>();
		
		for (ShoppingCart shoppingCart : shoppingCarts) {
			shoppingCartDTOs.add(convertShoppingCartToShoppingCartDTO(shoppingCart,convertCriteria));
		}
		
		return shoppingCartDTOs;

	}
	
	public ShoppingCartDTO convertShoppingCartToShoppingCartDTO(ShoppingCart shoppingCart, ShoppingCartConvertCriteriaDTO convertCriteria) {
		
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		
		shoppingCartDTO.setShoppingCartId(shoppingCart.getShoppingCartId());

	

		
		return shoppingCartDTO;
	}

	public ResultDTO updateShoppingCart(ShoppingCartDTO shoppingCartDTO, RequestDTO requestDTO) {
		
		ShoppingCart shoppingCart = shoppingCartDao.getById(shoppingCartDTO.getShoppingCartId());

		shoppingCart.setShoppingCartId(ControllerUtils.setValue(shoppingCart.getShoppingCartId(), shoppingCartDTO.getShoppingCartId()));



        shoppingCart = shoppingCartDao.save(shoppingCart);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public ShoppingCartDTO getShoppingCartDTOById(Integer shoppingCartId) {
	
		ShoppingCart shoppingCart = shoppingCartDao.getById(shoppingCartId);
			
		
		ShoppingCartConvertCriteriaDTO convertCriteria = new ShoppingCartConvertCriteriaDTO();
		return(this.convertShoppingCartToShoppingCartDTO(shoppingCart,convertCriteria));
	}







}