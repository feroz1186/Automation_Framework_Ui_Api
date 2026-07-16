package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static Object[][] getExcelData(String path, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheetAt(0);
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(1).getLastCellNum();
		Object[][] data = new Object[rowCount-1][colCount] ;
		DataFormatter formatter = new DataFormatter();
		
		for(int i=1;i<rowCount;i++)
		{
			Row row = sheet.getRow(i);
			
			for(int j=0;j<colCount;j++)
			{
				Cell cell = row.getCell(j);
				data[i-1][j] = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		fis.close();
		return data;
	}

}
