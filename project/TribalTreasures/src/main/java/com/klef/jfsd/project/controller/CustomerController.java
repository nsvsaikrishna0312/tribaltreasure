package com.klef.jfsd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.service.CustomerService;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/insertcustomer")
	public ResponseEntity<String> insertcustomer(@RequestBody Customer c) {
		
		return customerService.customerregistration(c);

	}
	
	
	@PostMapping("/checkcustomerlogin")
	public ResponseEntity<?> checkcustomerlogin(@RequestBody Customer c) {
		String cemail=c.getCemail();
		String cpassword=c.getCpassword();
		
		
		
		Customer customer=customerService.checkcustomerlogin(cemail, cpassword);
		
		if(customer!=null) {
			
			return ResponseEntity.ok(customer);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
			
		}
		
	}
	
	
}
