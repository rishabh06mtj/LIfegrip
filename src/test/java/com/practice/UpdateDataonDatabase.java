package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataonDatabase {

	public static void main(String[] args) throws SQLException {
		String mobile="galaxy s7";
		String price="15000";
		String brand="Samsung";


		//step-1 create object for driver implementation class and register driver to JDBC
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);

		//step-2 GEt/establish database connection

		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/sdet44","root","root");

		/*
 try {
	////step-3 create connection
	 Statement statement=connection.createStatement();
	//step-4 execute Query
	 ResultSet result1=statement.executeQuery("select * from mobilePhone;");
	 while(result1.next())
	 {
		 String almobile= result1.getString("mobileName");
		 String alprice= result1.getString("price");
		 String albrand= result1.getString("brandName");

			if((almobile.equals(mobile))&&(alprice.equals(price))&&(albrand.equals(albrand)))
			 {System.out.println("not updated successfully");
				break;
				}
			else {
				int  result=statement.executeUpdate("insert into mobilePhone values('"+mobile+"','"+price+"','"+brand+"')");
				if(result==1)
				{
				System.out.println("data updated successfully");	
                 break;
				}}}
//step-5 validating data wheather updated or not
}
 catch(Exception e)
 {
e.printStackTrace();
}
finally {
connection.close();
statement.close();
}*/
		try {
			////step-3 create connection
			Statement statement=connection.createStatement();
			//step-4 execute Query
			ResultSet result=statement.executeQuery("select * from mobilePhone;");
			List<String> list=new ArrayList<String>();
			while(result.next())
			{list.add(result.getString("mobileName").toLowerCase()+" || "+result.getString("price").toLowerCase()+" || "+result.getString("brandName").toLowerCase());
			}
			if(list.contains(mobile.toLowerCase()+" || "+price.toLowerCase()+" || "+brand.toLowerCase().toLowerCase()))
			{System.out.println("data already existed");
				}
			else {
				statement.executeUpdate("insert into mobilePhone values('"+mobile+"','"+price+"','"+brand+"')");
			}
			}
		finally {
			connection.close();
	System.out.println("connection xclosed");
		}





		}

	}
