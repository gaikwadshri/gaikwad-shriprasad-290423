package com.avisys.cim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avisys.cim.entities.MobileNumber;

public interface MobileNumberRepository extends JpaRepository<MobileNumber, Long> {

	Optional<MobileNumber> findByMobileNumber(String mobileNumber);

	
	void deleteByCustomerId( Long customer_id);
}
