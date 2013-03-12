package controller;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.BusinessRuleDAO;


public class ConnectionController {
	public Boolean StartConnection() {
		Boolean confirmation = false;
		// dao.something.something(connectionString);
		try{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());  
        System.out.println("Connecting to the database...");  
        Connection connection = DriverManager.getConnection(  
                "jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", "THO7_2012_2B_TEAM2", "THO7_2012_2B_TEAM2");  
        //DriverManager.getConnection("jdbc:oracle:thin:@" + getHost() + ":" + getPort() + "/" + getDatabase(), getUser(),getPassword());
        BusinessRuleDAO dao = new BusinessRuleDAO();
        dao.create(connection);
        connection.close();
		}
		
		catch (Exception e) {  
            System.out.println("The exception raised is:" + e);
		}
		return confirmation;
	}

}
