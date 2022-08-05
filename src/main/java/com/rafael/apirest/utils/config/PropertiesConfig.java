package com.rafael.apirest.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {

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
