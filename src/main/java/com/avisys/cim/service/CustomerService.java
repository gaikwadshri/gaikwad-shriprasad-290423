package com.avisys.cim.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.avisys.cim.dto.CustomerDTO;
import com.avisys.cim.entities.Customer;

public interface CustomerService {

	List<Customer> findAll();

	List<Customer> findByFilter(CustomerDTO filter);

	ResponseEntity<Object> save(Customer customer);

	ResponseEntity<Object> removeCustomer(String mobileNumber);

	ResponseEntity<Object> addMobileNumber(String mobileNumber, String newMobileNumber);

	ResponseEntity<Object> updateMobileNumber(String mobileNumber, String newMobileNumber);

	ResponseEntity<Object> deleteCustomerMobileNumber(String mobileNumber);

}
