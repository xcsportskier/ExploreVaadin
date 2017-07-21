package com.udemy.vaadinspringboot;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "")
public class VaadinUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(new Label("You are here!!!"));
		Button b = new Button("Click Me");
		b.addClickListener(e -> vl.addComponent(new Label("Button have been clicked")));
		vl.addComponent(b);
		setContent(vl);
	}
}
