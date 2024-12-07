package com.klef.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.project.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where c.cemail=?1 and c.cpassword=?2")
      public Customer checkcustomerlogin(String cemail,String cpassword); 
		
    	  
      
}
