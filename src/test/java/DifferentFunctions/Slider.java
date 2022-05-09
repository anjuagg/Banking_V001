package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement minslider=driver.findElement(By.xpath("//body/div[2]/div[2]/span[1]"));
		WebElement maxslider=driver.findElement(By.xpath("//body/div[2]/div[2]/span[2]"));
		
		System.out.println("the location of minimun slider is ;  "+minslider.getLocation());
		System.out.println("the location of maxium slider is ;  "+maxslider.getLocation());
		
		Actions act =new Actions(driver);
		act.dragAndDropBy(minslider, 100, 0).perform();
		act.dragAndDropBy(maxslider, -100, 0).perform();
		
		System.out.println("the location of minimun slider is ;  "+minslider.getLocation());
		System.out.println("the location of maxium slider is ;  "+maxslider.getLocation());
	}

}
