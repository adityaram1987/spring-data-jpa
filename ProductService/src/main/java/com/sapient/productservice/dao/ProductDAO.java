package com.sapient.productservice.dao;

import java.util.List;

import com.sapient.productservice.model.Product;


public interface ProductDAO {
	public Product saveProduct(Product product);

    public List<Product> listAll();

    public Product findById(int id);

    public void deleteProduct(int id);
    public void updateProduct(int id, Product product);
}
