package com.sapient.productservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;


@Repository(value = "productDAO")
public class MySQLProductDAOImpl implements ProductDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public MySQLProductDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public Product saveProduct(Product product) {
		System.out.println("Came inside the save method of MySQLProductDAOImpl");
        jdbcTemplate.execute("insert into products(id,name,price) values ('"+product.getId()+"','"+product.getName()+"','"+product.getPrice()+"')");
        return product;
	}

	public List<Product> listAll() {
		List<Product> productList = jdbcTemplate.query("select * from products",
	               ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3)));
	       return productList;
	}

	public Product findById(int id) {
		return jdbcTemplate.queryForObject("select * from products where id=" + id,
                (rs, rowNum) -> {
                   Product product =  new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3));
                           return product;
                });

	}

	public void deleteProduct(int id) {
		System.out.println("Came inside the delete method of MySQLProductDAOImpl");
        jdbcTemplate.execute("delete from products where id="+ id +";");
        
		
	}

	public void updateProduct(int id, Product product) {
		System.out.println("Came inside the update method of MySQLProductDAOImpl");
        jdbcTemplate.execute("update products set name = '" +product.getName()+"', price= "+product.getPrice()+" where id ="+id +";" );
		System.out.println("update products set name = '" +product.getName()+"', price= "+product.getPrice()+" where id ="+id +";" );
	}

}
