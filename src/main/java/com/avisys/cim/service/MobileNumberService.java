package com.avisys.cim.service;

import java.util.Optional;

import com.avisys.cim.entities.MobileNumber;

public interface MobileNumberService {

	Optional<MobileNumber> findByMobileNumber(String mobileNumber);

	void deleteByCustomerId(Long Custome_id);
}
