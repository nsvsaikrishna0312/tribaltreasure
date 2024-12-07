package com.klef.jfsd.project.model;

import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_table")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int cid;
    
    @Column(name="customer_fname", length=30, nullable=false)
    private String cfname;
    
    @Column(name="customer_lname", length=30, nullable=false)
    private String clname;
    
    @Column(name="customer_username", length=30, nullable=false, unique=true)
    private String cusername;
    
    @Column(name="customer_dob", nullable=false)
    private String cdob;
    
    @Column(name="customer_gender", length=10, nullable=false)
    private String cgender;
    
    @Column(name = "customer_email",length=30,nullable=false,unique=true)
    private String cemail;
    
    @Column(name="customer_phonenumber", length=10, nullable=false, unique=true)
    private String cphonenumber;
    
    @Column(name="customer_password", length=30, nullable=false)
    private String cpassword;
    
    @Column(name="customer_address", length=100, nullable=true) // Initially nullable
    private String caddress;
    
    @Column(name="customer_registration_date", nullable=false, updatable=false)
    private Date cregistrationdate;

    // Constructor to initialize the registration date
    public Customer() {
        this.cregistrationdate = Date.valueOf(LocalDate.now());
    }

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getCusername() {
		return cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public String getCdob() {
		return cdob;
	}

	public void setCdob(String cdob) {
		this.cdob = cdob;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCphonenumber() {
		return cphonenumber;
	}

	public void setCphonenumber(String cphonenumber) {
		this.cphonenumber = cphonenumber;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public Date getCregistrationdate() {
		return cregistrationdate;
	}

	public void setCregistrationdate(Date cregistrationdate) {
		this.cregistrationdate = cregistrationdate;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cfname=" + cfname + ", clname=" + clname + ", cusername=" + cusername
				+ ", cdob=" + cdob + ", cgender=" + cgender + ", cemail=" + cemail + ", cphonenumber=" + cphonenumber
				+ ", cpassword=" + cpassword + ", caddress=" + caddress + ", cregistrationdate=" + cregistrationdate
				+ "]";
	}

}
