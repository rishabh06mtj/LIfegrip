package com.lifegrip.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
/**
 * this class is containing fileutility methods
 * @param propertyFilePath
 * @param key
 * @return
 */
private	FileInputStream fis;
private Properties property;
/**
 * this method is used to open the propertyFile
 */
public void openPropertyFile()
{
	try {
		fis = new FileInputStream(IConstantPath.PROPERTYFILE_PATH);
	} catch (FileNotFoundException e1) {
		
		e1.printStackTrace();
	}
	property=new Properties();
	try {
		property.load(fis);
	} catch (IOException e) 
	{
		e.printStackTrace();
	}


}
/**
 * this method is used to fetch the data from propertyFile using row and cell index 
 * @param propertyFilePath
 * @param key
 * @return
 */
	public String getDataFromPropertyFile(String key) {
	
	String value=property.getProperty(key);
	return value;
	}
	
	/**
	 * this method is used to close the property file
	 */
	public void closePropertyFile()
	{
	try {
		fis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		}
}
