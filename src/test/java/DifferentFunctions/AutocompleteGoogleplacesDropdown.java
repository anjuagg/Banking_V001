package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutocompleteGoogleplacesDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		WebElement place=driver.findElement(By.xpath("//input[@id='autocomplete']"));
		place.clear();
		place.sendKeys("Edmonton");
		String txt;
		Actions act= new Actions(driver);
		
		
		do {
			
		//place.sendKeys((Keys.ARROW_DOWN));
		act.moveToElement(place).sendKeys(Keys.ARROW_DOWN).perform();
		//act.sendKeys(Keys.ARROW_DOWN).perform();                         
		txt=place.getAttribute("value");
		if (txt.equals("Edmonton, KY, USA"))
		{
			
			//act.click().perform();
			//place.sendKeys(Keys.ENTER);// bug in application 
			
			break;
		}
		//Thread.sleep(3000);

		}while(!txt.isEmpty());
	}

}
