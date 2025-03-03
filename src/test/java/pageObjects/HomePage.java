package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement MyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement Register;
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement LoginLink;
	
	
	public void setMyAccount()
	{
		MyAccount.click();
	}
	
	public	void setRegiter()
	{
		Register.click();
	}
	public	void setLoginLink()
	{
		LoginLink.click();
	}
}
