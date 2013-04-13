package com.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.richfaces.component.SortOrder;
import org.richfaces.model.Arrangeable;
import org.richfaces.model.ArrangeableState;
import org.richfaces.model.SortField;
import org.richfaces.model.ArrangeableStateDefaultImpl;

import com.sun.jmx.mbeanserver.ModifiableClassLoaderRepository;

@ManagedBean
@ViewScoped
public class TempDataModel<T> extends RichLazyDataModel<BusItem> implements
		Arrangeable, Serializable {
	ArrangeableState arrangeableState = null;
	Dataholder holder = new Dataholder();

	@Override
	public List<BusItem> getDataList(int firstRow, int numRows) {
		System.out.println("DB HIT");
		// TODO Auto-generated method stub
		
		int lastRow = firstRow + numRows;
		System.out.println("First -> " + firstRow + "Last -> " + numRows);
		List<BusItem> sampleDataList = holder
				.getModSubList(firstRow, lastRow);
		return sampleDataList;
	}

	@Override
	public Object getKey(BusItem t) {
		// TODO Auto-generated method stub
		return t.getRiskID();
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		System.out.println("Total Count DB HIT");
		return holder.getModList().size();
	}

	@Override
	public void arrange(FacesContext context, ArrangeableState arg) {
		// TODO Auto-generated method stub
		if (arg != null) {
			this.arrangeableState = arg;
			System.out.println("Arrange Available");
			for (SortField sortField : arrangeableState.getSortFields()) {
				// System.out.println(sortField.getSortBy().getValue(
				// facesContext.getELContext()));
				System.out.println(sortField.getSortBy().toString()
						+ sortField.getSortOrder());
			}
		} else {
			System.out.println("Arrange Not Available");
		}
	}

	@Override
	public void sortList(List<BusItem> cacheList) {
		System.out.println("Before SortList");
		if (arrangeableState != null
				&& arrangeableState.getSortFields() != null
				&& !arrangeableState.getSortFields().isEmpty()) {
			// System.out.println("Inside SortList");
			FacesContext facesContext = FacesContext.getCurrentInstance();

			for (SortField sortField : arrangeableState.getSortFields()) {
				// System.out.println(sortField.getSortBy().getValue(
				// facesContext.getELContext()));
				if (sortField.getSortBy().getExpressionString()
						.contains("busName")) {
					if (sortField.getSortOrder().equals(SortOrder.ascending)) {
						// System.out.println("Business Ascending");
						Collections.sort(cacheList,
								new Comparator<BusItem>() {
									@Override
									public int compare(BusItem o1,
											BusItem o2) {
										// TODO Auto-generated method stub
										return o1.getBusName().compareTo(
												o2.getBusName());
									}
								});
					} else if (sortField.getSortOrder().equals(
							SortOrder.descending)) {
						// System.out.println("Business Decending");
						Collections.sort(cacheList,
								new Comparator<BusItem>() {
									@Override
									public int compare(BusItem o1,
											BusItem o2) {
										// TODO Auto-generated method stub
										return o2.getBusName().compareTo(
												o1.getBusName());
									}
								});

					}
				} else if (sortField.getSortBy().getExpressionString()
						.contains("regionName")) {
					// For the State Sort

					if (sortField.getSortOrder().equals(SortOrder.ascending)) {
						// System.out.println("RegionName Ascending");
						Collections.sort(cacheList,
								new Comparator<BusItem>() {
									@Override
									public int compare(BusItem o1,
											BusItem o2) {
										// TODO Auto-generated method stub
										return o1.getRegionName().compareTo(
												o2.getRegionName());
									}
								});
					} else if (sortField.getSortOrder().equals(
							SortOrder.descending)) {
						// System.out.println("RegionName Descending");
						Collections.sort(cacheList,
								new Comparator<BusItem>() {
									@Override
									public int compare(BusItem o1,
											BusItem o2) {
										// TODO Auto-generated method stub
										return o2.getRegionName().compareTo(
												o1.getRegionName());
									}
								});

					}

				} else {

					// For the State Sort

					if (sortField.getSortOrder().equals(SortOrder.ascending)) {
						// System.out.println("Date Ascending");
						Collections.sort(cacheList,
								new Comparator<BusItem>() {
									@Override
									public int compare(BusItem o1,
											BusItem o2) {
										// TODO Auto-generated method stub
										return o1
												.getPolicy()
												.getDate()
												.compareTo(
														o2.getPolicy()
																.getDate());
									}
								});
					} else if (sortField.getSortOrder().equals(
							SortOrder.descending)) {
						// System.out.println("Date Descending");
						Collections.sort(cacheList,
								new Comparator<BusItem>() {
									@Override
									public int compare(BusItem o1,
											BusItem o2) {
										// TODO Auto-generated method stub
										return o2
												.getPolicy()
												.getDate()
												.compareTo(
														o1.getPolicy()
																.getDate());
									}
								});

					}

				}
			}
		}

		// Collections.sort(cacheList, Collections.reverseOrder());
		// return cacheList;
	}
}
