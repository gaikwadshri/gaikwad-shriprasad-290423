package com.avisys.cim.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.avisys.cim.dto.CustomerDTO;
import com.avisys.cim.entities.Customer;
import com.avisys.cim.entities.MobileNumber;
import com.avisys.cim.repository.CustomerRepository;
import com.avisys.cim.repository.MobileNumberRepository;
import com.avisys.cim.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MobileNumberRepository mobileNumberRepository;

	@Override
	public List<Customer> findAll() {

		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByFilter(CustomerDTO filter) {

		return customerRepository.findByFilter(filter.getFirstName(), filter.getLastName(), filter.getMobileNumber());
	}

	@Override
	public ResponseEntity<Object> save(Customer customer) {

		List<MobileNumber> mobileNumbers = customer.getMobileNumbers();

		// check mobile Number already present in database or not

		for (MobileNumber mobileNumber : mobileNumbers) {
			Optional<MobileNumber> existingCustomer = mobileNumberRepository
					.findByMobileNumber(mobileNumber.getMobileNumber());
			if (existingCustomer.isPresent()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Unable to create customer. Mobile number already present.");
			}
		}
		customerRepository.save(customer);

		return new ResponseEntity<>("Customer created successfully.", HttpStatus.OK);
	}
}
