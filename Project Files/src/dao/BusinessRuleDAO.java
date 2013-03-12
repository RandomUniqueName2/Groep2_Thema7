package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BusinessRuleDAO implements IBusinessRuleDAO {
	
	public void create(Connection connection){
		 try {  
	            
	            Statement statement = connection.createStatement();  
	            ResultSet resultset = statement.executeQuery("select 'Connected' from dual");  
	            resultset.next();  
	            String s = resultset.getString(1);  
	            System.out.println(s);  
	            statement.close();  
	              
		 }
	
		 catch (Exception e) {  
	            System.out.println("The exception raised is:" + e);
		 }
	   
	}
	
	public void read(){
		
	}
	
	public void update(){
		
	}
	
	public void delete(){
		
	}
	

}
