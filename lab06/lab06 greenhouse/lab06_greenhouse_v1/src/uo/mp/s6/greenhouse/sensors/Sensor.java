package uo.mp.s6.greenhouse.sensors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;

public abstract class Sensor implements Checkable {

	protected int id;

	public Sensor() {
		
	}

	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.05;   //simulaci�n 
	}

}