package com.rafael.apirest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.apirest.model.Car;

@RestController
@RequestMapping(value="/cars")
public class CarController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Car>> findAll() {
		Car corsa = new Car("1", "Corsa", "Chevrolet", "3000", 1999);
		Car gol = new Car("2", "Onix", "Chevrolet", "7000", 2021);
		List<Car> list = new ArrayList<>();
		list.addAll(Arrays.asList(corsa, gol));
		return ResponseEntity.ok(list);
	}
}
