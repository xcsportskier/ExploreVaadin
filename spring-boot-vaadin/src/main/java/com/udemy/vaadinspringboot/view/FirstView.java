package com.udemy.vaadinspringboot.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@UIScope
@SpringView(name=FirstView.NAME)
public class FirstView extends VerticalLayout implements View {
	
	public static final String NAME = "FirstView";

	@Override
	public void enter(ViewChangeEvent event) {
		Label l = new Label("First View");
		addComponent(l);
	}

}
