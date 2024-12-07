package com.klef.jfsd.project.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cultural_consultant_table")
public class CulturalConsultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultant_id")
    private int ccid;

    @Column(name = "consultant_fname", length = 30, nullable = false)
    private String ccfname;

    @Column(name = "consultant_lname", length = 30, nullable = false)
    private String cclname;

    @Column(name = "consultant_username", length = 30, nullable = false, unique = true)
    private String ccusername;

    @Column(name = "consultant_dob", nullable = false)
    private String ccdob;

    @Column(name = "consultant_gender", length = 10, nullable = false)
    private String ccgender;
    
    @Column(name = "consultant_email",length=30,nullable=false,unique=true)
    private String ccemail;

    @Column(name = "consultant_phonenumber", length = 10, nullable = false, unique = true)
    private String ccphonenumber;

    @Column(name = "consultant_password", length = 30, nullable = false)
    private String ccpassword;

    @Column(name = "consultant_address", length = 100, nullable = false)
    private String ccaddress;

    @Column(name = "consultant_expertise", length = 255, nullable = true)
    private String ccexpertise;

    @Column(name = "consultant_description", length = 255, nullable = true)
    private String ccdescription;

    @Column(name = "consultant_registration_date", nullable = false, updatable = false)
    private Date ccregistrationDate;

    // Default constructor to set registration date
    public CulturalConsultant() {
        this.ccregistrationDate = new Date(System.currentTimeMillis());
    }

	public int getCcid() {
		return ccid;
	}

	public void setCcid(int ccid) {
		this.ccid = ccid;
	}

	public String getCcfname() {
		return ccfname;
	}

	public void setCcfname(String ccfname) {
		this.ccfname = ccfname;
	}

	public String getCclname() {
		return cclname;
	}

	public void setCclname(String cclname) {
		this.cclname = cclname;
	}

	public String getCcusername() {
		return ccusername;
	}

	public void setCcusername(String ccusername) {
		this.ccusername = ccusername;
	}

	public String getCcdob() {
		return ccdob;
	}

	public void setCcdob(String ccdob) {
		this.ccdob = ccdob;
	}

	public String getCcgender() {
		return ccgender;
	}

	public void setCcgender(String ccgender) {
		this.ccgender = ccgender;
	}

	public String getCcemail() {
		return ccemail;
	}

	public void setCcemail(String ccemail) {
		this.ccemail = ccemail;
	}

	public String getCcphonenumber() {
		return ccphonenumber;
	}

	public void setCcphonenumber(String ccphonenumber) {
		this.ccphonenumber = ccphonenumber;
	}

	
	public String getCcpassword() {
		return ccpassword;
	}

	public void setCcpassword(String ccpassword) {
		this.ccpassword = ccpassword;
	}

	public String getCcaddress() {
		return ccaddress;
	}

	public void setCcaddress(String ccaddress) {
		this.ccaddress = ccaddress;
	}

	public String getCcexpertise() {
		return ccexpertise;
	}

	public void setCcexpertise(String ccexpertise) {
		this.ccexpertise = ccexpertise;
	}

	public String getCcdescription() {
		return ccdescription;
	}

	public void setCcdescription(String ccdescription) {
		this.ccdescription = ccdescription;
	}

	public Date getCcregistrationDate() {
		return ccregistrationDate;
	}

	public void setCcregistrationDate(Date ccregistrationDate) {
		this.ccregistrationDate = ccregistrationDate;
	}

	@Override
	public String toString() {
		return "CulturalConsultant [ccid=" + ccid + ", ccfname=" + ccfname + ", cclname=" + cclname + ", ccusername="
				+ ccusername + ", ccdob=" + ccdob + ", ccgender=" + ccgender + ", ccemail=" + ccemail
				+ ", ccphonenumber=" + ccphonenumber + ", ccpassword=" + ccpassword + ", ccaddress=" + ccaddress
				+ ", ccexpertise=" + ccexpertise + ", ccdescription=" + ccdescription + ", ccregistrationDate="
				+ ccregistrationDate + "]";
	}
    

}