package testCases;

import java.time.Duration;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC1_Registration extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public	void Register() throws InterruptedException
	{
		try {
		
		logger.info("****Testcase execution strated");
		HomePage hp=new HomePage(driver);
		hp.setMyAccount();
		hp.setRegiter();
		RegisterPage RP=new RegisterPage(driver);
		RP.setFname(randomString().toUpperCase());
		RP.txtLname(randomString().toLowerCase());
		RP.setemail(randomString()+"@gmail.com");
		RP.txtPhone(randomNumbers());
		String password=randomalphanumeric();
		RP.setPassword(password);
		RP.setConfPassword(password);
		RP.setSubscribe();
		RP.setAgree();
		RP.buttonContinue();
		logger.info("***Regiterd info entered***");
		
		logger.info("Account created", password, password, password, password, password, password, hp, RP, password);
	String msg=	RP.getConfirmmasg();
	Assert.assertEquals(msg, "Your Account Has Been Created!");
	}
	
	catch(Exception e)
	{
		logger.error("Test failed");
		logger.debug("Test failed");
		Assert.fail();
		
	}

}
}
