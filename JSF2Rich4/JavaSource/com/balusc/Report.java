package com.balusc;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable{

	List<Criteria> filledCsrList;
	List<Criteria> unfilledCsrList;
	
	String reportName;

	public List<Criteria> getFilledCsrList() {
		return filledCsrList;
	}

	public void setFilledCsrList(List<Criteria> filledCsrList) {
		this.filledCsrList = filledCsrList;
	}

	public List<Criteria> getUnfilledCsrList() {
		return unfilledCsrList;
	}

	public void setUnfilledCsrList(List<Criteria> unfilledCsrList) {
		this.unfilledCsrList = unfilledCsrList;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

}
