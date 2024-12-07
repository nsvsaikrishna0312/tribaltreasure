package com.klef.jfsd.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin {
	@Id
	@Column(name = "admin_username",length= 40,nullable = false,unique = true)
	private String ausername;
	
	@Column(name="admin_password",length=40,nullable = false)
	private String apassword;

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
}
