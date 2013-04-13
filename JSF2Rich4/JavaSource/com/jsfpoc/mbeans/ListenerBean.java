package com.jsfpoc.mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.component.UIDataScroller;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.UIScripts;
import org.richfaces.component.UISelect;

import com.sun.faces.component.visit.FullVisitContext;

@ManagedBean(name = "listenerBean")
@ViewScoped
public class ListenerBean implements Serializable {

	// TODO Auto-generated method stub
	public void valueChange(AjaxBehaviorEvent event) {
		
		HtmlSelectOneMenu ui = (HtmlSelectOneMenu) event.getSource();
		Integer val =  Integer.parseInt((String) ui.getValue());
		//System.out.println("val -> " + val);
		FacesContext context = FacesContext.getCurrentInstance();
		final String id = "riskData";
		//****************
	    UIViewRoot root = context.getViewRoot();
	    final UIComponent[] found = new UIComponent[1];
	    root.visitTree(new FullVisitContext(context), new VisitCallback() {     
			@Override
			public VisitResult visit(VisitContext context, UIComponent component) {
				// TODO Auto-generated method stub
				if(component.getId().endsWith(id)){
	                found[0] = component;
	                return VisitResult.COMPLETE;
	            }
	            return VisitResult.ACCEPT;   
			}
	    });		
		//System.out.println(found[0]);
		//**************
		
//		UIDataTable dataTable = (UIDataTable) context.getViewRoot()
//				.findComponent("j_idt14:riskData");
		//System.out.println(dataTable.getId());
		((UIDataTable)found[0]).setRows(val);
		UIDataScroller topScroller = (UIDataScroller) context.getViewRoot()
				.findComponent("j_idt14:dsTop");
		System.out.println("$$$$$$$$$$$$$$$$$$$"+context.getViewRoot().getChildren());
		//System.out.println("************" + topScroller.getRowCount());
		//topScroller.setRendered(true);
	}
}
