package DifferentFunctions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert alertbox=driver.switchTo().alert();
		System.out.println(alertbox.getText());
		alertbox.sendKeys("Welcome to selenium");
		Thread.sleep(30);
		alertbox.accept();
		
	}

}
