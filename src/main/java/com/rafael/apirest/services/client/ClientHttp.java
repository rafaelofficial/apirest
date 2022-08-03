package com.rafael.apirest.services.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.rafael.apirest.model.Car;

public class ClientHttp {
	
	RestTemplate restTemplate = new RestTemplate();
	
	// consume external API 
	public List<Car> getDataApi(String url) {
		Car[] listCar = restTemplate.getForEntity(url, Car[].class).getBody();
		return Arrays.asList(listCar);
	}
}
