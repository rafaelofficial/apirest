package com.rafael.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.services.CarService;

@RestController
@RequestMapping(value="api/cars")
public class CarController {
	
	@Autowired
	private CarService service;

	@GetMapping
	public ResponseEntity<List<Car>> findAll() {		
		List<Car> list = service.findAll();
		return ResponseEntity.ok(list);
	}	
}
