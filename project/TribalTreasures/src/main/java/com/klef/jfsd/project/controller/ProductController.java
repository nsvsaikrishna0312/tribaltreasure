package com.klef.jfsd.project.controller;

import java.math.BigDecimal;
import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.model.Product;
import com.klef.jfsd.project.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/insertproduct")
    public ResponseEntity<String> insertProductDemo(HttpServletRequest request,@RequestParam("pimage") MultipartFile file) throws Exception {

        try {
            
            
        	String pname = request.getParameter("pname");
            String pdescription = request.getParameter("pdescription");
            String ppriceStr = request.getParameter("pprice");
            String pcategory = request.getParameter("pcategory");
            String pisActiveStr = request.getParameter("pisActive");
            String pratingStr = request.getParameter("prating");
            String artisanStr=request.getParameter("aid");

            System.out.println(pname);
            System.out.println(pdescription);
            System.out.println(ppriceStr);
            System.out.println(pcategory);
            System.out.println(pisActiveStr);
            System.out.println(pratingStr);

            BigDecimal pprice = new BigDecimal(ppriceStr);
            
            BigDecimal prating = pratingStr != null && !pratingStr.isEmpty() ? new BigDecimal(pratingStr) : null;
            boolean pisActive = Boolean.parseBoolean(pisActiveStr);
            int aaid=Integer.parseInt(artisanStr);
        	

            
        	
            byte[] bytes = file.getBytes();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
            
            
            Artisan aa=new Artisan();
            aa.setAaid(aaid);
            

            Product p=new Product();
            p.setPname(pname);
            p.setPdescription(pdescription);
            p.setPprice(pprice);
            p.setPcategory(pcategory);
            p.setActive(pisActive);
            p.setPrating(prating);
            p.setPimage(blob);
            p.setAid(aa);
            

            String msg = productService.AddProduct(p);

            return ResponseEntity.status(HttpStatus.CREATED).body(msg);
        } catch (Exception e) {
            String errorMsg = "Error while adding product: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
        }
    }

}
