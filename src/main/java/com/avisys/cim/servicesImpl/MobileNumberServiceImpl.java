package com.avisys.cim.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.entities.MobileNumber;
import com.avisys.cim.repository.MobileNumberRepository;
import com.avisys.cim.service.MobileNumberService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MobileNumberServiceImpl implements MobileNumberService {

	@Autowired
	private MobileNumberRepository mobileNumberRepository;

	@Override
	public Optional<MobileNumber> findByMobileNumber(String mobileNumber) {

		return mobileNumberRepository.findByMobileNumber(mobileNumber);
	}
}
