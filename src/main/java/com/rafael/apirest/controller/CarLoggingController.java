package com.rafael.apirest.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.model.CarLogging;
import com.rafael.apirest.repository.CarLoggingRepository;
import com.rafael.apirest.services.CarService;
import com.rafael.apirest.services.CarLoggingService;

@RestController
@RequestMapping("/api")
public class CarLoggingController {

	final Logger logger = Logger.getLogger(CarLoggingController.class);
	String dateAndHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

	@Autowired
	private CarService carService;

	@Autowired
	private CarLoggingService carLoggingService;

	@Autowired
	private CarLoggingRepository carLoggingRepository;

	@GetMapping("/logs")
	public List<CarLogging> logsOfCars(CarLogging obj) {
		
		List<CarLogging> listOfLogs = carLoggingService.findAll(obj);
		// instance new object
		List<Car> list = carService.findAll();

		// create object of log
		for (Car cars : list) {
			obj.setCarId(cars.getId());
			obj.setDataHora(dateAndHour);
			carLoggingRepository.save(obj);
		}
		logger.info("Last car in the queue: " + obj);
		return listOfLogs;
	}
}
