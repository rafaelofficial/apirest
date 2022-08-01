package com.rafael.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.apirest.dto.CarDTO;
import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public List<Car> findAll() {
		return repository.findAll();
	}
	
	public Car insert(Car obj) {
		return repository.insert(obj);
	}
	
	// get from CarDTO and instance in Car
	public Car fromDTO(CarDTO objDto) {
		return new Car(objDto.getId(), objDto.getTitle(), objDto.getBrand(), objDto.getPrice(), objDto.getAge());
	}
}
