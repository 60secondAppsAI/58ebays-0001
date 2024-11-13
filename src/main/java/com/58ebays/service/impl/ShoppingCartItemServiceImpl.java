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
import com.58ebays.dao.ShoppingCartItemDAO;
import com.58ebays.domain.ShoppingCartItem;
import com.58ebays.dto.ShoppingCartItemDTO;
import com.58ebays.dto.ShoppingCartItemSearchDTO;
import com.58ebays.dto.ShoppingCartItemPageDTO;
import com.58ebays.dto.ShoppingCartItemConvertCriteriaDTO;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import com.58ebays.service.ShoppingCartItemService;
import com.58ebays.util.ControllerUtils;





@Service
public class ShoppingCartItemServiceImpl extends GenericServiceImpl<ShoppingCartItem, Integer> implements ShoppingCartItemService {

    private final static Logger logger = LoggerFactory.getLogger(ShoppingCartItemServiceImpl.class);

	@Autowired
	ShoppingCartItemDAO shoppingCartItemDao;

	


	@Override
	public GenericDAO<ShoppingCartItem, Integer> getDAO() {
		return (GenericDAO<ShoppingCartItem, Integer>) shoppingCartItemDao;
	}
	
	public List<ShoppingCartItem> findAll () {
		List<ShoppingCartItem> shoppingCartItems = shoppingCartItemDao.findAll();
		
		return shoppingCartItems;	
		
	}

	public ResultDTO addShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO, RequestDTO requestDTO) {

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();

		shoppingCartItem.setShoppingCartItemId(shoppingCartItemDTO.getShoppingCartItemId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		shoppingCartItem = shoppingCartItemDao.save(shoppingCartItem);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<ShoppingCartItem> getAllShoppingCartItems(Pageable pageable) {
		return shoppingCartItemDao.findAll(pageable);
	}

	public Page<ShoppingCartItem> getAllShoppingCartItems(Specification<ShoppingCartItem> spec, Pageable pageable) {
		return shoppingCartItemDao.findAll(spec, pageable);
	}

	public ResponseEntity<ShoppingCartItemPageDTO> getShoppingCartItems(ShoppingCartItemSearchDTO shoppingCartItemSearchDTO) {
	
			Integer shoppingCartItemId = shoppingCartItemSearchDTO.getShoppingCartItemId(); 
 			String sortBy = shoppingCartItemSearchDTO.getSortBy();
			String sortOrder = shoppingCartItemSearchDTO.getSortOrder();
			String searchQuery = shoppingCartItemSearchDTO.getSearchQuery();
			Integer page = shoppingCartItemSearchDTO.getPage();
			Integer size = shoppingCartItemSearchDTO.getSize();

	        Specification<ShoppingCartItem> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, shoppingCartItemId, "shoppingCartItemId"); 
			

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

		Page<ShoppingCartItem> shoppingCartItems = this.getAllShoppingCartItems(spec, pageable);
		
		//System.out.println(String.valueOf(shoppingCartItems.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(shoppingCartItems.getTotalPages()));
		
		List<ShoppingCartItem> shoppingCartItemsList = shoppingCartItems.getContent();
		
		ShoppingCartItemConvertCriteriaDTO convertCriteria = new ShoppingCartItemConvertCriteriaDTO();
		List<ShoppingCartItemDTO> shoppingCartItemDTOs = this.convertShoppingCartItemsToShoppingCartItemDTOs(shoppingCartItemsList,convertCriteria);
		
		ShoppingCartItemPageDTO shoppingCartItemPageDTO = new ShoppingCartItemPageDTO();
		shoppingCartItemPageDTO.setShoppingCartItems(shoppingCartItemDTOs);
		shoppingCartItemPageDTO.setTotalElements(shoppingCartItems.getTotalElements());
		return ResponseEntity.ok(shoppingCartItemPageDTO);
	}

	public List<ShoppingCartItemDTO> convertShoppingCartItemsToShoppingCartItemDTOs(List<ShoppingCartItem> shoppingCartItems, ShoppingCartItemConvertCriteriaDTO convertCriteria) {
		
		List<ShoppingCartItemDTO> shoppingCartItemDTOs = new ArrayList<ShoppingCartItemDTO>();
		
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			shoppingCartItemDTOs.add(convertShoppingCartItemToShoppingCartItemDTO(shoppingCartItem,convertCriteria));
		}
		
		return shoppingCartItemDTOs;

	}
	
	public ShoppingCartItemDTO convertShoppingCartItemToShoppingCartItemDTO(ShoppingCartItem shoppingCartItem, ShoppingCartItemConvertCriteriaDTO convertCriteria) {
		
		ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
		
		shoppingCartItemDTO.setShoppingCartItemId(shoppingCartItem.getShoppingCartItemId());

	

		
		return shoppingCartItemDTO;
	}

	public ResultDTO updateShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO, RequestDTO requestDTO) {
		
		ShoppingCartItem shoppingCartItem = shoppingCartItemDao.getById(shoppingCartItemDTO.getShoppingCartItemId());

		shoppingCartItem.setShoppingCartItemId(ControllerUtils.setValue(shoppingCartItem.getShoppingCartItemId(), shoppingCartItemDTO.getShoppingCartItemId()));



        shoppingCartItem = shoppingCartItemDao.save(shoppingCartItem);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public ShoppingCartItemDTO getShoppingCartItemDTOById(Integer shoppingCartItemId) {
	
		ShoppingCartItem shoppingCartItem = shoppingCartItemDao.getById(shoppingCartItemId);
			
		
		ShoppingCartItemConvertCriteriaDTO convertCriteria = new ShoppingCartItemConvertCriteriaDTO();
		return(this.convertShoppingCartItemToShoppingCartItemDTO(shoppingCartItem,convertCriteria));
	}







}
