package com.klef.jfsd.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Admin;
import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.repository.AdminRepository;
import com.klef.jfsd.project.repository.ArtisanRepository;
import com.klef.jfsd.project.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ArtisanRepository artisanRepository;

	@Override
	public Admin checkadminlogin(String ausername,String apassword) {
		return adminRepository.checkadminlogin(ausername, apassword);
	}

	@Override
	public List<Customer> viewallcustomers() {
		return customerRepository.findAll();
	}

	@Override
	public List<Artisan> viewallartisans() {
		
		return artisanRepository.findAll();
	}

	@Override
	public ResponseEntity<String> deletecustomer(int cid) {
		Optional<Customer> object=customerRepository.findById(cid);
		String msg=null;
		if(object.isPresent()) {
			Customer c=object.get();
			customerRepository.delete(c);
			msg="Customer Deleted Successfuly";
		}
		else {
			msg="Customer Id not found";
		}
		return ResponseEntity.ok(msg);
	}
	
	@Override
	public ResponseEntity<String> deleteartisan(int aaid) {
		Optional<Artisan> object=artisanRepository.findById(aaid);
		String msg=null;
		if(object.isPresent()) {
			Artisan aa=object.get();
			artisanRepository.delete(aa);
			msg="Artisan Deleted Successfuly";
		}
		else {
			msg="Artisan Id not found";
		}
		return ResponseEntity.ok(msg);
	}

	
	
	@Override
	public String updateartisan(int aaid, Artisan aa) {
		Optional<Artisan> object=artisanRepository.findById(aaid);
		String msg=null;
		
		if(object.isPresent()) {
			
			Artisan artisan=object.get();
			artisan.setAafname(aa.getAafname());
			artisan.setAalname(aa.getAalname());
			artisan.setAaaddress(aa.getAaaddress());
			artisan.setAadob(aa.getAadob());
			artisan.setAaemail(aa.getAaemail());
			artisan.setAagender(aa.getAagender());
			artisan.setAapassword(aa.getAapassword());
			artisan.setAaphonenumber(aa.getAaphonenumber());
			artisan.setAashopName(aa.getAashopName());
			artisan.setAaskills(aa.getAaskills());
			artisan.setAausername(aa.getAausername());


			
			
			artisanRepository.save(artisan);
			
			msg="Artisan updated successfully";

		}
		else {
			msg="Artisan Id not found";
		}
		return msg;
		
		
	}

	@Override
	public String updatecustomer(int id, Customer c) {
		Optional<Customer> object=customerRepository.findById(id);
		String msg=null;
		
		if(object.isPresent()) {
			
			Customer customer=object.get();
			customer.setCfname(c.getCfname());
			customer.setClname(c.getClname());
			customer.setCaddress(c.getCaddress());
			customer.setCdob(c.getCdob());
			customer.setCemail(c.getCemail());
			customer.setCgender(c.getCgender());
			customer.setCpassword(c.getCpassword());
			customer.setCphonenumber(c.getCphonenumber());
			customer.setCusername(c.getCusername());


			
			
			customerRepository.save(customer);
			
			msg="customer updated successfully";

		}
		else {
			msg="customer Id not found";
		}
		return msg;
		
	}
	
	
	
}
