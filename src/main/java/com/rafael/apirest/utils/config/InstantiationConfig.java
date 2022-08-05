package com.rafael.apirest.utils.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;
import com.rafael.apirest.services.CarService;

@Configuration
public class InstantiationConfig implements CommandLineRunner {

	@Autowired
	private CarRepository repository;

	@Autowired
	private CarService service;

	@Override
	public void run(String... args) throws Exception {
		// instance of objects
		Car obj = new Car();
		service.getDataApi(obj);

		// save all data of API from database (MongoDB)
		repository.saveAll(service.getDataApi(obj));
	}
}
