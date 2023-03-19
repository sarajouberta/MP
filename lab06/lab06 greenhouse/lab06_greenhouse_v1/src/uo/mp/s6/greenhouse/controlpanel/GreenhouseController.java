package uo.mp.s6.greenhouse.controlpanel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import uo.mp.s6.greenhouse.actuators.doors.AutomaticDoor;
import uo.mp.s6.greenhouse.actuators.doors.Door;
import uo.mp.s6.greenhouse.controllers.HumidityController;
import uo.mp.s6.greenhouse.controllers.TemperatureController;
import uo.mp.s6.greenhouse.controllers.devicescanner.DeviceScanner;
import uo.mp.s6.greenhouse.sensors.HumiditySensor;
import uo.mp.s6.greenhouse.sensors.Sensor;
import uo.mp.s6.greenhouse.sensors.TemperatureSensor;

/**
 * <p>Title: GreenHouse</p>
 * <p>Description: Class that simulates a greenhouse.</p>
 * <p>Copyright: Copyright (c) 2022</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class GreenhouseController {
	
	private TemperatureController tempCtrl = new TemperatureController();
	private HumidityController humCtrl = new HumidityController();
	private DeviceScanner scanner = new DeviceScanner();
	
	
	/**
	 * Adds temperature sensors to temperature controller
	 * @param sensor
	 */
	public void add(Sensor sensor) {
		if(sensor instanceof TemperatureSensor)
			tempCtrl.add((TemperatureSensor) sensor);
		else if(sensor instanceof HumiditySensor)
			humCtrl.add((HumiditySensor) sensor);
		scanner.add(sensor);
	}

	
	/**
	 * Adds doors operated by gardener to temperature controller
	 * to simulate gardener operation
	 * @param sensor
	 */
	public void add(Door door) {
		tempCtrl.add(door);
		if(door instanceof AutomaticDoor) {
			AutomaticDoor aDoor = (AutomaticDoor) door;
			scanner.add(aDoor);
		}
	}

	/**
	 * Starts each and every control operation
	 * Displays messages returned by them
	 */
	public void start() {
		while (true) {
			/*
			 * Run temperature controller and diplays messages returned 
			 * to command the gardener
			 */
			display(tempCtrl.monitor());
			display(humCtrl.monitor());
			scanner.scan();
		
			
			sleep(2000);
		}
	}

	private void display(List<String> arg) {
		for (String message: arg) {
			System.out.println(message);
		}		
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore it
		}
	}

}
