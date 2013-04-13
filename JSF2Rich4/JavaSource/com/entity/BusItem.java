package com.entity;

import java.io.Serializable;


public class BusItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long riskID;
	private Policy policy;
	private String busName;
	private String regionName;

	public Long getRiskID() {
		return riskID;
	}

	public void setRiskID(Long riskID) {
		this.riskID = riskID;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getBusName() {
		//System.out.println(busName + "asdasdasdas");
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getRegionName() {
		//System.out.println(regionName);
		return regionName;
	}

	public void setRegionName(String regionName) {
		
		this.regionName = regionName;
	}

}
