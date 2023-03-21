package com.lifegrip.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Driver;

/**
 * this class contains all reusable action of database
 * 
 * @author 91958
 *
 */
public class DatabaseUtility  {
	private Connection connection;
	private Driver dbDriver;
	private ResultSet result;
	private Statement statement;
	/**
	 * this method is used to fetch the data from database 
	 * @param query
	 * @param columnName
	 * @return
	 */


	public List<String> getDataFromDataBase(String query,String columnName)
	{ 
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		List<String> list=new ArrayList<String>();
		try {
			while(result.next())
			{
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}


	/**
	 * this method is used to open the database connection 
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL,String dbUserName,String dbPassword)
	{  
		try 
		{
			dbDriver = new Driver();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}
		try 
		{
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	/**
	 * this mthod is used to close  the database
	 */
	public void closeDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}}
	/**
	 * this method is used to modify the data
	 * @param query
	 */
	public void modifyDataIntoDB(String query)
	{
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			int result1 = statement.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * this method is used to verify the data in database
	 * @param query
	 * @param columnName
	 * @param exprctedData
	 * @return
	 */
	public boolean verifyDataInDatabase(String query,String columnName,String exprctedData) 
	{
		List<String> list=getDataFromDataBase(query, columnName);
		boolean flag=false;
		//	for(String actualData:list)
		//	{
		//		if(actualData.equalsIgnoreCase(exprctedData)){
		//			flag=true;
		//			break;
		//		}}
		if(list.contains(exprctedData)) flag=true;
		return flag;
	}


}
