package com.rafael.apirest.dto;

import java.io.Serializable;
import java.util.Optional;

import com.rafael.apirest.model.Car;

public class CarDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String brand;
	private String price;
	private Integer age;
	
	public CarDTO() {
	}
	
	public CarDTO(Car obj) {
		id = obj.getId();
		title = obj.getTitle();
		brand = obj.getBrand();
		price = obj.getPrice();
		age = obj.getAge();
	}
	
	public CarDTO(Optional<Car> obj) {
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
}
