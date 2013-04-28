package com.balusc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class ReportBean implements Serializable {
	private Report report;
	private List<Report> reports;
	private String currentCriteriaValue;
	private String currentCriteria;
	private Date criteriaFromDt;
	private Date criteriaToDt;

	public void loadReports() {
		// DB HIT to load all reports
	}

	public void loadReport() {

		// If the report is not clicked then by default new Report will be
		// created
		report = new Report();
		report.setReportName("1st Report");
		Criteria criteria1 = new Criteria();
		criteria1.setCriteriaName("RiskId");
		criteria1.setCriteriaValue("123");
		criteria1.populated = true;
		Criteria criteria2 = new Criteria();
		criteria2.setCriteriaName("SAI");
		criteria2.setCriteriaValue("456");
		criteria2.populated = true;
		Criteria criteria3 = new Criteria();
		criteria3.setCriteriaName("ProdCd");
		criteria3.populated = false;
		Criteria criteria4 = new Criteria();
		criteria4.setCriteriaName("RiskName");
		criteria4.populated = false;
		Criteria criteria5 = new Criteria();
		criteria4.setCriteriaName("Date");
		// criteria5.populated = false;
		report.unfilledCsrList = new ArrayList<Criteria>();
		report.filledCsrList = new ArrayList<Criteria>();
		report.unfilledCsrList.clear();
		report.filledCsrList.clear();
		report.filledCsrList.add(criteria1);
		report.filledCsrList.add(criteria2);
		report.unfilledCsrList.add(criteria3);
		report.unfilledCsrList.add(criteria4);
		// unfilledCsrList.add(criteria5);

		report.setUnfilledCsrList(report.unfilledCsrList);
		report.setFilledCsrList(report.filledCsrList);
		currentCriteria = null;
		currentCriteriaValue = null;

	}

	public void deleteCriteria(ActionEvent event) {
		Integer rowKey = (Integer) event.getComponent().getAttributes()
				.get("rowKey");

		// System.out.println("Row Key -> " + rowKey);
		report.unfilledCsrList.add(report.filledCsrList.get(rowKey));
		// System.out.println(report.filledCsrList);
		report.filledCsrList.remove(report.filledCsrList.get(rowKey));
		currentCriteria = null;
		// System.out.println(report.filledCsrList);
	}

	public boolean renderComponent() {
		System.out.println();
		boolean temp = true;
		if ("RiskName".equals(currentCriteria) || "SAI".equals(currentCriteria)
				|| "ProdCd".equals(currentCriteria)
				|| "RiskId".equals(currentCriteria)) {
			temp = true;
		} else {
			temp = false;
		}
		if (report != null && report.unfilledCsrList != null) {
			if (report.unfilledCsrList.isEmpty()) {
				temp = false;
			}
		}
		// System.out.println("--------> " + temp);
		return temp;

	}

	public boolean renderDate() {
		System.out.println("RenderDt -> " + currentCriteria);
		boolean temp = true;
		if ("Date".equals(currentCriteria)) {
			temp = true;
		} else {
			temp = false;
		}
		if (report != null && report.unfilledCsrList != null) {
			if (report.unfilledCsrList.isEmpty()) {
				temp = false;
			}
		}
		return temp;
	}

	public boolean renderAdd() {
		boolean temp = false;
		System.out.println("currentCriteria -> " + currentCriteria);
		if (report != null && report.unfilledCsrList != null
				&& report.unfilledCsrList.isEmpty()) {
			temp = true;
		}
		if (report == null || report.unfilledCsrList == null) {
			temp = true;
		}
		if (currentCriteria == null) {
			temp = true;
		}
		return temp;
	}

	public void componentchange(AjaxBehaviorEvent event) {
		HtmlSelectOneMenu ui = (HtmlSelectOneMenu) event.getSource();
		currentCriteria = (String) ui.getValue();
		System.out.println("latest Criteria" + currentCriteria);
	}

	public void updateReport() {
		// System.out.println("currentCriteria -> " + currentCriteria);
		// System.out.println("CurrentCriteriaValue -> " +
		// currentCriteriaValue);
		// System.out.println("criteriaFromDt -> " + criteriaFromDt);
		// System.out.println("criteriaToDt -> " + criteriaToDt);
		Iterator<Criteria> it = report.unfilledCsrList.iterator();
		while (it.hasNext()) {
			Criteria criteria = it.next();
			// System.out.println("criteria.getCriteriaName() -> "
			// + criteria.getCriteriaName());
			if (criteria.getCriteriaName().equals(currentCriteria)) {
				criteria.setCriteriaValue(currentCriteriaValue);
				report.filledCsrList.add(criteria);
				it.remove();
			}

		}
		setCurrentCriteriaValue("");
		setCurrentCriteria(null);
	}

	public void validateCriteriaValue(FacesContext context,
			UIComponent component, Object value) {
		
		if (currentCriteria.equals("RiskId")) {
			try {
					Integer.parseInt((String)value);
					System.out.println("--->" + currentCriteriaValue);

			} catch (NumberFormatException nfe) {
				FacesMessage facesMessage = new FacesMessage();
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				facesMessage.setSummary("Should Be a Number and not a String");
				FacesContext.getCurrentInstance().addMessage("", facesMessage);
				FacesContext.getCurrentInstance().renderResponse();
			}
		}
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public String getCurrentCriteria() {
		return currentCriteria;
	}

	public void setCurrentCriteria(String currentCriteria) {
		this.currentCriteria = currentCriteria;
	}

	public String getCurrentCriteriaValue() {
		return currentCriteriaValue;
	}

	public void setCurrentCriteriaValue(String currentCriteriaValue) {
		this.currentCriteriaValue = currentCriteriaValue;
	}

	public Date getCriteriaFromDt() {
		return criteriaFromDt;
	}

	public void setCriteriaFromDt(Date criteriaFromDt) {
		this.criteriaFromDt = criteriaFromDt;
	}

	public Date getCriteriaToDt() {
		return criteriaToDt;
	}

	public void setCriteriaToDt(Date criteriaToDt) {
		this.criteriaToDt = criteriaToDt;
	}

}
