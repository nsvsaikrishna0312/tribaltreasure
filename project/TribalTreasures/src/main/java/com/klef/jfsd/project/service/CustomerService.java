package com.klef.jfsd.project.service;

import org.springframework.http.ResponseEntity;

import com.klef.jfsd.project.model.Customer;

public interface CustomerService {
	public ResponseEntity<String> customerregistration(Customer c);
	public Customer checkcustomerlogin(String cemail,String cpassword);

}
