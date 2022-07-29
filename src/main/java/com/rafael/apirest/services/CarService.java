package com.rafael.apirest.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	// consume external API 
	public List<Car> getApiClient() {
		
		var uri = "http://api-test.bhut.com.br:3000/api/cars";
		
		RestTemplate restTemplate = new RestTemplate();
		Car[] listCar = restTemplate.getForEntity(uri, Car[].class).getBody();
		
		return Arrays.asList(listCar);
	}

	public List<Car> findAll() {
		return repository.findAll();
	}
}
