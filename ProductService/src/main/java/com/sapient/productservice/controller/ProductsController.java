package com.sapient.productservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/api/v1/products/")
@EnableSwagger2
//@PropertySource("classpath:documentation.properties")
public class ProductsController {
	@Autowired
	@Qualifier(value = "productService")
	ProductService prodser;
	
	@GetMapping(value = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	@ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
	public List<Product> listAll(){
		List<Product> prodList = new ArrayList<>();
    	prodList = prodser.listAll();
    	for (Product prod : prodList) { 		      
            System.out.println(prod); 		
       }
    	//model.addAttribute("list",empList);
    	return prodList;
	}
	
	@GetMapping(value = "/{id}", produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(IllegalArgumentException.class)
	public Product findById( @PathVariable long id) {
		return prodser.findById(id);
	}
	
	@PostMapping(value="/", consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
	public Product saveProduct(@RequestBody Product product) {
		System.out.println(product);
		return prodser.saveProduct(product);
	}
	
	@PutMapping(value = "/{id}", consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
	public void updateProduct(@PathVariable long id,@RequestBody Product product) {
		System.out.println("Came inside the update method");
		System.out.println(product);
		prodser.updateProduct(id, product);
	}
	
	@DeleteMapping(value= "/{id}")
	public void deleteProduct(@PathVariable long id) {
		System.out.println("Deleted the product successfully");
		prodser.deleteProduct(id);
	}
}
