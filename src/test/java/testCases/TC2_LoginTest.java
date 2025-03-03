package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC2_LoginTest extends BaseClass {
	@Test(groups={"Regression","Master"})
	public void VerifyLogin()
	{
		try {
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
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Login Test Execution finished");
	}

}
