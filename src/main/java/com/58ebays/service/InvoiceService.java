package com.58ebays.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.58ebays.domain.Invoice;
import com.58ebays.dto.InvoiceDTO;
import com.58ebays.dto.InvoiceSearchDTO;
import com.58ebays.dto.InvoicePageDTO;
import com.58ebays.dto.InvoiceConvertCriteriaDTO;
import com.58ebays.service.GenericService;
import com.58ebays.dto.common.RequestDTO;
import com.58ebays.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface InvoiceService extends GenericService<Invoice, Integer> {

	List<Invoice> findAll();

	ResultDTO addInvoice(InvoiceDTO invoiceDTO, RequestDTO requestDTO);

	ResultDTO updateInvoice(InvoiceDTO invoiceDTO, RequestDTO requestDTO);

    Page<Invoice> getAllInvoices(Pageable pageable);

    Page<Invoice> getAllInvoices(Specification<Invoice> spec, Pageable pageable);

	ResponseEntity<InvoicePageDTO> getInvoices(InvoiceSearchDTO invoiceSearchDTO);
	
	List<InvoiceDTO> convertInvoicesToInvoiceDTOs(List<Invoice> invoices, InvoiceConvertCriteriaDTO convertCriteria);

	InvoiceDTO getInvoiceDTOById(Integer invoiceId);







}





