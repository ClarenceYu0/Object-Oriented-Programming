package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyController{
    static final String url = "jdbc:mysql://localhost:3306/";
    
    static final String user = "root";
    static final String password = "C34470Yu1212?";
    
	MyView view;
	StudentModel studentModel;
	ModuleModel moduleModel;
    
	public MyController(MyView view, StudentModel studentModel, ModuleModel moduleModel)
	{
		this.view = view;
		this.studentModel = studentModel;
		this.moduleModel = moduleModel;
	}
	
	public void addStudent()
	{	
		String name = view.studentNameInput.getText();
		String dob = view.studentBirthInput.getText();
		String id = view.studentIDinput.getText();
		String semester = view.semesterInput.getText();
	    
		try {
	        Connection connection = DriverManager.getConnection(url, user, password);
	        Statement statement = connection.createStatement();
	        String sql = "CREATE DATABASE StudentModel";
	        statement.executeUpdate(sql);
	        String createTable = "CREATE TABLE StudentModel.studentTable "
	        		+ "("
	                + "id VARCHAR(10) NOT NULL, "
	                + "name VARCHAR(25) NOT NULL, "
	                + "dob VARCHAR(10), "
	                + "semester VARCHAR(10), "
	                + "PRIMARY KEY (id)"
	                + ");";
	        statement.executeUpdate(createTable);
	        
	        String insertData = "INSERT INTO StudentModel.studentTable (id, name, dob, semester) "
	                + "VALUES ('" + id + "', '" + name + "', '" + dob + "', '" + semester + "');";
	        statement.executeUpdate(insertData);
	        
	        System.out.println("Database Created");
	        
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        // handle the exception
	    }
		view.studentNameInput.clear();
		view.studentBirthInput.clear();
		view.studentIDinput.clear();
		view.semesterInput.clear();
	}
	
	public void removeStudent()
	{
	    
	    view.studentIDinput.clear();
	}
	
	public void addModule()
	{
		String name = view.moduleNameInput.getText();
		String code = view.moduleCodeInput.getText();
		
		try {
	        Connection connection = DriverManager.getConnection(url, user, password);
	        Statement statement = connection.createStatement();
	        String sql = "CREATE DATABASE ModuleModel";
	        statement.executeUpdate(sql);
	        String createTable = "CREATE TABLE StudentModel.studentTable "
	        		+ "("
	                + "id VARCHAR(10) NOT NULL, "
	                + "name VARCHAR(25) NOT NULL, "
	                + "PRIMARY KEY (id)"
	                + ");";
	        statement.executeUpdate(createTable);
	        
	        String insertData = "INSERT INTO moduleTable (code, name) "
	                + "VALUES ('" + code + "', '" + name + "');";
	        statement.executeUpdate(insertData);
	        
	        System.out.println("Database Created");	
	        
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        // handle the exception
	    }
		
		view.moduleNameInput.clear();
		view.moduleCodeInput.clear();
	}
	
	
	public void removeModule()
	{
	    String idToRemove = view.moduleCodeInput.getText();
	    int indexToRemove = -1;
	    for (int i = 0; i < moduleModel.getModuleList().size(); i++) {
	        if (moduleModel.getModuleList().get(i).getModuleCode().compareTo(idToRemove) == 0)
	        {
	            indexToRemove = i;
	            break;
	        }
	    }
	    if (indexToRemove >= 0) {
	        moduleModel.getModuleList().remove(indexToRemove);
	    }
	    
	    view.updateModuleList(moduleModel.getModuleList());
	    view.moduleCodeInput.clear();
	}
	public void delete()
	{
		
	}
	
	public void enter()
	{	
		
	}
	
	public void modify()
	{	
		
	}
	
	public void search()
	{
	
	}  
	
	public void memoryLeak()
	{
		while (true) 
		{
            Object studentObj = new Object();
        }
	}

}