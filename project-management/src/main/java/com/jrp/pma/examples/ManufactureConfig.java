package com.jrp.pma.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactureConfig {
	@Bean
	public Car newCar() {
		return new Car(null, null);
	}
}
