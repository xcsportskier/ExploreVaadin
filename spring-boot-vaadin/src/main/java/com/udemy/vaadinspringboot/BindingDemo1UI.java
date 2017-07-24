package com.udemy.vaadinspringboot;

import org.springframework.beans.factory.annotation.Autowired;

import com.udemy.vaadinspringboot.data.Student;
import com.udemy.vaadinspringboot.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "bind")
public class BindingDemo1UI extends UI {

	@Autowired
	private StudentService studentService;

	@Override
	protected void init(VaadinRequest request) {
		Student student = studentService.getStudents().get(0);

		VerticalLayout vl = new VerticalLayout();
		TextField nameField = new TextField("Name:");
		TextField ageField = new TextField("Age:");

		vl.addComponent(nameField);
		vl.addComponent(ageField);

		BeanValidationBinder<Student> binder = new BeanValidationBinder<>(Student.class);
		binder.forField(nameField).bind("name");
		binder.forField(ageField)
			  .withConverter(new StringToIntegerConverter("Must enter a number"))
			  .withValidator(new IntegerRangeValidator("Invalid age value", 16, 100))
			  .bind("age");
		binder.setBean(student);

		Button saveButton = new Button("Save", event -> {
			try {
				binder.writeBean(student);
				System.out.println(student);
			} catch (ValidationException ex) {
				Notification.show("Student could not be saved");
			}
		});

		vl.addComponent(saveButton);

		Button resetButton = new Button("Reset", event -> {
			binder.readBean(student);
		});

		vl.addComponent(resetButton);

		setContent(vl);
	}
}
