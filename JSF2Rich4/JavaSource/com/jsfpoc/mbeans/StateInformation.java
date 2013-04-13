package com.jsfpoc.mbeans;

import java.util.ArrayList;
import java.util.List;

public class StateInformation {
	private String stateName;
	private String stateCapital;
	private String Time;
	private List<StateInformation> capitals;

	public List<StateInformation> getCapitals() {
		capitals = new ArrayList<StateInformation>();
		StateInformation information = new StateInformation();
		information.setStatecapital("Los Angels");
		information.setStateName("California");
		information.setTime("GMT 5");
		capitals.add(information);
		return capitals;
	}

	public void setCapitals(List<StateInformation> capitals) {
		this.capitals = capitals;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCapital() {
		return stateCapital;
	}

	public void setStatecapital(String statecapital) {
		this.stateCapital = stateCapital;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

}
