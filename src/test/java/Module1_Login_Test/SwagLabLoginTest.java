package Module1_Login_Test;
import java.io.IOException;  

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabOpenMenuPage;

public class SwagLabLoginTest extends LibraryFiles.BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException 
	{
		initializeBrowser();
		
		login = new SwagLabLoginPage(driver);
		home = new SwagLabHomePage(driver);
		menu = new SwagLabOpenMenuPage(driver);
		
	}
	
	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		login.inpSwagLabLoginPageUsername(LibraryFiles.UtilityClass.getPFData("UN"));
		login.inpSwagLabLoginPagePassword(LibraryFiles.UtilityClass.getPFData("PWD"));
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);		
	}
	
	@Test
	public void verifyLogo() throws EncryptedDocumentException, IOException 
	{
		TCID=101;
		String actLogoText = home.getSwagLabHomePageLogoText();
		String expLogoText = LibraryFiles.UtilityClass.getTD(2, 2);
		Assert.assertEquals(expLogoText, actLogoText, "Failed:- both result are diff: ");
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			LibraryFiles.UtilityClass.captureSS(driver, TCID);
		}
		home.clickSwagLabHomePageOpenmenu();
		Thread.sleep(2000);
		menu.clickSwagLabOpenMenuPageLogoutBtn();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}