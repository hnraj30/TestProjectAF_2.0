package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelfile {
	public static void main(String[]args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String LATSNAME = wb.getSheet("Leads").getRow(7).getCell(2).getStringCellValue();
		
		wb.getSheet("Leads").createRow(11).createCell(0).setCellValue("Raj");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		System.out.println(LATSNAME);
		
		
		
		
	
	}

}
