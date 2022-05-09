package DifferentFunctions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitGenericExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("selenium",Keys.ENTER);
		
		By locator=By.xpath("//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[@id='center_col']/div[@id='res']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h3[1]");
		WebElement ele= waitForElementWithFluentwait(driver,locator);
		ele.click();
		driver.quit();
	}

		
		public static WebElement waitForElementWithFluentwait(WebDriver driver, final By locator)
		{
			Wait<WebDriver> mywait=new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);
			
			WebElement element= mywait.until(new Function<WebDriver,WebElement>(){
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			} );
			
			return element;
			}
			
			
		}
		

		
		
		

	


