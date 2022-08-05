package com.rafael.apirest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;

@SpringBootTest
public class CarControllerTest {

	@Autowired
	private CarRepository carRepository;

	Car car = new Car();

	@Test
	void insert() {
		car.setId("1234568790auskpaa0");
		car.setTitle("Gol");
		car.setBrand("Volkswagem");
		car.setPrice("10000");
		car.setAge(1998);
		carRepository.save(car);
	}

	@Test
	void findAll() {
		List<Car> list = carRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	void findById() {
		car = carRepository.findById("1234568790auskpaa0").get();
		Assertions.assertEquals("1234568790auskpaa0", car.getId());
	}

}
