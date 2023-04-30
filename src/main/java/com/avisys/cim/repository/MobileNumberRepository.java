package com.avisys.cim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisys.cim.entities.MobileNumber;

public interface MobileNumberRepository extends JpaRepository<MobileNumber, Long> {

	Optional<MobileNumber> findByMobileNumber(String mobileNumber);

	void deleteByCustomerId(Long customer_id);

	void deleteByMobileNumber(String customer_id);

}
