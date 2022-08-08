package com.rafael.apirest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;
import com.rafael.apirest.services.CarService;
import com.rafael.apirest.utils.exceptions.InstantiationException;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarService carService;

	@Override
	public void run(String... args) throws IllegalStateException {
		try {
			// instance of objects
			Car obj = new Car();
			carService.getfindAllCars(obj);
			// save all data of API from database (MongoDB)
			carRepository.saveAll(carService.getfindAllCars(obj));
		} catch (Exception e) {
			throw new InstantiationException("Error, verify your the address from API: " + e.getMessage());
		}

	}
}
