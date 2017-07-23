package com.udemy.vaadinspringboot;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "/hl")
public class HorizontalLayoutUI extends UI {
	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setWidth("100%");
		
		Button b1 = new Button("One");
		b1.setWidth("100%");
		
		hl.addComponent(b1);
		hl.addComponent(new Button("Two"));
		hl.addComponent(new Button("Three"));
		
		hl.setExpandRatio(b1, 1);
		hl.setSpacing(false);
		setContent(hl);
	}
}
