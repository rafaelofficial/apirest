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
import com.rafael.apirest.model.LogCar;
import com.rafael.apirest.repository.LogCarRepository;
import com.rafael.apirest.services.CarService;
import com.rafael.apirest.services.LogCarService;

@RestController
@RequestMapping("/api")
public class LogCarController {

	final Logger logger = Logger.getLogger(LogCarController.class);
	String dateAndHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

	@Autowired
	private CarService service;

	@Autowired
	private LogCarService logCarService;

	@Autowired
	private LogCarRepository logCarRepository;

	@GetMapping("/logs")
	public List<LogCar> logging(LogCar obj) {
		
		List<LogCar> listOfLogs = logCarService.findAll(obj);
		// instance new object
		List<Car> list = service.findAll();

		// create object of log
		for (Car cars : list) {
			obj.setCarId(cars.getId());
			obj.setDataHora(dateAndHour);
			logCarRepository.save(obj);
		}
		logger.info("Last car in the queue: " + obj);
		return listOfLogs;
	}
}
