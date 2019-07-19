package com.sapient.productservice.dao;

import java.util.ArrayList;
import java.util.List;

import com.sapient.productservice.model.Product;


public class ProductDAOImpl implements ProductDAO{

	private static List<Product> products = new ArrayList<Product>();
	public Product saveProduct(Product product) {
		products.add(product);
		return product;
	}

	public List<Product> listAll() {
		System.out.println("Inside the list all method of ProductDAO");
		return null;
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		
	}

}
