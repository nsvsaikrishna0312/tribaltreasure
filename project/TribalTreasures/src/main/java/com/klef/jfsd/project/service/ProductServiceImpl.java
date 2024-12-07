package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Product;
import com.klef.jfsd.project.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String AddProduct(Product product) 
	{
		productRepository.save(product);
		return "Product Added Successfully";
	}
	

}
