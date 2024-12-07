package com.klef.jfsd.project.service;

import java.util.List;
import java.util.Optional;

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
	
	 @Override
	  public List<Product> viewallproducts() {
	    return productRepository.findAll();
	  }

	  @Override
	  public String deleteProduct(int pid) {
	    if (productRepository.existsById(pid)) {
	            productRepository.deleteById(pid);
	            return "Product with ID " + pid + " deleted successfully.";
	        } 
	    else 
	    {
	            return "Product with ID " + pid + " not found.";
	        }  
	    }

	    @Override
	      public String updateProduct(int pid, Product updatedProduct) {
	          Optional<Product> existingProductOpt = productRepository.findById(pid);
	          if (existingProductOpt.isPresent()) {
	              Product existingProduct = existingProductOpt.get();

	              // Update product details
	              existingProduct.setPname(updatedProduct.getPname());
	              existingProduct.setPdescription(updatedProduct.getPdescription());
	              existingProduct.setPprice(updatedProduct.getPprice());
	              existingProduct.setPimage(updatedProduct.getPimage());
	              existingProduct.setAid(updatedProduct.getAid());
	              existingProduct.setPrating(updatedProduct.getPrating());

	              productRepository.save(existingProduct);
	              return "Product with ID " + pid + " updated successfully.";
	          } else {
	              return "Product with ID " + pid + " not found.";
	          }
	      }
	    
	

}
