package com.sapient.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductDAO;
import com.sapient.productservice.model.Product;
import com.sapient.productservice.repository.ProductRepository;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	//@Qualifier(value = "prodRepository")
	private ProductDAO productDAO;

	@Autowired
	private ProductRepository productRepository;
	
    public ProductServiceImpl(@Qualifier(value = "prodRepository")ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    @Transactional
	@Override
	public Product saveProduct(Product product) {
		System.out.println("Inside the save employee method of Product service class ....");
        return productRepository.save(product);
		
	}

	@Transactional
	@Override
	public List<Product> listAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Transactional
	@Override
	public Product findById(long id) {
		Optional<Product> optionalProduct = productRepository.findById((long) id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		throw new IllegalArgumentException("Product not found");
	}
	@Transactional
	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);		
	}
	@Transactional
	@Override
	public void updateProduct(long id, Product product) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		System.out.println(product);
		if(optionalProduct.isPresent()) {
			Product currentProduct = optionalProduct.get();
			currentProduct.setName(product.getName());
			currentProduct.setPrice(product.getPrice());
			productRepository.save(currentProduct);
		}
		throw new IllegalArgumentException("Product not found");
	}

}
