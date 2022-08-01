package com.rafael.apirest.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.apirest.repository.CarRepository;
import com.rafael.apirest.services.client.ClientHttp;

@Configuration
public class InstantiationConfig implements CommandLineRunner {
	
	@Autowired
	private CarRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		// make a connection HTTP and get the API
		var properties = getProps();
		
		// get URL on application.properties
		var url = properties.getProperty("url");
		var http = new ClientHttp();
		
		// save all data of API from database (MongoDB)
		repository.saveAll(http.getData(url));
	}
	
	// get file of configuration
	public static Properties getProps() {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/application.properties");
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Not found file " + e.getMessage());
        }
        return properties;
    }
}