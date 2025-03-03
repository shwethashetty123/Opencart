package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser"})
	public void setup(String br) throws InterruptedException, IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default:System.out.println("invalid browser");return;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.get(p.getProperty("Appurl"));
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumbers()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}
	public String randomalphanumeric()
	{
	
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		return (generatedString+"@"+generatedNumber);
	}
	
	 public String captureScreenshot(String testName) throws IOException {
	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        TakesScreenshot ts=(TakesScreenshot)driver;
	        String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timestamp + ".png";
	        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	        File targetFile = new File(screenshotPath);
	        sourceFile.renameTo(targetFile);
	        return screenshotPath;
	    }
}
