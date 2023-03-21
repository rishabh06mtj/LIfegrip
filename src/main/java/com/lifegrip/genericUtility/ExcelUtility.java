package com.lifegrip.genericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is containing excelreusable methods
 * @author 91958
 *
 */
public class ExcelUtility 
{
	private  Workbook workbook;
	private	FileInputStream fisExcel;
	private FileOutputStream fos;
	private DataFormatter df;
	/**
	 * this method is used to open the excel
	 */
	public void openExcel()
	{
		try {
			fisExcel = new FileInputStream(IConstantPath.EXCEL_PATH);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}


	}
	/**
	 * this method is used to fetch the data from excel using row and cell index 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel(String sheetName,int rowNumber,int cellNumber)
	{
		df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}
	/**
	 * this method is used to close the excel
	 */
	public void closeExcel()
	{
		try {
			fisExcel.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/**
	 *  this method is used to set the data back to excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public void setExcelData(String sheetName,int rowNumber,int cellNumber,String value)
	{
		workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).setCellValue(value);

		try {
			fos = new FileOutputStream(IConstantPath.EXCEL_PATH);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch the data based on testcase and column name
	 * @param sheetName
	 * @param expectedtestCaseName
	 * @param expectedcolumnName
	 * @return
	 */
	public String getDataFromExcel(String sheetName,String expectedtestCaseName,String expectedcolumnName)
	{ 
		Sheet sheet=workbook.getSheet(sheetName);
		int rowLength= sheet.getLastRowNum();
		int lastCellNum=sheet.getRow(0).getLastCellNum();

		String data="";
		for(int i=0;i<=rowLength;i++)
		{ 
			String actualTestCaseName=sheet.getRow(i).getCell(0).getStringCellValue();

			if(actualTestCaseName.equals(expectedtestCaseName)){
				for(int j=1;j<lastCellNum-1;j++)
				{
					String actualColumnName = sheet.getRow(i).getCell(j).getStringCellValue();

					if(actualColumnName.equals(expectedcolumnName))
					{
						data=df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}
		}


		return data;
	}
	/**
	 * this method is used to fetch the data based on key
	 * @param sheetName
	 * @param expectedKey
	 * @return
	 */
	public String getDataFromExcel(String sheetName,String expectedKey)
	{ 
		Sheet sheet=workbook.getSheet(sheetName);
		int lastCellNum=sheet.getRow(0).getLastCellNum();
		String data="";
		for(int i=0;i<lastCellNum;i++)
		{ 
			String actualKey=sheet.getRow(i).getCell(0).getStringCellValue();

			if(actualKey.equals(expectedKey))
			{
				data=df.formatCellValue(sheet.getRow(1).getCell(i));
				break;
			}
		}
		return data;
	}
	/**
	 * this method is used to fetch the multiple data from excel and store in String[][]
	 * @param sheetName
	 * @return
	 */
	public String[][] getDataFromExcel(String sheetName)
	{
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRowNumber= sheet.getLastRowNum();
		short lastCellNum=sheet.getRow(0).getLastCellNum();
		df=new DataFormatter();
		//declrration
		String[][] arr=new String[lastRowNumber][lastCellNum];
		//initialization
		for(int i=0;i<lastRowNumber;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return arr;
	}

}
