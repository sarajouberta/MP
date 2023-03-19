package uo.mp.s6.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.s6.greenhouse.actuators.doors.Door;
import uo.mp.s6.greenhouse.sensors.TemperatureSensor;
import uo.mp.util.check.ArgumentChecks;

/**
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class TemperatureController {
	public static final double MAX_TEMPERATURE = 22;
	public static final double MIN_TEMPERATURE = 19;

	private List<TemperatureSensor> sensors = new ArrayList<>();	
	private List<Door> doors = new ArrayList<>();
		
		
	public void add(TemperatureSensor sensor) {
		ArgumentChecks.isTrue(sensor != null, "Invalid sensor");
		this.sensors.add(sensor);
	}

	public void add(Door door) {
		ArgumentChecks.isTrue(door != null, "Invalid sensor");
		this.doors.add(door);
	}

	/**
	 * Handles the doors to keep the temperature under control between 19 and 22 degrees
	 *
	 * @return A list of messages generated when monitoring
	 */
	public List<String> monitor() {
		/*
		 * Outside is cold, so opening the doors always involves cooling inside.
		 * When getAverageTemperature is greater than maxTemperature 
		 * 	- Some doors should be opened for cooling (if possible)
		 *	- Each degree of difference 
		 *		(getAverageTemperature-maxTemperature) involves opening 10% 
		 *		of the doors (if possible)
		 * 	- Show a message telling how many doors are about to 
		 * 		be opened (if possible)
		 * 
		 * When getAverageTemperature is lower than minTemperature 
		 *	- Some doors should be closed for heating (if possible)
		 *	- Each degree of difference 
		 * 		(minTemperature-getAverageTemperature) involves opening 10% 
		 * 		of the doors (if possible)
		 * - Show a message telling how many doors are about to be 
		 *		closed (if possible)
		 *
		 * Otherwise, a message showing the average temperature is 
		 * 	simply shown on the console
		 */

		/*
		 *  Holds strings to be returned to the control panel to inform the 
		 *  gardener after each and every execution of method monitor()
		 */
		List<String> messages = new ArrayList<String>();	
		
		double averageTemperature = getAverageTemperature();  //obtener temperatura media
		if(averageTemperature > MAX_TEMPERATURE) {
			messages.addAll(coolDown(averageTemperature));
		}else if(averageTemperature < MIN_TEMPERATURE) {
			messages.addAll(warmUp(averageTemperature));
		}else {
			messages.add(doNothing(averageTemperature));
		}
		return messages;
	}
	
	private String doNothing(double temperature) {
		String str =  "The average temperature is " + temperature ;
		return str;
	}
	
	/**
	 * Warms up the greenhouse
	 * @param temp the average temperature calculate
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		to warm up the greenhouse
	 */
	private List<String> warmUp(double temp) {
		List<String> messages = new ArrayList<String>();
		messages.add("Current temp is" + temp + ". It is too low.");
		int doorsToClose = (int)(doors.size() * 0.10 * (temp - MIN_TEMPERATURE));
		messages.add(Math.abs(doorsToClose) + " doors must be closed");
		messages.addAll(openDoors(doorsToClose));
		return messages;
	}
	
	/**
	 * Tries to close doorsToClose doors
	 * @param doorsToClose number of doors to close
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		close as many doors as the argument
	 */
	private List<String> closeDoors(int doorsToClose) {
		List<String> messages = new ArrayList();
		ArgumentChecks.isTrue(doorsToClose > 0 && doorsToClose < doors.size(), "Invalid number of doors to close");
//		for (int i = 0; i < doorsToClose; i++) {  //bucle para cerrar tantas puertas como indique el parámetro
//			if(doors.get(i).isOpened()) {  //si la puerta está cerrada
//				doors.get(i).close();
//				messages.add("The door number " + (i+1) + "has been closed");
//			}else {
//				messages.add("The door number " + (i+1) + "was already closed");
//			}
//		}
//		return messages;
		for(int i = 0; i < doors.size() && doorsToClose > 0; i++) {
			Door door = doors.get(i);
			if(door.isOpened()) {
				messages.add(door.close());
				doorsToClose --;
			}
		}
		if(doorsToClose > 0) {
			messages.add("WARNING: Not enough doors can be closed." + doorsToClose + " more doors should be closed");
		}
		return messages;
	}
	
	/**
	 * Cools down the greenhouse
	 * @param temp the average temperature calculate
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		to cool down the greenhouse
	 */
	private List<String> coolDown(double temp) {
		List<String> messages = new ArrayList<String>();
		messages.add("Current temp is" + temp + ". It is too hot.");
		int doorsToOpen = (int)(doors.size() * 0.10 * (temp - MAX_TEMPERATURE));
		messages.add(doorsToOpen + " doors must be opened");
		messages.addAll(openDoors(doorsToOpen));
		return messages;
	}

	/**
	 * Tries to open doorsToOpen doors
	 * @param doorsToOpen number of doors to open
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		open as many doors as the argument
	 */
	private List<String> openDoors(int doorsToOpen) {	
		List<String> messages = new ArrayList<String>();
		for(int i = 0; i < doors.size() && doorsToOpen > 0; i++) {
			Door door = doors.get(i);
			if(!door.isOpened()) {
				messages.add(door.open());
				doorsToOpen --;
			}
		}
		if(doorsToOpen > 0) {
			messages.add("WARNING: Not enough doors can be opened." + doorsToOpen + "more doors should be opened");
		}
		return messages;
	}
	
	
	private String rightTemperature(double temp) {
		return "Average temperature " +  temp + " is right";
	}
	
	/**
	 * Gets the average temperature in the greenhouse.
	 * 
	 * @return The average temperature in the greenhouse.
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for(TemperatureSensor sensor : sensors) {
			addition += sensor.getTemperature();
		}
		return addition / sensors.size();
	}

}
