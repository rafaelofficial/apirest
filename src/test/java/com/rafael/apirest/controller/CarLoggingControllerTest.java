package com.rafael.apirest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rafael.apirest.model.CarLogging;
import com.rafael.apirest.repository.CarLoggingRepository;

@SpringBootTest
public class CarLoggingControllerTest {

	@Autowired
	private CarLoggingRepository carLoggingRepository;

	@Test
	void whenGetAllLoggingOfCars_thenOK() {
		var carLogging = new CarLogging();
		carLogging.setId("1234567890abc");
		carLogging.setCarId("abc0987654321");
		carLogging.setDataHora("2022-08-04 15:47:00");
		carLoggingRepository.save(carLogging);
	}

}
