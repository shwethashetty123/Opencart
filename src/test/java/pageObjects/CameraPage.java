package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CameraPage extends BasePage{
	
	
	public CameraPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//img[@title='Canon EOS 5D']")WebElement CanonCamereLink;
	@FindBy(xpath="//button[@id='button-cart']")WebElement AddtoCartLink;

	public	void CanCameraLink()
	{
		CanonCamereLink.click();
	}
	public	void ClickAddtoCart()
	{
		AddtoCartLink.click();
	}
}
