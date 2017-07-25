package com.udemy.vaadinspringboot;

import org.springframework.beans.factory.annotation.Autowired;

import com.udemy.vaadinspringboot.view.FirstView;
import com.udemy.vaadinspringboot.view.SecondView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "/nav")
public class NavigatorUI extends UI {
	
	@Autowired
	private SpringViewProvider viewProvider;


	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout root = new VerticalLayout();
		
		Button firstViewButton = new Button("Navigate to first view");
		Button secondViewButton = new Button("Navigate to second view");
		
		Panel viewContainer = new Panel();
		Navigator navigator = new Navigator(this, viewContainer);
		navigator.addProvider(viewProvider);
		
		//navigator.addView(FirstView.NAME, new FirstView());
		//navigator.addView(SecondView.NAME, new SecondView());
		//navigator.addView("", new FirstView());
		
		root.addComponent(new HorizontalLayout(firstViewButton, secondViewButton));
		root.addComponent(viewContainer);
		
		navigator.navigateTo(FirstView.NAME);
		
		firstViewButton.addClickListener(event -> navigator.navigateTo(FirstView.NAME));
		secondViewButton.addClickListener(event -> navigator.navigateTo(SecondView.NAME));
		
		setContent(root);
	}
}
