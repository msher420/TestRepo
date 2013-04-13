package com.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.application.configuration.ConfigurationItemsBundle;
import org.richfaces.component.SortOrder;
import org.richfaces.model.ArrangeableModel;

@ManagedBean(name = "test")
@ViewScoped
public class Test implements Serializable {

	TempDataModel<BusItem> dataModel = new TempDataModel<BusItem>();

	

	public TempDataModel<BusItem> getDataModel() {
		return dataModel;
	}

	public void setDataModel(TempDataModel<BusItem> dataModel) {
		this.dataModel = dataModel;
	}
}
