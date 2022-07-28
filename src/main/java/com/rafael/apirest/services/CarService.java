package com.rafael.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	public List<Car> findAll() {
		return repository.findAll();
	}
}
