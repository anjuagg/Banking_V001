package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureSizeLocation {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement logo =driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[@id='divLogin']/div[@id='divLogo']/img[1]"));
		
		//Method 1		
		System.out.println(logo.getSize());
		System.out.println(logo.getSize().getHeight());
		System.out.println(logo.getSize().getWidth());
		
		//Method 2
		System.out.println(logo.getRect().getDimension());
		System.out.println(logo.getRect().getDimension().getWidth());
		System.out.println(logo.getRect().getDimension().getHeight());
		
		//Method 1		
		System.out.println(logo.getLocation());
		System.out.println(logo.getLocation().getX());
		System.out.println(logo.getLocation().getY());
		
		//Method 2
		System.out.println(logo.getRect().getX());
		System.out.println(logo.getRect().getY());
		
		driver.quit();
		
		
		

}
}

