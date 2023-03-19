package uo.mp.s6.greenhouse.sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;
import uo.mp.util.check.ArgumentChecks;

public class HumiditySensor extends Sensor {


	public HumiditySensor(int id) {
		ArgumentChecks.isTrue(id >= 0, "Invalid id");
		this.id = id;
		
	}
	
	/**
	 * Simulates a humidity measurement 
	 * 
	 * It returns a value in the range [0, 100]
	 * @return The humidity measured by the sensor.
	 */
	public int getHumidity() {
		return new Random().nextInt(101);
	}



	
	@Override
	public String toString() {
		return "[HumiditySensor] " +  id;
	}
	
	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.05;   //simulaci�n 
	}

}
