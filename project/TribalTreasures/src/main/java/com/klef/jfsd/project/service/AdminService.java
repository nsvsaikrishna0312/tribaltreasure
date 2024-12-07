package com.klef.jfsd.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.klef.jfsd.project.model.Admin;
import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.model.Customer;

public interface AdminService {
	public Admin checkadminlogin(String ausername,String apassword);
	public List<Customer> viewallcustomers();
	public List<Artisan> viewallartisans();
	public ResponseEntity<String> deletecustomer(int cid);
	public ResponseEntity<String> deleteartisan(int aaid);
	public String updateartisan(int aaid, Artisan aa);
	public String updatecustomer(int id, Customer c); 

	

}
