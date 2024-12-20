package Module1_Login;
//POM class1
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage
{
	//step 1: declaration
	@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath = "//input[@id='password']") private WebElement PWD;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	@ FindBy(xpath = "//div[@class='error-message-container error']") private WebElement errorMsg; 
	
	//steep 2: initialization
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3: usage
	public void inpSwagLabLoginPageUsername(String username) 
	{
		UN.sendKeys(username);
	}
	
	public void inpSwagLabLoginPagePassword(String password) 
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwagLabLoginPageLoginBtn() 
	{
		loginBtn.click();
	}
	
	public void verifySwagLabLoginPageErrorMsg(String expErrorMsg)
	{
		String actErrorMsg = errorMsg.getText();
		if (actErrorMsg.contains(expErrorMsg))
		{
			System.out.println("Pass");
		} 
		else 
		{
			System.out.println("Fail");
		}
		
	}
	
}
