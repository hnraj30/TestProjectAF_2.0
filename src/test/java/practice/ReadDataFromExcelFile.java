package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Navigate to row
		Row rw = sh.getRow(1);
		
		//Navigate to cell	
		Cell c1 = rw.getCell(2);
		
		//Capture the value and print
		
		String value = c1.getStringCellValue();
		System.out.println(value);
	}

}
