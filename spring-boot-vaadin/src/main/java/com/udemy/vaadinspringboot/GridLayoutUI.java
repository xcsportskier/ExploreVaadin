package com.udemy.vaadinspringboot;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "grid")
public class GridLayoutUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		GridLayout gl = new GridLayout(3, 3);

		TextField t = new TextField();
		gl.addComponent(t, 0, 0, 1, 0);
		gl.addComponent(new Button("Check"), 2, 0);
		Button b1 = new Button("Save");
		b1.setWidth("100%");
		b1.setIcon(VaadinIcons.SAFE);
		gl.addComponent(b1, 0, 1, 2, 1);

		setContent(gl);
	}
}
