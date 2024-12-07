package com.klef.jfsd.project.controller;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.model.Product;
import com.klef.jfsd.project.service.ArtisanService;
import com.klef.jfsd.project.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ArtisanService artisanService;
	
	@PostMapping("/insertproduct")
    public ResponseEntity<?> insertProduct(@RequestPart Product productData,@RequestPart MultipartFile file) throws Exception {

		try {
			
			 Artisan artisan = artisanService.getArtisanById(productData.getAid());
		       productData.setArtisan(artisan);
        Product p=productService.AddProduct(productData, file);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	 @GetMapping("/viewallproducts")
	  public ResponseEntity<List<Product>> viewAllArtisans() {
	      List<Product> list = productService.viewallproducts();
	      return ResponseEntity.ok(list); 
	  }
	    
	    @DeleteMapping("/deleteproduct")
	    public ResponseEntity<String> deleteProduct(@RequestParam("id") int pid) {
	        String response = productService.deleteProduct(pid);
	        if (response.contains("deleted successfully")) {
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    }
	    
	    @PutMapping("/updateproduct")
	    public ResponseEntity<String> updateProduct(@RequestParam("id") int pid, @RequestBody Product updatedProduct) {
	        String response = productService.updateProduct(pid, updatedProduct);
	        if (response.contains("updated successfully")) {
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    }
	    
	    
	  @GetMapping("/product/{pid}")
	  public ResponseEntity<byte[]> getImageById(@PathVariable int pid){
		  Product p=productService.getProductById(pid);
		  byte[] image=p.getPimage();	
		  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
		  }

	   



}
