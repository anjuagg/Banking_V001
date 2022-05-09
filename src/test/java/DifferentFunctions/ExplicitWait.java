package DifferentFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://google.com/");
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("selenium",Keys.ENTER);
		//WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		By locator=By.xpath("//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[@id='center_col']/div[@id='res']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h3[1]");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(locator));//return true if element found otherwise exception thrown
		//WebElement ele=driver.findElement(locator);
		WebElement ele=waitForElementPresent(driver,locator,10);
		ele.click();
		driver.quit();
	}
		public static WebElement waitForElementPresent(WebDriver driver,By locator,int timeout)
		{
			WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return driver.findElement(locator);
			
			
			
		}
		
		
	

}

