package com.rafael.apirest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.rafael.apirest.utils.exceptions.PropertiesException;

public class LoadProperties {

	// get file of configuration
	public static Properties getProps() {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/application.properties");
            properties.load(file);
        } catch (IOException e) {
        	throw new PropertiesException("Not found file " + e.getMessage());
        }
        return properties;
    }
}
