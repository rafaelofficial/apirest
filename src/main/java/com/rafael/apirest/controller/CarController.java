package com.rafael.apirest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.apirest.dto.CarDTO;
import com.rafael.apirest.model.Car;
import com.rafael.apirest.services.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("/listCars")
	public ResponseEntity<List<CarDTO>> findAll() {		
		List<Car> list = service.getApiClient();
		
		List<CarDTO> listDto = list.stream().map(x -> new CarDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
