package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;

@ManagedBean
@ViewScoped
public class DynamicDataModel extends ExtendedDataModel<BusItem> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long rowId;
	private Map<Long, BusItem> wrappedData = new HashMap<Long, BusItem>();
	private Integer totalRows = 0;
	private Integer firstRow = 0;
	private Integer numberOfRows = 0;
	Dataholder holder = new Dataholder();

	@Override
	public Object getRowKey() {
		//System.out.println("in side getrowkey - " + rowId);
		// TODO Auto-generated method stub
		return rowId;
	}

	@Override
	public void setRowKey(Object arg0) {
		//System.out.println("in side setrowkey" + arg0);
		// TODO Auto-generated method stub
		this.rowId = (Long) arg0;
	}

	@Override
	public void walk(FacesContext context, DataVisitor visitor, Range range,
			Object argument) {
		System.out.println("in side walk");
		this.firstRow = ((SequenceRange) range).getFirstRow();
		this.numberOfRows = ((SequenceRange) range).getRows() + firstRow;
		//System.out.println("First Row " + firstRow + "\nLast Row "
		//		+ numberOfRows);
		//System.out.println(((SequenceRange) range).getFirstRow());
		//System.out.println(((SequenceRange) range).getRows());

		// we can populate the data from Service Call/Web Service Call For eg.
		// Data from database or Search results using Range values
		List<BusItem> sampleDataList = holder.getModSubList(firstRow,
				numberOfRows);

		// get the total no of rows from data source
		this.totalRows = holder.getModList().size();

		if (!sampleDataList.isEmpty()) {
			for (BusItem item : sampleDataList) {
				wrappedData.put(item.getRiskID(), item);
				visitor.process(context, item.getRiskID(), argument);
			}
		}
		System.out.println("out side walk");
	}

	@Override
	public int getRowCount() {

		// TODO Auto-generated method stub
		this.totalRows = holder.getModList().size();
		//System.out.println("in side getRowCount" + totalRows);
		if (null != totalRows) {
			return this.totalRows;
		} else
			return 0;
	}

	@Override
	public BusItem getRowData() {

		// TODO Auto-generated method stub
		//System.out.println("in side getRowData" + rowId
		//		+ wrappedData.get(rowId));
		return wrappedData.get(rowId);
	}

	/*********************************************/

	@Override
	public int getRowIndex() {
		//System.out.println("in side getRowIndex");
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getWrappedData() {
		//System.out.println("in side getWrappedData");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRowAvailable() {
		//System.out.println("in side isRowAvailable");
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setRowIndex(int arg0) {
		//System.out.println("in side setRowIndex");
		// TODO Auto-generated method stub

	}

	@Override
	public void setWrappedData(Object arg0) {
		//System.out.println("in side setWrappedData");
		// TODO Auto-generated method stub

	}

}
