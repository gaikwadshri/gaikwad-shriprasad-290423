package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.dto.CustomerDTO;
import com.avisys.cim.entities.Customer;


public interface CustomerService {

	List<Customer> findAll();

	List<Customer> findByFilter(CustomerDTO filter);

}
