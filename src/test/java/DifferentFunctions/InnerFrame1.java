package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
		
		// frames can be switched by index, as web element, as frame name or id if available
		WebElement outer_frame= driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/iframe[1]"));
		driver.switchTo().frame(outer_frame);
		
		WebElement inner_frame=driver.findElement(By.xpath("//iframe[contains(text(),'<p>Your browser does not support iframes.</p>')]"));
		driver.switchTo().frame(inner_frame);
		
		driver.findElement(By.xpath("//body[1]/section[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("welcome to selenium");
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
		
		
		
	}

}
