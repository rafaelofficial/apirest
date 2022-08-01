package com.rafael.apirest.services.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.rafael.apirest.model.Car;

public class ClientHttp {
	
	// consume external API 
	public List<Car> getData(String url) {
		
		RestTemplate restTemplate = new RestTemplate();
		Car[] listCar = restTemplate.getForEntity(url, Car[].class).getBody();
		
		return Arrays.asList(listCar);
	}
}
