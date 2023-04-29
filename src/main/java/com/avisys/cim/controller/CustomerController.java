package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.dto.CustomerDTO;
import com.avisys.cim.entities.Customer;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;



	@GetMapping("/getall")
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	@PostMapping("/search")
	public ResponseEntity<List<Customer>> getFilteredCustomers(@RequestBody CustomerDTO filter) {
		List<Customer> customers = null;

		if (filter.isEmpty()) {
			customers = customerService.findAll();
		} else {
			customers = customerService.findByFilter(filter);
		}

		if (customers == null || customers.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(customers);
	}



	@PostMapping("/create")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {

		return customerService.save(customer);
	}

	@DeleteMapping("/remove/{mobileNumber}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("mobileNumber") String mobileNumber){
		
		return customerService.removeCustomer(mobileNumber);
	}
}
