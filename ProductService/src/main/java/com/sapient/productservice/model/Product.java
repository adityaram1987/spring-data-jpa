package com.sapient.productservice.model;

import java.io.Serializable;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name= "Product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable{
	
	@Id
	@XmlElement
	@Column(name="id")
	private long id;
	@XmlElement
	@Column(name="name")
	private String name;
	@XmlElement
	@Column(name="price")
	private double price;
	public Product() {
		
	}
public Product(int id, String name, double price) {
		this.id=id;
		this.name = name;
		this.price=price;
	}
}
