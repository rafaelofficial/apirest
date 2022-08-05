package com.rafael.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.apirest.model.CarLogging;
import com.rafael.apirest.repository.CarLoggingRepository;

@Service
public class CarLoggingService {

	@Autowired
	private CarLoggingRepository repository;

	public List<CarLogging> findAll(CarLogging obj) {
		return repository.findAll();
	}
}
