package com.rafael.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rafael.apirest.model.CarLogging;

public interface CarLoggingRepository extends MongoRepository<CarLogging, String> {

}
