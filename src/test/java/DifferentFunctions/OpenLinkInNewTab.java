package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		String tabs=Keys.chord(Keys.CONTROL,Keys.RETURN);
		
		WebElement reglink=driver.findElement(By.linkText("Register"));
		reglink.sendKeys(tabs);
		//reglink.sendKeys(Keys.ENTER);
			
		
	}
}
