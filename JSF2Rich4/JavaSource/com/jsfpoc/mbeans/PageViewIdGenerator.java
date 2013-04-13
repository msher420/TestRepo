package com.jsfpoc.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author giftsam
 */
@ManagedBean (name="PageViewIdGenerator")
@SessionScoped
public class PageViewIdGenerator {
	private String includedPage = "/samplePageTwo.xhtml";

	public String sideBarAction() {
		/**
		 * Get the request parameter map from the context, so that we can find
		 * which link of the side is clicked
		 */
		FacesContext context = FacesContext.getCurrentInstance();
		String selectedPageViewId = context.getExternalContext()
				.getRequestParameterMap().get("pageViewId");

		if (selectedPageViewId.equalsIgnoreCase("page1")) {
			includedPage = "/samplePageOne.xhtml";
		} else if (selectedPageViewId.equalsIgnoreCase("page2")) {
			includedPage = "/samplePageTwo.xhtml";
		} else if (selectedPageViewId.equalsIgnoreCase("page3")) {
			includedPage = "/samplePageThree.xhtml";
		} else if (selectedPageViewId.equalsIgnoreCase("page4")) {
			includedPage = "/samplePageFour.xhtml";
		}
		return "";
	}

	/**
	 * @return the includedPage
	 */
	public String getIncludedPage() {
		return includedPage;
	}

	/**
	 * @param includedPage
	 *            the includedPage to set
	 */
	public void setIncludedPage(String includedPage) {
		this.includedPage = includedPage;
	}
}
