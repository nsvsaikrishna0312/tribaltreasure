package com.klef.jfsd.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.project.model.Admin;
import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.service.AdminService;
import com.klef.jfsd.project.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
    
   
	@GetMapping("/viewallcustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() {
	    List<Customer> list = adminService.viewallcustomers();
	    return ResponseEntity.ok(list); 
	}
	
	@GetMapping("/viewallartisans")
	public ResponseEntity<List<Artisan>> viewAllArtisans() {
	    List<Artisan> list = adminService.viewallartisans();
	    return ResponseEntity.ok(list); 
	}
	
	@DeleteMapping("/deletecustomer")
	public ResponseEntity<String> deletecustomer(@RequestParam("id")  int cid) {
		
	   return adminService.deletecustomer(cid); 
	}
	
	@DeleteMapping("/deleteartisan")
	public ResponseEntity<String> deleteartisan(@RequestParam("id")  int aaid) {
		
	   return adminService.deleteartisan(aaid); 
	}

    
    @PostMapping("checkadminlogin")
    public ResponseEntity<String> checkadminlogin(HttpServletRequest request) {
    	String ausername=request.getParameter("ausername");
    	String apassword=request.getParameter("apassword");
    	
    	Admin a=adminService.checkadminlogin(ausername, apassword);
    	if(a!=null) {
			return ResponseEntity.ok("Login Successful");
		}
		else {
			return ResponseEntity.ok("Login Unsuccessful");
			
		}
		
    }
    
    @PutMapping("/updateartisan")
    public ResponseEntity<String> updateartisan(@RequestParam("aaid") int aid,@RequestBody Artisan aa){
    	
    	String msg=adminService.updateartisan(aid, aa);
    	
    	return ResponseEntity.ok(msg);
    }
    
    @PutMapping("/updatecustomer")
    public ResponseEntity<String> updatecustomer(@RequestParam("cid") int id,@RequestBody Customer c){
    	
    	String msg=adminService.updatecustomer(id, c);
    	
    	return ResponseEntity.ok(msg);
    }
}
