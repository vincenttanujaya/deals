package com.deals.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.deals.api.exception.ResourceNotFoundException;
import com.deals.api.model.Deals;
import com.deals.api.model.DealsRecord;
import com.deals.api.repository.DealsRecordRepository;
import com.deals.api.repository.DealsRepository;
import com.deals.api.services.SecurityService;


@RestController
@RequestMapping("/api")
public class DealsController {
	@Autowired
	DealsRepository dealsRepository;
	@Autowired
	DealsRecordRepository dealsRecordRepository;
	@Autowired
	SecurityService securityService;
	//Order Check Valid
	@GetMapping("/checkdeals")
	public List<Deals> checkValid(@RequestHeader int id_deals,@RequestHeader int id_customer) {
//		String subject = securityService.validate(token);
//		int id_customer = 3;
	    return dealsRepository.checkDeals(id_deals, id_customer);
	}
	//RECORD SECTION
	@GetMapping("/usedeals")
	public List<DealsRecord> getAllRecord() {
//		String subject = securityService.validate(token);
	    return dealsRecordRepository.findAll();
	}
	@PostMapping("/usedeals")
	public DealsRecord addRecordDeals(@RequestBody @Valid DealsRecord deals) {
//		String subject = securityService.validate(token);
//		int id_customer = Integer.parseInt(subject);
		int id_customer = 1;
		deals.setId_customer(id_customer);
	    return dealsRecordRepository.save(deals);
	}
	@DeleteMapping("/usedeals/{id_record_deals}")
	public ResponseEntity<?> deleteRecordDeals(@PathVariable(value = "id_record_deals") Long recordDealsId) {
//		String subject = securityService.validate(token);
	    DealsRecord deals = dealsRecordRepository.findById(recordDealsId)
	            .orElseThrow(() -> new ResourceNotFoundException("Deals", "id_record_deals", recordDealsId));

	    dealsRecordRepository.delete(deals);

	    return ResponseEntity.ok().build();
	}
	
	// DEALS SECTION
	@GetMapping("/deals")
	public List<Deals> getAllDeals() {
//		String subject = securityService.validate(token);
	    return dealsRepository.findAvailableDeals();
	}
	
	@PostMapping("/deals")
	public Deals createDeals(@RequestBody @Valid Deals deals) {
//		return deals;
//		String subject = securityService.validate(token);
	    return dealsRepository.save(deals);
	}
	
	@GetMapping("/deals/{ID_Deals}")
	public Deals getDealsById(@PathVariable(value = "ID_Deals") Long ID_Deals) {
//		String subject = securityService.validate(token);
	    return dealsRepository.findById(ID_Deals)
	            .orElseThrow(() -> new ResourceNotFoundException("Deals", "ID_Deals", ID_Deals));
	}
	
	@PutMapping("/deals/{ID_Deals}")
	public Deals updateDeals(@PathVariable(value = "ID_Deals") Long dealsId,
	                                        @Valid @RequestBody Deals dealsDetails) {
//		String subject = securityService.validate(token);
		Deals deals = dealsRepository.findById(dealsId)
	            .orElseThrow(() -> new ResourceNotFoundException("Deals", "ID_Deals", dealsId));

	    deals.setDeals_name(dealsDetails.getDeals_name());
	    deals.setDeals_description(dealsDetails.getDeals_description());
	    deals.setDeals_max_use(dealsDetails.getDeals_max_use());
	    deals.setDeals_exp(dealsDetails.getDeals_exp());
	    deals.setDeals_start_date(dealsDetails.getDeals_start_date());
	    deals.setDeals_type(dealsDetails.getDeals_type());
	    deals.setDeals_disc_type(dealsDetails.getDeals_disc_type());
	    deals.setDeals_discount(dealsDetails.getDeals_discount());
	    deals.setDeals_max_value(dealsDetails.getDeals_max_value());
	    deals.setDeals_min_payment(dealsDetails.getDeals_min_payment());
	    deals.setDeals_pict(dealsDetails.getDeals_pict());

	    Deals updatedDeals = dealsRepository.save(deals);
	    return updatedDeals;
	}
	
	@DeleteMapping("/deals/{ID_Deals}")
	public ResponseEntity<?> deleteDeals(@PathVariable(value = "ID_Deals") Long dealsId) {
//		String subject = securityService.validate(token);
	    Deals deals = dealsRepository.findById(dealsId)
	            .orElseThrow(() -> new ResourceNotFoundException("Deals", "ID_Deals", dealsId));

	    dealsRepository.delete(deals);

	    return ResponseEntity.ok().build();
	}
}
