package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentModel
{	
    static final String JDBC_Driver = "com.mysql.jcbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/";
    
    static final String user = "root";
    static final String password = "C34470Yu1212?";
    
    private String studentName;
    private String studentBirth;
    private String studentID;
    private String semester;
    
	private List<StudentModel> studentList;
    
    public StudentModel(String name, String dob, String id, String semester) {
		// TODO Auto-generated constructor stub
    	this.studentName = name;
 	   	this.studentBirth = dob;
 	   	this.studentID = id;
 	   	this.semester = semester; 	
 	    this.studentList = new ArrayList<StudentModel>();
    }
    
   public String getStudentName()
   {
	   return studentName;
   }
   public void setStudentName(String studentName)
   {
	   this.studentName = studentName;
   }
   
   public String getStudentBirth()
   {
	   return studentBirth;
   }
   
   public void setStudentBirth(String studentBirth)
   {
	   this.studentBirth = studentBirth;
   }
   
   public String getStudentID()
   {
	   return studentID;
   }
   
   public void setStudentID(String studentID)
   {
	   this.studentID = studentID;
   }
   
   public String getSemester()
   {
	   return semester;
   }
   
   public void setSemester(String semester)
   {
	   this.semester = semester;
   }
   
   public List<StudentModel> getStudentList()
   {
       return studentList;
   }

   public void addStudent(StudentModel student) 
   {
       this.studentList.add(student);
   }
   
   public static void main(String[] args)
   {
	   Connection conn = null;
	   Statement stmt = null;
	   try {
		   Class.forName(JDBC_Driver);
		   
		   System.out.println("Connecting to database ");
		   conn = DriverManager.getConnection(url, user, password);
		   
		   System.out.println("Creating statement ");
		   stmt = conn.createStatement();
		   String sql;
		   sql = "Select id, first_name, last_name FROM employees";
		   ResultSet rs = stmt.executeQuery(sql);
		   
		   while(rs.next())
		   {
			   int id = rs.getInt("id");
			   String firstName = rs.getString("first_name");
			   String lastName = rs.getString("last_name");
			   
			   System.out.print("ID: " + id);
			   System.out.print(", First Name: " + firstName);
	           System.out.println(", Last Name: " + lastName);	   
		   }
		   
		   rs.close();
	       stmt.close();
	       conn.close();
	      } catch(SQLException se) {
	         se.printStackTrace();
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(stmt!=null)
	               stmt.close();
	         } catch(SQLException se2) {
	         }
	         try {
	            if(conn!=null)
	            conn.close();
	         } catch(SQLException se) {
	            se.printStackTrace();
	         }
	      }
	   System.out.println("Bye");
   }


}

