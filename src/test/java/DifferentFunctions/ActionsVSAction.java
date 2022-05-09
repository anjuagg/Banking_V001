package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsVSAction {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://automationpractice.com/index.php");
	//driver.manage().window().maximize();
	
	WebElement womenlink=driver.findElement(By.xpath("//a[@title='Women']"));
	WebElement Toplink=driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
	Actions act= new Actions(driver);
	//act.moveToElement(womenlink).moveToElement(Toplink).click().perform();
	Action act1=act.moveToElement(womenlink).build();//Actions is a predefined class in selenium and Action is an interface 
	act1.perform();
	
	act.moveToElement(Toplink).click().perform();
	Thread.sleep(3000);
	
	
}
}
