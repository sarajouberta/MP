package uo.mp.s6.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.s6.greenhouse.sensors.HumiditySensor;
import uo.mp.s6.greenhouse.sensors.IrrigatorPosition;
import uo.mp.util.check.ArgumentChecks;

public class HumidityController {
	
	public static final double MAX_HUMIDITY_LIMIT = 60;
	public static final double TOO_HIGH_HUMIDITY = 72;
	public static final double TOO_LOW_HUMIDITY = 32;
	public static final double MIN_HUMIDITY_LIMIT = 40;
	
	IrrigatorPosition irrigator = IrrigatorPosition.OFF; // off por defecto
	
	private List<HumiditySensor> sensors = new ArrayList<>();	
		
		
	public void add(HumiditySensor sensor) {
		ArgumentChecks.isTrue(sensor != null, "Invalid sensor");
		this.sensors.add(sensor);
	}
	
	
	/**
	 * Handles the doors to keep the temperature under control between 19 and 22 degrees
	 *
	 * @return A list of messages generated when monitoring
	 */
	public List<String> monitor() {
		List<String> messages = new ArrayList<String>();	
		double averageHumidity = getAverageHumidity();  //obtener humedad media
		messages.add("Current humidity is " + averageHumidity);
		IrrigatorPosition currentPosition = irrigator;
		if(averageHumidity > TOO_HIGH_HUMIDITY) {
			messages.add("It is too damp.");
			setIrrigatorPosition(IrrigatorPosition.OFF);
		}else if(averageHumidity < TOO_LOW_HUMIDITY) {
			messages.add("It is too dry.");
			setIrrigatorPosition(IrrigatorPosition.HIGH);
		}else {
			if(averageHumidity < MIN_HUMIDITY_LIMIT && averageHumidity > TOO_LOW_HUMIDITY) {  //si está por debajo de la mitad
				messages.add(" Humidity is a bit too dry.");
				irrigatorToUpperPosition();
				
			}else if(averageHumidity > MAX_HUMIDITY_LIMIT && averageHumidity < TOO_HIGH_HUMIDITY) {
				messages.add("Humidity is a bit too damp.");
				irrigatorToLowerPosition();

			}else {
				return messages;
			}
		}
		if(currentPosition != irrigator)
			messages.add("Irrigator system is " + currentPosition +" and is set to " + irrigator);

		return messages;
	}
	
	
	private void irrigatorToUpperPosition() {
		switch(irrigator) {
		case OFF:
			setIrrigatorPosition(IrrigatorPosition.LOW);
			break;
		case LOW:
			setIrrigatorPosition(IrrigatorPosition.MEDIUM);
			break;
		case MEDIUM:
			setIrrigatorPosition(IrrigatorPosition.HIGH);
			break;
		default:
			break;
		}
	}
	
	private void irrigatorToLowerPosition() {
		switch(irrigator) {
		case HIGH:
			setIrrigatorPosition(IrrigatorPosition.MEDIUM);
			break;
		case LOW:
			setIrrigatorPosition(IrrigatorPosition.OFF);
			break;
		case MEDIUM:
			setIrrigatorPosition(IrrigatorPosition.LOW);
			break;
		default:
			break;
		}
	}
	
	
	public String setIrrigatorPosition(IrrigatorPosition position){
		irrigator = position;
		StringBuilder str = new StringBuilder();
		str.append("Irrigator set to ");
		switch(position) {
		case OFF:
			str.append("OFF");
			break;
		case LOW:
			str.append("LOW");
			break;
		case MEDIUM:
			str.append("MEDIUM");
			break;
		case HIGH: 
			str.append("HIGH");
			break;
		}
		return str.toString();
	}

	/*
	 * Gets the average humidity in the greenhouse.
	 * 
	 * @return The average humidity in the greenhouse.
	 */
	private double getAverageHumidity() {
		double addition = 0;
		for(HumiditySensor sensor : sensors) {
			addition += sensor.getHumidity();
		}
		return addition / sensors.size();
	}
	
}
