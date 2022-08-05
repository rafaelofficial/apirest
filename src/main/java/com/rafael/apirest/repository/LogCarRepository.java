package com.rafael.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rafael.apirest.model.LogCar;

public interface LogCarRepository extends MongoRepository<LogCar, String> {

}
