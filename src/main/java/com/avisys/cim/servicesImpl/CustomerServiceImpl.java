package com.avisys.cim.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.dto.CustomerDTO;
import com.avisys.cim.entities.Customer;
import com.avisys.cim.repository.CustomerRepository;
import com.avisys.cim.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByFilter(CustomerDTO filter) {

		 return customerRepository.findByFilter(filter.getFirstName(), filter.getLastName(), filter.getMobileNumber());
	}

}
