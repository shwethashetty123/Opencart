package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement txtMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")WebElement Logout;
	
	
	public boolean ValidateMyAccount()
	{
	try
	{
		return (txtMyAccount.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
		
	}
	}
	
	
	public void LogoutLink()
	{
		Logout.click();
	}
	
	
	
}

