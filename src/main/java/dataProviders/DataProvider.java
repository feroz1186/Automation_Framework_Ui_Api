package dataProviders;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;


import utils.ExcelUtils;

public class DataProvider {
	
	
	@org.testng.annotations.DataProvider(name="userData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		
		return ExcelUtils.getExcelData("src/test/resources/TestData.xlsx", "Sheet1");
		
	}

}
