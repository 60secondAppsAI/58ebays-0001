package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.Address;
import com.58ebays.dto.AddressDTO;
import com.58ebays.dto.AddressSearchDTO;
import com.58ebays.dto.AddressPageDTO;
import com.58ebays.dto.AddressConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AddressService extends GenericService<Address, Integer> {

	List<Address> findAll();

	ResultDTO addAddress(AddressDTO addressDTO, RequestDTO requestDTO);

	ResultDTO updateAddress(AddressDTO addressDTO, RequestDTO requestDTO);

    Page<Address> getAllAddresss(Pageable pageable);

    Page<Address> getAllAddresss(Specification<Address> spec, Pageable pageable);

	ResponseEntity<AddressPageDTO> getAddresss(AddressSearchDTO addressSearchDTO);
	
	List<AddressDTO> convertAddresssToAddressDTOs(List<Address> addresss, AddressConvertCriteriaDTO convertCriteria);

	AddressDTO getAddressDTOById(Integer addressId);







}





