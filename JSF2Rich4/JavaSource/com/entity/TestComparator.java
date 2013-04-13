package com.entity;

import java.util.Comparator;

public class TestComparator implements Comparator<BusItem> {

	@Override
	public int compare(BusItem o1, BusItem o2) {
		int bool = 0;
		if (o1 != null && o1 != null) {
			bool = o1.getBusName().compareTo(o2.getBusName());
		}
		return bool;
	}

}
