package com.entity;

import java.util.List;

public class BIDispayHolder {
	private String businessName;
	private String regionName;
	private List<BusItem> businessModRates;

	public List<BusItem> getBusinessModRates() {
		return businessModRates;
	}

	public void setBusinessModRates(List<BusItem> businessModRates) {
		this.businessModRates = businessModRates;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
