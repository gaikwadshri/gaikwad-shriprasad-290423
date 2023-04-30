package com.avisys.cim.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mobile_numbers")
public class MobileNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mobile_no_id")
	private Long mobile_No_id;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@JsonIgnore
	@ManyToOne
	
	private Customer customer;

	public Long getMobile_No_id() {
		return mobile_No_id;
	}

	public void setMobile_No_id(Long mobile_No_id) {
		this.mobile_No_id = mobile_No_id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
}