package com.lifegrip.genericUtility;

public enum SheetName {

	CLIENTS("Clients");
	private String sheetName;
/**
 * this is constructor used to initialize 
 * @param sheetName
 */
	private SheetName(String sheetName)
	{
		this.sheetName=sheetName;
	}
	
/**
 * this method is used to retrn the string value of sheet
 * @return
 */
	public String convertToString(){

		return sheetName.toString(); 
	}
	
}
