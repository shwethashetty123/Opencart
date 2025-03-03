package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC3_LoginTestDDT extends BaseClass  {
	
	
@Test(dataProvider=("LoginData"), dataProviderClass =DataProviders.class, groups="DataDriven")
	public void VerifyLogin(String email, String pwd, String exp)
	{
	try {
		logger.info("Login Test Execution startrd");
		HomePage Hp=new HomePage(driver);
		Hp.setMyAccount();
		Hp.setLoginLink();
		
		
		LoginPage LP=new LoginPage(driver);
		LP.SetUsername(email);
		LP.SetPwd(pwd);
		LP.LoginBtn();
		
		AccountPage AP=new AccountPage(driver);
		boolean result=AP.ValidateMyAccount();
		//Assert.assertTrue(true);
		if(exp.equalsIgnoreCase("Valid"))
		{
			Assert.assertTrue(true);
			AP.LogoutLink();
		}
		else
		{
			Assert.assertTrue(false);
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		logger.info("Login Data driven testing completed");
	}

}
