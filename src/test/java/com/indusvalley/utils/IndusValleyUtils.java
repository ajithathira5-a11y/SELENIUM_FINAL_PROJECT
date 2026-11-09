package com.indusvalley.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IndusValleyUtils {

	public static Object[] getTestData(String filepath, String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int row = sheet.getLastRowNum();
//		int col = sheet.getRow(0).getLastCellNum();
		
		Object[] data = new Object[row];
		
		DataFormatter formatter  = new DataFormatter();
		
		for(int i = 1;i<=row;i++)
		{
			
				data[i-1] = formatter.formatCellValue(sheet.getRow(i).getCell(0));
				
			
		}
		workbook.close();
		
		fis.close();
		return data;
		
	}
}
