package uo.mp.s6.greenhouse.controllers.devicescanner;

import java.util.ArrayList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;

public class DeviceScanner {
	List<Checkable> checkables = new ArrayList<Checkable>();
	
	public void add(Checkable checkable) {
		ArgumentChecks.isTrue(checkable != null, "Invalid checkable"); 
		checkables.add(checkable);
		
	}
	
	public List<String> scan(){
		List<String> messages = new ArrayList<>();
			for(Checkable checkable: checkables) {
				boolean isGood = checkable.check();
				if(!isGood) {
					messages.add(warnFailure(checkable));
				}
			}
			return messages;
	}
	
	private String warnFailure(Checkable checkable) {
		return "WARNING: " + checkable.toString() + " is not in good condition\n";
	}
}
