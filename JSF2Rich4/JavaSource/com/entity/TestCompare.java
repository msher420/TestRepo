package com.entity;

import java.util.Comparator;

public class TestCompare implements Comparator<BusItem> {

	public int compare(BusItem p1, BusItem p2) {
		// parameter are of type Object, so we have to downcast it to Employee objects
		String p1Name = p1.getBusName();
		String p2Name = p2.getBusName();
		// uses compareTo method of String class to compare names of the employee
		return p1Name.compareTo(p2Name);
	}

}