package DifferentFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import DifffunctionsUtility.JavaScriptUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutor {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Drawing border and take screenshot
		//WebElement logo=driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]"));
		//JavaScriptUtil.drawBorder(logo, driver);
		
		//TakesScreenshot ts= (TakesScreenshot)driver;
		//File src2=logo.getScreenshotAs(OutputType.FILE);
		//File tgt2= new File(".\\Screenshots\\image4.png");
		//FileUtils.copyFile(src2, tgt2);
		
		
		//flash
		//WebElement logo1 =driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]"));
		//JavaScriptUtil.flash(logo1, driver);
		
		//Getting title of page
		//String title=JavaScriptUtil.getTitleByJS(driver);
		//System.out.println(title);
		
		//click action
		//WebElement reglink=driver.findElement(By.linkText("Register"));
		//JavaScriptUtil.clickElementByJS(reglink, driver);
		
		//Generate Alert
		//JavaScriptUtil.generateAlert(driver, "This is my Alert...");
		//Thread.sleep(3000);
		
		//Refreshing the page
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		//Scrolling down page
		JavaScriptUtil.scrollPageDown(driver);
		
		// Scrolling up page
		//JavaScriptUtil.scrollPageUp(driver);
		
		// zoom page 
		//JavaScriptUtil.zoomPageByJS(driver);
		
		
		
		
	}

}
