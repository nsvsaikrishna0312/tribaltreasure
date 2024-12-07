package com.klef.jfsd.project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.project.model.Product;

public interface ProductService {
	public Product AddProduct(Product product,MultipartFile file);
	public List<Product> viewallproducts();
	public String deleteProduct(int pid);
	public String updateProduct(int pid,Product updatedProduct);
	public Product ViewProductByID(int pid) ;
	public Product getProductById(int pid);
	
}
