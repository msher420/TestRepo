package com.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.richfaces.model.Arrangeable;
import org.richfaces.model.ArrangeableState;

@ManagedBean(name = "studDynamicDataModel")
@SessionScoped
public class StudDynamicDataModel extends ExtendedDataModel implements Arrangeable {

	private Integer rowId;
	private Map wrappedData = new HashMap();
	private List wrappedKeys = null;
	private Integer totalRows = 0;
	private Integer firstRow = 0;
	private Integer numberOfRows = 0;
	StudentHolder holder = new StudentHolder();

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
		this.rowId = (Integer) arg0;
	}

	@Override
	public void walk(FacesContext context, DataVisitor visitor, Range range,
			Object argument) {
		//System.out.println("in side walk");
		this.firstRow = ((SequenceRange) range).getFirstRow();
		this.numberOfRows = ((SequenceRange) range).getRows() + firstRow;
		//System.out.println("First Row " +firstRow + "\nLast Row " + numberOfRows);
		//System.out.println(((SequenceRange) range).getFirstRow());
		//System.out.println(((SequenceRange) range).getRows());
		
		// we can populate the data from Service Call/Web Service Call For eg.
		// Data from database or Search results using Range values
		wrappedKeys = new ArrayList<Integer>();
		List<Student> sampleDataList = holder
				.getStudent(firstRow, numberOfRows);

		// get the total no of rows from data source
		this.totalRows = holder.getStudentList().size();

		if (!sampleDataList.isEmpty()) {
			for (Student item : sampleDataList) {
				setRowKey(item.getId());
				wrappedKeys.add(item.getId());
				wrappedData.put(item.getId(), item);
				// Once data populated to wrappedKeys and wrappedData call the
				// process method using visitor parameter
				visitor.process(context, item.getId(), argument);
			}
		}
		//System.out.println("out side walk");
	}

	@Override
	public int getRowCount() {
		//System.out.println("in side getRowCount" + totalRows);
		// TODO Auto-generated method stub
		this.totalRows = holder.getStudentList().size();
		if (null != totalRows) {
			return this.totalRows;
		}
		return 0;
	}

	@Override
	public Object getRowData() {
		
		// TODO Auto-generated method stub
		if (null == rowId) {
			//System.out.println("in side getRowData" + rowId);
			return null;
		}
		//System.out.println("in side getRowData" + rowId + wrappedData.get(rowId));
		return wrappedData.get(rowId);
	}

	/*********************************************/

	@Override
	public int getRowIndex() {
		//System.out.println("in side getRowIndex");
		// TODO Auto-generated method stub
		return -1; 
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

	@Override
	public void arrange(FacesContext context, ArrangeableState arrState) {
		//System.out.println("************************************************************************************************");
		
	}

//	public Object getDataModel() {
//		//System.out.println("in side getDataModel");
//		return new DynamicDataModel();
//	}
}
