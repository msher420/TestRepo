package com.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.ajax4jsf.model.ExtendedDataModel;
import org.richfaces.component.SortOrder;
import org.richfaces.model.ArrangeableModel;

@ManagedBean
@ViewScoped
public class SortBean implements Serializable{

	private SortOrder order = SortOrder.unsorted;

	private SortOrder orderRegion = SortOrder.unsorted;
	
	private SortOrder orderPolicyDt = SortOrder.unsorted;

	public void sortByRegion() {
		if (this.orderRegion.equals(SortOrder.ascending)) {
			System.out.println("Sort Region-> Toggle -> Ascending to Descending");
			setOrderRegion(SortOrder.descending);
			setOrder(SortOrder.unsorted);
			setOrderPolicyDt(SortOrder.unsorted);
		} else {
			System.out.println("Sort Region-> Toggle -> Descending to Ascending");
			setOrderRegion(SortOrder.ascending);
			setOrder(SortOrder.unsorted);
			setOrderPolicyDt(SortOrder.unsorted);
		}
	}

	public void sortByBus() {
		if (this.order.equals(SortOrder.ascending)) {
			System.out.println("Sort Business -> Toggle -> Ascending to Descending");
			setOrder(SortOrder.descending);
			setOrderPolicyDt(SortOrder.unsorted);
			setOrderRegion(SortOrder.unsorted);
		} else {
			System.out.println("Sort Business -> Toggle -> Descending to Ascending");
			setOrder(SortOrder.ascending);
			setOrderPolicyDt(SortOrder.unsorted);
			setOrderRegion(SortOrder.unsorted);
		}
	}
	
	public void sortByPolicyDt(){
		if (this.orderPolicyDt.equals(SortOrder.ascending)) {
			System.out.println("Sort PolicyDt -> Toggle -> Ascending to Descending");
			setOrderPolicyDt(SortOrder.descending);
			setOrder(SortOrder.unsorted);
			setOrderRegion(SortOrder.unsorted);
		} else {
			System.out.println("Sort PolicyDt-> Toggle -> Descending to Ascending");
			setOrder(SortOrder.ascending);
			setOrderPolicyDt(SortOrder.ascending);
			setOrder(SortOrder.unsorted);
			setOrderRegion(SortOrder.unsorted);
		}
	}

	public SortOrder getOrder() {
		System.out.println("Get Sort ->  Order business -> " + order.toString());
		return order;
	}

	public void setOrder(SortOrder order) {
		System.out.println("Set Sort ->  Order business -> " + order.toString());
		this.order = order;
	}

	public SortOrder getOrderRegion() {
		System.out.println("Get Sort ->  Order region -> " + orderRegion.toString());
		return orderRegion;
	}

	public void setOrderRegion(SortOrder orderRegion) {
		System.out.println("Set Sort ->  Order region -> " + orderRegion.toString());
		this.orderRegion = orderRegion;
	}

	public SortOrder getOrderPolicyDt() {
		System.out.println("Get Sort ->  Order PolicyDt -> " + orderPolicyDt.toString());
		return orderPolicyDt;
	}

	public void setOrderPolicyDt(SortOrder orderPolicyDt) {
		System.out.println("Set Sort ->  Order PolicyDt -> " + orderPolicyDt.toString());
		this.orderPolicyDt = orderPolicyDt;
	}
}
