package uo.mp.s6.greenhouse.actuators.doors;

import uo.mp.util.check.ArgumentChecks;

/**
 * <p>Title: Door</p>
 * <p>Description: Class that simulates a door.</p>
 * <p>Copyright: Copyright (c) 2022</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class Door {

	protected boolean opened = false;
	protected int id;
	
	public Door(int id) {
		this.id = id;
	}

	public boolean isOpened() {
		return this.opened;
	}
	
	public String open(){
		if ( ! opened) {			
			opened = true;
			return "  Please, open the door " + id;
		}
		return "";
	}

	public String close(){
		if (opened) {
			opened = false;
			return "  Please, close the door" + id;
		}
		return "";
	}
	
	//Set-getters
	
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		ArgumentChecks.isTrue(id > 0, "Invalid id");
		this.id = id;
	}

	protected void setOpened(boolean opened) {
		this.opened = opened;
	}	
	
	
	
	
	
}
