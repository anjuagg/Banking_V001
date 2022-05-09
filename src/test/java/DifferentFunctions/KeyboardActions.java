package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://text-compare.com/");
		Actions act= new Actions(driver);
		WebElement inputtxt1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement inputtxt2=driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		//inputtxt1.sendKeys("Welcome to selenium");
		//Actions act= new Actions(driver);
		
	act.keyDown(Keys.SHIFT);
	act.sendKeys(inputtxt1,"welcome");
	act.keyUp(Keys.SHIFT);
	act.perform();
		
		//Actions act = new Actions(driver);
		
		//CTRL+A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL+C
				act.keyDown(Keys.CONTROL);
				act.sendKeys("c");
				act.keyUp(Keys.CONTROL);
				act.perform();
				
				//TAB- shift to input 2 box
				act.sendKeys(Keys.TAB);
				act.perform();
				
				//CTRL V
				act.keyDown(Keys.CONTROL);
				act.sendKeys("v");
				act.keyUp(Keys.CONTROL);
				act.perform();
				
				//compare text
				if(inputtxt1.getAttribute("value").equals(inputtxt2.getAttribute("value")))
					System.out.println("Text copied");	
				else
					System.out.println("Text not copied");	
		
	}
}
