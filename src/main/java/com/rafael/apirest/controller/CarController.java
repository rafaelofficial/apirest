package com.rafael.apirest.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.apirest.dto.CarDTO;
import com.rafael.apirest.model.Car;
import com.rafael.apirest.services.CarService;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("/listCars")
	public ResponseEntity<List<CarDTO>> findAll() {		
		List<Car> list = service.findAll();
		
		List<CarDTO> listDto = list.stream().map(x -> new CarDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/listCars/{id}")
	public ResponseEntity<CarDTO> findById(@PathVariable String id) {
		return service.findById(id).map(obj -> ResponseEntity.ok().body(new CarDTO(obj)))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/createCar")
	public ResponseEntity<Void> insert(@RequestBody CarDTO objDto) {
		Car obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
