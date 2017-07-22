package com.udemy.vaadinspringboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.udemy.vaadinspringboot.data.Student;
import com.udemy.vaadinspringboot.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.SingleSelectionModel;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI(path = "")
public class VaadinUI extends UI {
	
	@Autowired
	private StudentService student;

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
		
		CheckBoxGroup<String> og = new CheckBoxGroup<>("Universities");
		
		List<String> items = new ArrayList<>();
		items.add("MIT");
		items.add("Harvard");
		items.add("UCLA");
		
		og.setItems(items);
		
		og.addValueChangeListener(event -> Notification.show(event.getValue().toString()));
		
		vl.addComponent(og);
		
		ComboBox<String> cb = new ComboBox<>("Names");
		
		cb.setItems(items);
		
		vl.addComponent(cb);
		
		List<Student> students = student.getStudents();
		
		ListDataProvider<Student> dp = new ListDataProvider<>(students);
		
		Grid<Student> gr = new Grid<>(Student.class);
		
		gr.setDataProvider(dp);
		
		gr.setColumnOrder("id","name","age");
		gr.setHeightMode(HeightMode.ROW);
		gr.setHeightByRows(students.size());
		
		gr.setSelectionMode(SelectionMode.SINGLE);
		
		vl.addComponent(gr);
		
		Button removeButton = new Button("Remove", 
				event -> { 
					SingleSelectionModel<Student> selectionModel = (SingleSelectionModel<Student>)gr.getSelectionModel();
					Student selectedStudent = selectionModel.getSelectedItem().get();
					Notification.show(selectedStudent.toString());
					dp.getItems().remove(selectedStudent);
					dp.refreshAll();
				});
		
		vl.addComponent(removeButton);
		
		setContent(vl);
	}
}
