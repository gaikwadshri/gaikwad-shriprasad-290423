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

	// Give method use to find the data in database as per request given by client

	@Override
	public List<Customer> findByFilter(CustomerDTO filter) {

		return customerRepository.findByFilter(filter.getFirstName(), filter.getLastName(), filter.getMobileNumber());
	}

	// Method uses to save the customer into data base if mobile number not present
	// in database and provided validation check for mobile no length

	@Override
	public ResponseEntity<Object> save(Customer customer) {

		List<MobileNumber> mobileNumbers = customer.getMobileNumbers();

		// check for mobile Number already present in database or not

		for (MobileNumber mobileNumber : mobileNumbers) {
			Optional<MobileNumber> existingCustomer = mobileNumberRepository
					.findByMobileNumber(mobileNumber.getMobileNumber());
			if (existingCustomer.isPresent()) {
				return new ResponseEntity<>("Unable to create customer. Mobile number already present.",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		for (MobileNumber obj : customer.getMobileNumbers()) {
			if (obj.getMobileNumber().length() > 10) {
				return new ResponseEntity<>("Unable to create customer. Mobile number is to long .",
						HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
		customerRepository.save(customer);

		return new ResponseEntity<>("Customer created successfully.", HttpStatus.OK);
	}

	// Method give privilege to remove the customer from database

	@Override
	public ResponseEntity<Object> removeCustomer(String mobileNumber) {
		Optional<MobileNumber> existingCustomer = mobileNumberRepository.findByMobileNumber(mobileNumber);
		if (!existingCustomer.isPresent()) {
			return new ResponseEntity<>("Unable to delete customer. Mobile number is not avilable.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			MobileNumber mobileNumberData = existingCustomer.get();
			Long customerId = mobileNumberData.getCustomer().getId();
			mobileNumberRepository.deleteByCustomerId(customerId);
			customerRepository.deleteById(customerId);
			return new ResponseEntity<>("Customer removed successfully.", HttpStatus.OK);
		}
	}

	// This Method used to add new Mobile Number To existing customer with all check
	// of new mobile number
	@Override
	public ResponseEntity<Object> addMobileNumber(String mobileNumber, String newMobileNumber) {
		Optional<MobileNumber> existingCustomer = mobileNumberRepository.findByMobileNumber(mobileNumber);
		if (!(existingCustomer.isPresent())) {
			return new ResponseEntity<>("Unable to add to customer Mobile Number . Mobile number is not registered.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Optional<MobileNumber> newMobileNumberCheck = mobileNumberRepository.findByMobileNumber(newMobileNumber);
		if (newMobileNumberCheck.isPresent()) {
			return new ResponseEntity<>(
					"Unable to add new Mobile Number . New mobile number is register with other customer.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Customer customerData = existingCustomer.get().getCustomer();
		List<MobileNumber> mobileNumberList = customerData.getMobileNumbers();
		MobileNumber newobjMobileNumber = new MobileNumber();
		newobjMobileNumber.setMobileNumber(newMobileNumber);
		mobileNumberList.add(newobjMobileNumber);
		customerData.setMobileNumbers(mobileNumberList);
		customerRepository.save(customerData);
		return new ResponseEntity<>("Mobile Number added successfully", HttpStatus.OK);
	}

	// This method remove the mobile number of a customer if customer exists
	@Override
	public ResponseEntity<Object> deleteCustomerMobileNumber(String mobileNumber) {
		Optional<MobileNumber> existingCustomer = mobileNumberRepository.findByMobileNumber(mobileNumber);
		if (!(existingCustomer.isPresent())) {
			return new ResponseEntity<>("Unable to remove customer Mobile Number . Mobile number is not registered.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Customer customerData = existingCustomer.get().getCustomer();
		List<MobileNumber> mobileNumberList = customerData.getMobileNumbers();

		if (mobileNumberList.size() == 1) {
			return new ResponseEntity<>(
					"Unable to remove customer Mobile Number . Customer have only one mobile number register.For this mobile number only customer remove allow",
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (MobileNumber obj : mobileNumberList) {
				if (obj.getMobileNumber().equals(mobileNumber)) {
					mobileNumberList.remove(obj);
					break;
				}
			}
			customerData.setMobileNumbers(mobileNumberList);
			customerRepository.save(customerData);
			mobileNumberRepository.deleteById(existingCustomer.get().getMobile_No_id());

			return new ResponseEntity<>("Mobile Number removed successfully", HttpStatus.OK);
		}
	}
	
	// This Method used to update the mobile number with there old mobile number if the customer exists
		@Override
		public ResponseEntity<Object> updateMobileNumber(String mobileNumber, String newMobileNumber) {

			Optional<MobileNumber> existingCustomer = mobileNumberRepository.findByMobileNumber(mobileNumber);

			if (!existingCustomer.isPresent()) {
				return new ResponseEntity<>("Unable to update Mobile Number . Mobile number is not registered.",
						HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				MobileNumber mobileNumberData = existingCustomer.get();
				mobileNumberData.setMobileNumber(newMobileNumber);
				mobileNumberRepository.save(mobileNumberData);
				return new ResponseEntity<>("Mobile Number Updated successfully", HttpStatus.OK);
			}
		}
}
