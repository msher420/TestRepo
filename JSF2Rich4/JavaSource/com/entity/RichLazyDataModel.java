package com.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;

public abstract class RichLazyDataModel<T> extends ExtendedDataModel<T> {

	private SequenceRange cachedRange = null;

	private Integer cachedRowCount = null;

	private List<T> cachedList = null;

	private Object rowKey;

	public abstract List<T> getDataList(int firstRow, int numRows);

	public abstract void sortList(List<T> cacheList);

	public abstract Object getKey(T t);

	public abstract int getTotalCount();

	public RichLazyDataModel() {

		super(); // shouldn't be needed try removing

	}

	@Override
	public void walk(FacesContext ctx, DataVisitor dv, Range range,
			Object argument) {
		System.out.println("Walk -> Start");
		SequenceRange sr = (SequenceRange) range;
		// System.out.println("Cached -> " + cachedRange + "Range -> " + sr);
		// System.out.println(cachedList);

		int firstRow = sr.getFirstRow();

		int numRows = sr.getRows();

		// Log.log("firstRow: " + firstRow + " numRows: " + numRows);
		cachedRange = sr;
		//if (FacesContext.getCurrentInstance().getCurrentPhaseId().equals(PhaseId.RENDER_RESPONSE)){
			cachedList = getDataList(firstRow, numRows);
			sortList(cachedList);
		//}
		//cachedList = getDataList(firstRow, numRows);

	

		// Adding Comparitor Logic for Sorting
		System.out.println("Before Sort -> " + cachedList);
		
		System.out.println("After Sort -> " + cachedList);

		for (T t : cachedList) {

			if (getKey(t) == null) {

				/*
				 * 
				 * the 2nd param is used to build the client id of the table
				 * 
				 * row, i.e. mytable:234:inputname, so don't let it be null.
				 */

				throw new IllegalStateException("found null key");

			}

			dv.process(ctx, getKey(t), argument);

		}
		System.out.println("Walk -> End");

	}

	/*
	 * 
	 * The rowKey is the id from getKey, presumably obtained from
	 * 
	 * dv.process(...).
	 */

	@Override
	public void setRowKey(Object rowKey) {

		this.rowKey = rowKey;

	}

	@Override
	public Object getRowKey() {

		return rowKey;

	}

	@Override
	public boolean isRowAvailable() {

		return (getRowData() != null);

	}

	@Override
	public int getRowCount() {

		if (cachedRowCount == null) {

			cachedRowCount = getTotalCount();

		}

		return cachedRowCount;

	}

	@Override
	public T getRowData() {

		for (T t : cachedList) {

			if (getKey(t).equals(this.getRowKey())) {

				return t;

			}

		}

		return null;

	}

	protected static boolean equalRanges(SequenceRange range1,
			SequenceRange range2) {

		if (range1 == null || range2 == null) {

			return range1 == null && range2 == null;

		} else {

			return range1.getFirstRow() == range2.getFirstRow()

			&& range1.getRows() == range2.getRows();

		}

	}

	/*
	 * 
	 * get/setRowIndex are used when doing multiple select in an
	 * 
	 * extendedDataTable, apparently. Not tested. Actually, the get method is
	 * 
	 * used when using iterationStatusVar="it" & #{it.index}.
	 */

	@Override
	public int getRowIndex() {
		//
		// if (cachedList != null) {
		// //System.out.println("Row Index Set");
		// ListIterator<T> it = cachedList.listIterator();
		//
		// while (it.hasNext()) {
		//
		// T t = it.next();
		//
		// if (getKey(t).equals(this.getRowKey())) {
		//
		// return it.previousIndex() + cachedRange.getFirstRow();
		//
		// }
		//
		// }
		//
		// }

		return 0;

	}

	@Override
	public void setRowIndex(int rowIndex) {

	}

	@Override
	public Object getWrappedData() {

		throw new UnsupportedOperationException("Not supported yet.");

	}

	@Override
	public void setWrappedData(Object data) {

		throw new UnsupportedOperationException("Not supported yet.");

	}

	public List<T> getCachedList() {

		return cachedList;

	}

}
