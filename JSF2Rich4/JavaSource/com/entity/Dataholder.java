package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "dataHolder")
@RequestScoped
public class Dataholder implements Serializable{
	private List<BusItem> biModList;

	@PostConstruct
	public void init() {
		//System.out.println("hai");
	}

	public List<BusItem> getModSubList(int first, int last) {
		//System.out.println("in side stud");
		
		int size = getModList().size();
		if (last > size) {
			last = size;
		}
		List<BusItem> subList = getModList().subList(first, last);
		//System.out.println("out side stud");
		return subList;
	}

	public List<BusItem> getModList() {
		return DataLoader.getBiModList();
	}

	public void setModList() {

	}

}
