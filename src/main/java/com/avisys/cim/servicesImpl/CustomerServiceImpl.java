package com.avisys.cim.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Override
	public Optional<Customer> findByMobileNumber(String mobileNumber) {

		return customerRepository.findByMobileNumber(mobileNumber);
	}

	@Override
	public ResponseEntity<Object>  save(Customer customer) {

		  String mobileNumber = customer.getMobileNumber();

	        // check mobile Number already present in database or not  
	        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(mobileNumber);
	        if (existingCustomer.isPresent()) {
	            return new ResponseEntity<>("Unable to create Customer. Mobile number already present.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }else {	      
	        customerRepository.save(customer);

	        return new ResponseEntity<>("Customer created successfully.", HttpStatus.OK);	}
	}
}
