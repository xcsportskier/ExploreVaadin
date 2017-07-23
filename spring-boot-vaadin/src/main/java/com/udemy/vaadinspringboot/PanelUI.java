package com.udemy.vaadinspringboot;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "login")
public class PanelUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout vl = new VerticalLayout();
		
		vl.setHeight("100%");
		vl.setWidth("100%");
		vl.setMargin(true);
		
		Panel p = new Panel("Login");
		p.setSizeUndefined();
		
		vl.addComponent(p);
		vl.setComponentAlignment(p,Alignment.MIDDLE_CENTER);
		
		FormLayout loginLayout = new FormLayout();
		
		loginLayout.addComponent(new TextField("User Name"));
		loginLayout.addComponent(new PasswordField("User Password"));
		
		Button loginButton = new Button("Login");
		loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		Button signUp = new Button("Sign In");
		signUp.setStyleName(ValoTheme.BUTTON_PRIMARY);
		
		HorizontalLayout hl = new HorizontalLayout(loginButton, signUp);
		loginLayout.setSizeUndefined();
		loginLayout.setMargin(true);

		loginLayout.addComponent(hl);
		
		p.setContent(loginLayout);

		setContent(vl);
	}
}
