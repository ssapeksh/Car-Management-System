package com.carApi.Car_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.carApi")
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}

}
//spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect