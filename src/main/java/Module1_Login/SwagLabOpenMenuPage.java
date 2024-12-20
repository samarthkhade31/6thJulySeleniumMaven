package Module1_Login;
//POM class3
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabOpenMenuPage
{
	//step 1: declaration
	@FindBy(xpath = "//a[text()='Logout']") private WebElement logoutbtn;
	
	//step 2: initialization
	public SwagLabOpenMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3: usage
	public void clickSwagLabOpenMenuPageLogoutBtn() 
	{
		logoutbtn.click();
	}
}
