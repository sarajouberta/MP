package uo.mp.s6.greenhouse.actuators.doors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Checkable;

public class AutomaticDoor extends Door implements Checkable {

	public AutomaticDoor(int id) {
		super(id);
	}
	
	public String open(){
		if(!isOpened()) {
			setOpened(true);
		}
		return "Door" + getId() + " opened automatically.";
	}

	public String close(){
		if(isOpened()) {
			setOpened(false);
		}
		return "Door" + getId() + " closed automatically.";
	}

	
	
	
	@Override
	public String toString() {
		return "[AutomaticDoor] " + getId() ;
	}
	
	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.05;   //simulaci�n 
	}
	
}
