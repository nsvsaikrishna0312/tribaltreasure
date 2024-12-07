package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> customerregistration(Customer c) {
		customerRepository.save(c);
		return ResponseEntity.ok("Registered successfully");
	}

	@Override
	public Customer checkcustomerlogin(String cemail, String cpassword) {
		
		return customerRepository.checkcustomerlogin(cemail, cpassword);
	}
	

}
