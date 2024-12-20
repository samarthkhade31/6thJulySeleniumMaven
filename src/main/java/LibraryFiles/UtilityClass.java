package LibraryFiles;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	//This method is use to get Test Data from excel sheet
	//need to pass 2 inputs 1:rowindex 2:colindex
	//@AuthorName: Samarth
	
	public static String getTD(int rowindex, int collindex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Testing\\Automation\\6thjuly2024.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowindex).getCell(collindex).getStringCellValue();
		return value;
	}
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Samarth Khade\\eclipse-workspace\\6thJulySeleniumMaven\\Screenshot\\TestCaseID"+TCID+".jpg");
		
		FileHandler.copy(src, dest);
	}
	
	public static String getPFData(String key) throws IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Samarth Khade\\eclipse-workspace\\6thJulySeleniumMaven\\PropertyFile.properties");
		
		Properties p = new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
		
	}

}
