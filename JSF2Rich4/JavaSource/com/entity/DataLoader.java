package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@ApplicationScoped
public class DataLoader {
	private static  List<BusItem> biModList;
	// private List<BIDispayHolder> biDispayHolders;

	private String jsonData;

	public static  List<BusItem> getBiModList() {
		if (biModList == null) {
			System.out.println("Data Creation");
			BusItem BusItem1 = new BusItem();
			BusItem1.setRiskID(1L);
			BusItem1.setBusName("SCG-External");
			BusItem1.setRegionName("East");
			Policy policy1 = new Policy();
			policy1.setDate("Tuesday");
			BusItem1.setPolicy(policy1);

			BusItem BusItem2 = new BusItem();
			BusItem2.setRiskID(2L);
			BusItem2.setBusName("National unbundled");
			BusItem2.setRegionName("East");
			Policy policy2 = new Policy();
			policy2.setDate("Wednesday");
			BusItem2.setPolicy(policy2);

			BusItem BusItem3 = new BusItem();
			BusItem3.setRiskID(3L);
			BusItem3.setBusName("National unbundled");
			BusItem3.setRegionName("West");
			Policy policy3 = new Policy();
			policy3.setDate("Sunday");
			BusItem3.setPolicy(policy3);

			BusItem BusItem4 = new BusItem();
			BusItem4.setRiskID(4L);
			BusItem4.setBusName("National unbundled");
			BusItem4.setRegionName("West");
			Policy policy4 = new Policy();
			policy4.setDate("Sunday");
			BusItem4.setPolicy(policy4);

			BusItem BusItem5 = new BusItem();
			BusItem5.setRiskID(5L);
			BusItem5.setBusName("National unbundled");
			BusItem5.setRegionName("West");
			Policy policy5 = new Policy();
			policy5.setDate("Sunday");
			BusItem5.setPolicy(policy5);

			BusItem BusItem6 = new BusItem();
			BusItem6.setRiskID(6L);
			BusItem6.setBusName("SCG-External");
			BusItem6.setRegionName("West");
			Policy policy6 = new Policy();
			policy6.setDate("Sunday");
			BusItem6.setPolicy(policy6);
			biModList = new ArrayList<BusItem>();
			biModList.add(BusItem1);
			biModList.add(BusItem2);
			biModList.add(BusItem3);
			biModList.add(BusItem4);
			biModList.add(BusItem5);
			biModList.add(BusItem6);
		}
		return biModList;
	}

	public void setBiModList(List<BusItem> biModList) {
		this.biModList = biModList;
	}


	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

}
