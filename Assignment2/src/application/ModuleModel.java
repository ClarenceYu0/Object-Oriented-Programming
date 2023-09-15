package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ModuleModel 
{
	static final String JDBC_Driver = "com.mysql.jcbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/";
    
    static final String user = "root";
    static final String password = "C34470Yu1212?";
    
	private String moduleName;
    private String moduleCode;
    
    private List<ModuleModel> moduleList;
    
    public ModuleModel(String name, String code) {
		// TODO Auto-generated constructor stub
    	this.moduleName = name;
    	this.moduleCode = code;
	}

	public String getModuleName()
    {
 	   return moduleName;
    }
    public void setModuleName(String moduleName)
    {
 	   this.moduleName = moduleName;
    }
    public String getModuleCode()
    {
 	   return moduleCode;
    }
    public void setModuleCode(String moduleCode)
    {
 	   this.moduleCode = moduleCode;
    }

    public List<ModuleModel> getModuleList()
    {
        return moduleList;
    }

    public void addModule(ModuleModel module) 
    {
        this.moduleList.add(module);
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
