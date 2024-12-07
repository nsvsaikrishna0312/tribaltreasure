package com.klef.jfsd.project.service;

import java.util.List;

import com.klef.jfsd.project.model.Product;

public interface ProductService {
	public String AddProduct(Product product);
	public List<Product> viewallproducts();
	public String deleteProduct(int pid);
	public String updateProduct(int pid,Product updatedProduct);

}
