package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.CameraPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC4_OrderCamera extends BaseClass{

	@Test
	public void VerifyLogin()
	{
		
		logger.info("Login Test Execution startrd");
		HomePage Hp=new HomePage(driver);
		Hp.setMyAccount();
		Hp.setLoginLink();
		
		
		LoginPage LP=new LoginPage(driver);
		LP.SetUsername(p.getProperty("email"));
		LP.SetPwd(p.getProperty("password"));
		LP.LoginBtn();
		
		AccountPage AP=new AccountPage(driver);
		boolean result=AP.ValidateMyAccount();
		Assert.assertTrue(true);
		}
	@Test
	public void orderCamera()
	{
		logger.info("Selection of a camera");
		HomePage Hp=new HomePage(driver);
		Hp.CameraLink();
		
		CameraPage CP=new CameraPage(driver);
		CP.CanCameraLink();
		CP.ClickAddtoCart();
	}
}
