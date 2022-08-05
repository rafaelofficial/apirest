package com.rafael.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.apirest.model.LogCar;
import com.rafael.apirest.repository.LogCarRepository;

@Service
public class LogCarService {

	@Autowired
	private LogCarRepository repository;

	public List<LogCar> findAll(LogCar obj) {
		return repository.findAll();
	}
}
