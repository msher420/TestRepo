package com.entity;

import java.util.ArrayList;
import java.util.List;
//import org.json.JSONObject;

public class JSFUtility {
/*
	public static List<BIDispayHolder> holder(List<BIModRate> fullCollection) {

		List<BIDispayHolder> biDispayHolders = new ArrayList<BIDispayHolder>();
		BIDispayHolder biDispayHolderNU = new BIDispayHolder();
		BIDispayHolder biDispayHolderSCG = new BIDispayHolder();
		int iNU = 1;
		int iSGC = 1;

		for (BIModRate biModRate : fullCollection) {
			if ("National unbundled".equals(biModRate.getBusinessName())) {
				if (iNU == 1) {
					List<BIModRate> abc = new ArrayList<BIModRate>();
					biDispayHolderNU.setBusinessName(biModRate
							.getBusinessName());
					biDispayHolderNU.setRegionName(biModRate.getRegionName());
					biDispayHolderNU.setBusinessModRates(abc);
					biDispayHolderNU.getBusinessModRates().add(biModRate);
					iNU++;
				} else {
					biDispayHolderNU.setRegionName(biModRate.getRegionName());
					biDispayHolderNU.getBusinessModRates().add(biModRate);
				}

			} else if ("SCG-External".equalsIgnoreCase(biModRate
					.getBusinessName())) {
				if (iSGC == 1) {
					List<BIModRate> abc = new ArrayList<BIModRate>();
					biDispayHolderSCG.setBusinessName(biModRate
							.getBusinessName());
					biDispayHolderSCG.setRegionName(biModRate.getRegionName());
					biDispayHolderSCG.setBusinessModRates(abc);
					biDispayHolderSCG.getBusinessModRates().add(biModRate);
					iSGC++;
				} else {
					biDispayHolderSCG.setRegionName(biModRate.getRegionName());
					biDispayHolderSCG.getBusinessModRates().add(biModRate);
				}

			}
		}
		biDispayHolders.add(biDispayHolderNU);
		biDispayHolders.add(biDispayHolderSCG);

		//System.out.println(biDispayHolders);
		return biDispayHolders;

	}
*/
//	public static String jsonBuilder(List<BIModRate> test) {
//		StringBuffer jsonStr = new StringBuffer();
//		int full = test.size();
//		int i = 0;
//		for (BIModRate biModRate : test) {
//			i++;
//			JSONObject jsonObject = new JSONObject(biModRate);
//			if (i != full) {
//				jsonStr = jsonStr.append(jsonObject.toString()).append(",");
//			}else{
//				jsonStr = jsonStr.append(jsonObject.toString());
//			}
//		}
//		//System.out.println(jsonStr.toString());
//		return jsonStr.toString();
//	}
}
