package com.jrp.pma.examples;

import org.springframework.stereotype.Component;


public class Car {
	public Engine engine;
	public Tyre tyre;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(Engine engine, Tyre tyre) {
		super();
		this.engine = engine;
		this.tyre = tyre;
	}
	
	
}
