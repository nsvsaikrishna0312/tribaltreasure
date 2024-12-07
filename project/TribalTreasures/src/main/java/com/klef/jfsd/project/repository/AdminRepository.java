package com.klef.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.project.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	@Query("select a from Admin a where a.ausername=?1 and a.apassword=?2")
	public Admin checkadminlogin(String ausername, String apassword);

}
