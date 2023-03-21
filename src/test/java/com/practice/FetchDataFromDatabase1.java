package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase1 {

	public static void main(String[] args) throws SQLException {

//step-1 create object for driver implementation class and register driver to JDBC
Driver driver=new Driver();
DriverManager.registerDriver(driver);

//step-2 GEt/establish database connection

Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/sdet44","root","root");

////step-3 create connection
Statement statement=connection.createStatement();

//step-4  execute query
ResultSet result=statement.executeQuery("select * from mobilePhone;");
while(result.next())
{
	
System.out.println(result.getString("mobileName")+" || "+  result.getString("price") +" || "+ result.getString("brandName"));

}


}
}