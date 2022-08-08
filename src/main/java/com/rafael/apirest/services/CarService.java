package com.rafael.apirest.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rafael.apirest.dto.CarDTO;
import com.rafael.apirest.model.Car;
import com.rafael.apirest.repository.CarRepository;
import com.rafael.apirest.services.exceptions.ControllerNotFoundException;
import com.rafael.apirest.utils.LoadProperties;

@Service
public class CarService {

	// get URL on application.properties
	Properties properties = LoadProperties.getProps();
	String url = properties.getProperty("url");

	// create an instance of RestTemplate
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CarRepository carRepository;

	public List<Car> findAll() {
		return carRepository.findAll();
	}

	public Optional<Car> findById(String id) {
		Optional<Car> obj = carRepository.findById(id);
		return Optional.of(obj.orElseThrow(() -> new ControllerNotFoundException(id)));
	}

	public Car insert(Car obj) {
		return carRepository.insert(obj);
	}

	// get from CarDTO and instance in Car
	public Car fromDTO(CarDTO objDto) {
		return new Car(objDto.getId(), objDto.getTitle(), objDto.getBrand(), objDto.getPrice(), objDto.getAge());
	}

	public List<Car> getfindAllCars(Car obj) {
		Car[] listCar = restTemplate.getForObject(url, Car[].class);
		return Arrays.asList(listCar);
	}

	public Car insertNewCar(Car obj) {
		// create headers
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Car> response = restTemplate.postForEntity(url, obj, Car.class);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return new ResponseEntity<Car>(response.getBody(), headers, HttpStatus.CREATED).getBody();
	}
}
