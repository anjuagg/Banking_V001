package BankingTestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import BankingUtilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	

	//public static WebDriver driver;
	ReadConfig readconfig= new ReadConfig();

	public  String baseURL=readconfig.getApplicationURL();
	public  String username=readconfig.getUsername();
	public  String password=readconfig.getPassword();	
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger= LogManager.getLogger(BaseClass.class);
	
		if(br.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			
			//driver= new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
			driver= new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver= new InternetExplorerDriver();

		}
		driver.get(baseURL);

	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshots taken");
	}
	public String randomestring()
	{
		
		String generatedstring =RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
		
	}
	public static String randomeNum()
	{
		
		String generatedstring2 =RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
		
	}
	
	
	
	
	@AfterClass
	
	public void teardown() {
		driver.quit();
	}

}


