package com.rafael.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.apirest.model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

}
