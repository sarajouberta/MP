package uo.mp.s6.greenhouse.sensors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;
import uo.mp.util.check.ArgumentChecks;


/**
 * <p>Title: Sensor</p>
 * <p>Description: Class that simulates a temperature sensor.</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public class TemperatureSensor extends Sensor {

	public TemperatureSensor(int id) {
		ArgumentChecks.isTrue(id >= 0, "Invalid id");
		this.id = id;
	}

	/**
	 * Simulates a temperature measurement 
	 * 
	 * It returns a value in the range [5, 40)
	 * @return The temperature measured by the sensor.
	 */
	public int getTemperature() {
		return new Random().nextInt(36) + 5;
	}
	
	
	@Override
	public String toString() {
		return "[TemperatureSensor] " + id ;
	}

	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.05;   //simulaci�n 
	}
	
	
	
}
