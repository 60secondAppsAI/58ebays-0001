package com.58ebays.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.58ebays.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.58ebays.domain.Invoice;
import com.58ebays.dto.InvoiceDTO;
import com.58ebays.dto.InvoiceSearchDTO;
import com.58ebays.dto.InvoicePageDTO;
import com.58ebays.service.InvoiceService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

	private final static Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	InvoiceService invoiceService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Invoice> getAll() {

		List<Invoice> invoices = invoiceService.findAll();
		
		return invoices;	
	}

	@GetMapping(value = "/{invoiceId}")
	@ResponseBody
	public InvoiceDTO getInvoice(@PathVariable Integer invoiceId) {
		
		return (invoiceService.getInvoiceDTOById(invoiceId));
	}

 	@RequestMapping(value = "/addInvoice", method = RequestMethod.POST)
	public ResponseEntity<?> addInvoice(@RequestBody InvoiceDTO invoiceDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = invoiceService.addInvoice(invoiceDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/invoices")
	public ResponseEntity<InvoicePageDTO> getInvoices(InvoiceSearchDTO invoiceSearchDTO) {
 
		return invoiceService.getInvoices(invoiceSearchDTO);
	}	

	@RequestMapping(value = "/updateInvoice", method = RequestMethod.POST)
	public ResponseEntity<?> updateInvoice(@RequestBody InvoiceDTO invoiceDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = invoiceService.updateInvoice(invoiceDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
