package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyView extends Application {
	
	Stage stage;
	TabPane tabPane;
	
	Tab tab1;
	Tab tab2;
	Tab tab3;
	
	//Tab 1
	TextField studentNameInput;
	TextField studentBirthInput;
	TextField studentIDinput;
	TextField semesterInput;
	
	Button addStudentButton;
	Button removeStudentButton;
	
	Label student_name;
	Label student_birth;
	Label student_id;
	Label module_name;
	Label semester;
	
	BooleanBinding studentAddBind;
	BooleanBinding studentRemoveBind;
	
	//Tab 2
	TextField moduleNameInput;
	TextField moduleCodeInput;
	     
	TextField gradeInput;
	TextField studentIdGrade;
	TextField moduleCodeGrade;
	
	Button addModuleButton;
	Button removeModuleButton;
	Button delete;
	Button enter;
	Button modify;
	
	Label module_code;
	Label student_id_grade;
	Label module_code_grade;
	Label grade;
	
	BooleanBinding moduleAddBind;
	BooleanBinding moduleRemoveBind;
	
	BooleanBinding gradeBind;
	//Tab 3
	TextField searchInput;
	
	Button searchButton;
	Button memoryLeakButton;
	
	Label search;
	
	TextArea info;
	
	private MyController controller;
	private ArrayList studentList;
	private ArrayList moduleList; 
	
	public void start(Stage primaryStage)
	{	
		controller = new MyController(this, null, null);
		//TabPane
		try 
		{
			this.stage = primaryStage;
			stage.setTitle("Student");
			BorderPane root = new BorderPane();
			tabPane = new TabPane();
			
			//Name Tabs
			tab1 = new Tab("Tab 1");
			tab2 = new Tab("Tab 2");
			tab3 = new Tab("Tab 3");
			
			//Prevent Tabs from closing
			tab1.setClosable(false);
			tab2.setClosable(false);
			tab3.setClosable(false);
			
			//Add Tabs
			tabPane.getTabs().add(tab1);
			tabPane.getTabs().add(tab2);
			tabPane.getTabs().add(tab3);
			
			//Tab 1
			
			//Label
			//Student Name
			student_name = new Label("Enter Student Name :");
			studentNameInput = new TextField();
			
			//Student Birth
			student_birth = new Label("Enter Student Birth :");
			studentBirthInput = new TextField();
			
			student_id = new Label("Enter Student ID :");
			studentIDinput = new TextField();
			
			//Module Name
			module_name = new Label("Enter Date of Birth :");
			moduleNameInput = new TextField();
			
			//Semester
			semester = new Label("Enter Semester : ");
			semesterInput = new TextField();
			
			//BooleanBind
			studentAddBind = studentNameInput.textProperty().isEmpty()
					.or(studentBirthInput.textProperty().isEmpty())
					.or(studentIDinput.textProperty().isEmpty()
					.or(semesterInput.textProperty().isEmpty()));
			
			studentRemoveBind = studentIDinput.textProperty().isEmpty()
					.or(studentNameInput.textProperty().isNotEmpty())
					.or(studentBirthInput.textProperty().isNotEmpty()
					.or(semesterInput.textProperty().isNotEmpty()));
			
			//Buttons
			//Add Students
			addStudentButton = new Button();
			addStudentButton.setText("Add");
			addStudentButton.setOnAction(e->controller.addStudent());
			addStudentButton.disableProperty().bind(studentAddBind);
			
			//Remove Students
			removeStudentButton = new Button();
			removeStudentButton.setText("Remove");
			removeStudentButton.setOnAction(e->controller.removeStudent());
			removeStudentButton.disableProperty().bind(studentRemoveBind);
						
			//HBOX
			HBox hb1 = new HBox(student_name, studentNameInput);
			hb1.setPadding(new Insets(10,10,2,10));
			hb1.setSpacing(15);
			
			HBox hb2 = new HBox(student_birth, studentBirthInput);
			hb2.setPadding(new Insets(2,2,2,10));
			hb2.setSpacing(22);
			
			HBox hb3 = new HBox(student_id, studentIDinput);
			hb3.setPadding(new Insets(2,2,2,10));
			hb3.setSpacing(35);
			
			HBox hb4 = new HBox(semester, semesterInput);
			hb4.setPadding(new Insets(2,2,2,10));
			hb4.setSpacing(40);
			
			HBox hb5 = new HBox(addStudentButton, removeStudentButton);
			hb5.setPadding(new Insets(2,2,15,10));
			hb5.setSpacing(10);
			
			//VBOX
			VBox vb = new VBox(hb1, hb2, hb3, hb4, hb5);
			
			
			tab1.setContent(vb);
			
			
			
			
			//Tab 2
			//Module Code
			module_code = new Label("Enter Module Code :");
			moduleCodeInput = new TextField();
			
			//Grade
			grade = new Label("Grade :");
			gradeInput = new TextField();
			
			student_id_grade = new Label("Student ID :");
			studentIdGrade = new TextField();
			
			module_code_grade = new Label("Module Code :");
			moduleCodeGrade = new TextField();
			
			moduleAddBind = moduleNameInput.textProperty().isEmpty()
					.or(moduleCodeInput.textProperty().isEmpty());
			
			moduleRemoveBind = moduleCodeInput.textProperty().isEmpty()
					.or(moduleNameInput.textProperty().isNotEmpty());
			
			
			gradeBind = gradeInput.textProperty().isEmpty()
					.or(studentIdGrade.textProperty().isEmpty())
					.or(moduleCodeGrade.textProperty().isEmpty());
			
			//Button
			//Add Module
			addModuleButton = new Button();
			addModuleButton.setText("Add");
			addModuleButton.setOnAction(e->controller.addModule());
			addModuleButton.disableProperty().bind(moduleAddBind);
			
			//Text Remove Module
			removeModuleButton = new Button();
			removeModuleButton.setText("Remove");
			removeModuleButton.setOnAction(e->controller.removeStudent());
			removeModuleButton.disableProperty().bind(moduleRemoveBind);
			
			//Delete
			delete = new Button();
			delete.setText("Delete");
			delete.setOnAction(e->controller.delete());
			delete.disableProperty().bind(gradeBind);
			//Enter
			
			enter = new Button();
			enter.setText("Enter");
			enter.setOnAction(e->controller.enter());
			enter.disableProperty().bind(gradeBind);
			
			//Modify
			modify = new Button();
			modify.setText("Modfiy");
			modify.setOnAction(e->controller.modify());
			modify.disableProperty().bind(gradeBind);
			
			HBox hb1t2 = new HBox(module_name, moduleNameInput);
			hb1t2.setPadding(new Insets(10,2,2,10));
			hb1t2.setSpacing(15);
			
			HBox hb2t2 = new HBox(module_code, moduleCodeInput);
			hb2t2.setPadding(new Insets(2,2,2,10));
			hb2t2.setSpacing(10);
			
			HBox hb3t2 = new HBox(addModuleButton, removeModuleButton);
			hb3t2.setPadding(new Insets(2,2,10,10));
			hb3t2.setSpacing(10);
			
			HBox hb4t2 = new HBox(grade, gradeInput);
			hb4t2.setPadding(new Insets(2,2,2,10));
			hb4t2.setSpacing(50);
			
			HBox hb5t2 = new HBox(student_id_grade, studentIdGrade);
			hb5t2.setPadding(new Insets(2,2,2,10));
			hb5t2.setSpacing(27);
			
			HBox hb6t2 = new HBox(module_code_grade, moduleCodeGrade);
			hb6t2.setPadding(new Insets(2,2,2,10));
			hb6t2.setSpacing(10);
			
			HBox hb7t2 = new HBox(delete, enter, modify);
			hb7t2.setPadding(new Insets(2,2,2,10));
			hb7t2.setSpacing(10);
			
			VBox vbt2 = new VBox(hb1t2, hb2t2, hb3t2, hb4t2, hb5t2, hb6t2, hb7t2);
			
			tab2.setContent(vbt2);
			
			
			
			
			//Tab 3
			search = new Label();
			search.setText("Search : ");
			search.setPadding(new Insets(5,0,0,0));
			searchInput = new TextField();
			
			//Text Area
			info = new TextArea();
			info.setPrefHeight(150);
			info.setPrefWidth(290);
			info.setEditable(false);
			info.setPromptText("Students in application");
			ScrollPane scroll = new ScrollPane(info);
			scroll.setDisable(true);
			
			//Button
			//Search
			searchButton = new Button();
			searchButton.setText("Search");
			searchButton.setOnAction(e->controller.search());
			
			//Memory Leak
			memoryLeakButton = new Button();
			memoryLeakButton.setText("Memory Leak");
			memoryLeakButton.setOnAction(e->controller.memoryLeak());
			
			HBox hb1t3 = new HBox(search, searchInput);
			hb1t3.setSpacing(10);
			hb1t3.setPadding(new Insets(2,2,2,10));
			
			HBox hb2t3 = new HBox(info);
			hb2t3.setPadding(new Insets(2,2,2,10));
			
			HBox hb3t3 = new HBox(memoryLeakButton, searchButton);
			hb3t3.setPadding(new Insets(2,2,2,150));
			hb3t3.setSpacing(10);
			
			VBox vbt3 = new VBox(hb1t3, hb2t3, hb3t3);
			vbt3.setPadding(new Insets(2,2,2,2));
			vbt3.setSpacing(4);
			
			tab3.setContent(vbt3);
			
			Scene scene = new Scene(root, 320, 300);
		    primaryStage.setScene(scene);
		    primaryStage.setResizable(false);
		    primaryStage.show();
			root.setCenter(tabPane);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getStudentName()
	{
		return studentNameInput.getText();
	}
	public String getStudentBirth()
	{
		return studentBirthInput.getText();
	}
	public String getStudentId()
	{
		return studentIDinput.getText();
	}
	public String getSemester()
	{
		return semesterInput.getText();
	}
	
	public void setStudentName(String name)
	{
		studentNameInput.setText(name);
	}
	public void setStudentBirth(String birth)
	{
		studentBirthInput.setText(birth);
	}
	public void setStudentId(String id)
	{
		studentIDinput.setText(id);
	}
	public void setSemester(String semester)
	{
		semesterInput.setText(semester);
	}
	
	public String getModuleName()
	{
		return moduleNameInput.getText();
	}
	public String getModuleCode()
	{
		return moduleCodeInput.getText();
	}
	public void setModuleName(String name)
	{
		moduleNameInput.setText(name);
	}
	public void setModuleCode(String code)
	{
		moduleCodeInput.setText(code);
	}

	public void updateStudentList(List<StudentModel> studentList) 
	{
		this.studentList = new ArrayList<>(studentList);
	}

	public void updateModuleList(List<ModuleModel> moduleList) 
	{
		this.moduleList = new ArrayList<>(moduleList);
	}
}