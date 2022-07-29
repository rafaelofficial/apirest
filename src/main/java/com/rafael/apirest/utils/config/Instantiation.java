package com.rafael.apirest.utils.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private CarRepository repository;

	@Override
	public void run(String... args) throws Exception {		
		
		repository.deleteAll();
		
		Car uno = new Car(null, "Uno", "Fiat", "3000", 1997);
		Car agile = new Car(null, "Agile", "Chevrolet", "11000", 2010);
		Car golf = new Car(null, "Golf", "Volkswagem", "3000", 2022);

		repository.saveAll(Arrays.asList(uno, agile, golf));
	}
}
