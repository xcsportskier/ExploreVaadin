package com.udemy.vaadinspringboot;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "")
public class VaadinUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout vl = new VerticalLayout();
		TextField textField = new TextField("Text:");
		textField.setValue("Some value");
		textField.addValueChangeListener(e -> { 
			Label label = new Label(e.getValue());
			vl.addComponent(label);
		});
		textField.setValueChangeMode(ValueChangeMode.LAZY);
		vl.addComponent(textField);
		
		vl.addComponent(new Label("You are here!!!"));
		Button b = new Button("Click Me Once");
		b.addClickListener(e -> vl.addComponent(new Label("Button have been clicked")));
		vl.addComponent(b);
		setContent(vl);
	}
}
