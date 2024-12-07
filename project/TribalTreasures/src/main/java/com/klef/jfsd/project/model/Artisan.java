package com.klef.jfsd.project.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artisan_table")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artisan_id")
    private int aaid;

    @Column(name = "artisan_fname", length = 30, nullable = false)
    private String aafname;

    @Column(name = "artisan_lname", length = 30, nullable = false)
    private String aalname;

    @Column(name = "artisan_username", length = 30, nullable = false, unique = true)
    private String aausername;

    @Column(name = "artisan_dob", nullable = false)
    private String aadob;

    @Column(name = "artisan_gender", length = 10, nullable = false)
    private String aagender;
    
    @Column(name = "artisan_email",length=30,nullable=false,unique=true)
    private String aaemail;

    @Column(name = "artisan_phonenumber", length = 10, nullable = false, unique = true)
    private String aaphonenumber;

    @Column(name = "artisan_password", length = 30, nullable = false)
    private String aapassword;

    @Column(name = "artisan_address", length = 100, nullable = false)
    private String aaaddress;

    @Column(name = "artisan_skills", length = 255, nullable = true)
    private String aaskills;

    @Column(name = "artisan_shop_name", length = 50, nullable = true)
    private String aashopname;

    @Column(name = "artisan_registration_date", nullable = false, updatable = false)
    private Date aaregistrationDate;
    

    public Artisan() {
        this.aaregistrationDate = new Date(System.currentTimeMillis());
    }

	public int getAaid() {
		return aaid;
	}

	public void setAaid(int aaid) {
		this.aaid = aaid;
	}

	public String getAafname() {
		return aafname;
	}

	public void setAafname(String aafname) {
		this.aafname = aafname;
	}

	public String getAalname() {
		return aalname;
	}

	public void setAalname(String aalname) {
		this.aalname = aalname;
	}

	public String getAausername() {
		return aausername;
	}

	public void setAausername(String aausername) {
		this.aausername = aausername;
	}

	public String getAadob() {
		return aadob;
	}

	public void setAadob(String aadob) {
		this.aadob = aadob;
	}

	public String getAagender() {
		return aagender;
	}

	public void setAagender(String aagender) {
		this.aagender = aagender;
	}

	public String getAaemail() {
		return aaemail;
	}

	public void setAaemail(String aemail) {
		this.aaemail = aemail;
	}

	public String getAaphonenumber() {
		return aaphonenumber;
	}

	public void setAaphonenumber(String aphonenumber) {
		this.aaphonenumber = aphonenumber;
	}

	public String getAapassword() {
		return aapassword;
	}

	public void setAapassword(String aapassword) {
		this.aapassword = aapassword;
	}

	public String getAaaddress() {
		return aaaddress;
	}

	public void setAaaddress(String aaaddress) {
		this.aaaddress = aaaddress;
	}

	public String getAaskills() {
		return aaskills;
	}

	public void setAaskills(String aaskills) {
		this.aaskills = aaskills;
	}

	public String getAashopName() {
		return aashopname;
	}

	public void setAashopName(String aashopName) {
		this.aashopname = aashopName;
	}

	public Date getAaregistrationDate() {
		return aaregistrationDate;
	}

	public void setAaregistrationDate(Date aaregistrationDate) {
		this.aaregistrationDate = aaregistrationDate;
	}

	@Override
	public String toString() {
		return "Artisan [aaid=" + aaid + ", aafname=" + aafname + ", aalname=" + aalname + ", aausername=" + aausername
				+ ", aadob=" + aadob + ", aagender=" + aagender + ", aemail=" + aaemail + ", aphonenumber="
				+ aaphonenumber + ", aapassword=" + aapassword + ", aaaddress=" + aaaddress + ", aaskills=" + aaskills
				+ ", aashopName=" + aashopname + ", aaregistrationDate=" + aaregistrationDate + "]";
	}



  
}
