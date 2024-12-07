package com.klef.jfsd.project.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int pid;

    @Column(name = "product_name", length = 100, nullable = false)
    private String pname;

    @Column(name = "product_description", length = 255, nullable = false)
    private String pdescription;

    @Column(name = "product_price", nullable = false)
    private BigDecimal pprice;

    @Lob
    @Basic(fetch = FetchType.LAZY) // Lazy loading for performance
    @Column(name = "product_image", columnDefinition = "LONGBLOB") // Specify column type
    private byte[] pimage;
    @ManyToOne
    @JoinColumn(name = "artisan_id", nullable = false)
    private Artisan artisan;
    
    
    private int aid; 
    
    @Column(name="image_type",nullable=false)
    private String ImageType;

    public String getImageType() {
		return ImageType;
	}

	public void setImageType(String imageType) {
		ImageType = imageType;
	}

	@Column(name = "rating", precision = 3, scale = 2)
    private BigDecimal prating;
    
    @Column(name = "product_category", length = 50, nullable = false)
    private String pcategory;
    

    @Column(name = "product_add_date", nullable = false, updatable = false)
    private Date padddate;
    
    @Column(name = "is_active", nullable = false)
    private boolean pisActive;

    public Product() {
        this.padddate = new Date(System.currentTimeMillis());

    }

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public BigDecimal getPprice() {
		return pprice;
	}

	public void setPprice(BigDecimal pprice2) {
		this.pprice = pprice2;
	}

	public byte[] getPimage() {
		return pimage;
	}

	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}

	public int getAid() {
		return aid;
	}

	public void setAid( int aid) {
		this.aid = aid;
	}

	public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

	public BigDecimal getPrating() {
		return prating;
	}

	public void setPrating(BigDecimal prating) {
		this.prating = prating;
	}

	public String getPcategory() {
		return pcategory;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	public Date getPadddate() {
		return padddate;
	}

	public void setPadddate(Date padddate) {
		this.padddate = padddate;
	}

	public boolean isPisActive() {
		return pisActive;
	}

	public void setPisActive(boolean pisActive) {
		this.pisActive = pisActive;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdescription=" + pdescription + ", pprice=" + pprice
				+ ", pimage=" + pimage + ", aid=" + aid + ", prating=" + prating + ", pcategory=" + pcategory
				+ ", padddate=" + padddate + ", pisActive=" + pisActive + "]";
	}

    
}