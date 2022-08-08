package com.rafael.apirest.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.model.CarLogging;
import com.rafael.apirest.repository.CarLoggingRepository;
import com.rafael.apirest.services.CarLoggingService;
import com.rafael.apirest.services.CarService;

@RestController
@RequestMapping("/api")
public class CarLoggingController {

	String dateAndHour = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime());

	@Autowired
	private CarService carService;

	@Autowired
	private CarLoggingService carLoggingService;

	@Autowired
	private CarLoggingRepository carLoggingRepository;

	@GetMapping("/logs")
	public ResponseEntity<List<CarLogging>> logsOfCars(CarLogging obj) {
		List<CarLogging> listOfLogs = carLoggingService.findAll(obj);
		List<Car> list = carService.findAll();
		// create object of log
		list.forEach(cars -> {
			obj.setCarId(cars.getId());
			obj.setDataHora(dateAndHour);
			carLoggingRepository.save(obj);
		});
		return ResponseEntity.ok().body(listOfLogs);
	}
}
