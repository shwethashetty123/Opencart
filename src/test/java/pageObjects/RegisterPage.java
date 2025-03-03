package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")WebElement txtFname;
	
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txtLname;
	@FindBy(xpath="//input[@id='input-email']")WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")WebElement txtPhone;
	@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement ConfirmPassword;
	@FindBy(xpath="//label[normalize-space()='No']")WebElement Subscribe;
	@FindBy(xpath="//input[@name='agree']")WebElement Agree;
	@FindBy(xpath="//input[@value='Continue']")WebElement Continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgconfirmation;
	
	public void setFname(String Fname)
	{
		txtFname.sendKeys(Fname);
	}
	public void txtLname(String Lname)
	{
		txtLname.sendKeys(Lname);
	}
	public void txtPhone(String phonenu)
	{
		txtPhone.sendKeys(phonenu);
	}
	public void setemail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfPassword(String conpwd)
	{
		ConfirmPassword.sendKeys(conpwd);
	}
		
	public void setSubscribe()
		{
		Subscribe.click();
	}
	public void setAgree()
	{
		Agree.click();
}
	public void buttonContinue()
	{
		Continue.click();
		
		//Actions act=new Actions(driver);
		//act.moveToElement(Continue).click().perform();
}
	
	public String getConfirmmasg() {
	
	try{
		return(msgconfirmation.getText());
	   }
	catch(Exception  e)
	{
		return(e.getMessage());
	}
	}
}

