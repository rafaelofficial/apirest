package com.rafael.apirest.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="cars")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("_id")
	@Id
	private String id;
	private String title;
	private String brand;
	private String price;
	private Integer age;
	
	public Car() {
	}

	public Car(String id, String title, String brand, String price, Integer age) {
		super();
		this.id = id;
		this.title = title;
		this.brand = brand;
		this.price = price;
		this.age = age;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", title=" + title + ", brand=" + brand + ", price=" + price + ", age=" + age + "]";
	}
}
