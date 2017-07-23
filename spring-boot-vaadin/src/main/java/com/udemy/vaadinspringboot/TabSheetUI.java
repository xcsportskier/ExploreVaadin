package com.udemy.vaadinspringboot;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "/tab")
public class TabSheetUI extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout vl = new VerticalLayout();
		vl.setWidth("100%");
		
		TabSheet tabSheet = new TabSheet();
		tabSheet.setWidth("50%");
		
		HorizontalLayout hl1 = new HorizontalLayout();
		hl1.addComponent(new Label("Layout 1"));
		
		HorizontalLayout hl2 = new HorizontalLayout();
		hl2.addComponent(new Label("Layout 2"));
		
		tabSheet.addTab(hl1, "Layout 1");
		tabSheet.addTab(hl2, "Layout 2");
		
		vl.addComponent(tabSheet);
		vl.setComponentAlignment(tabSheet, Alignment.TOP_CENTER);

		setContent(vl);
	}
}
