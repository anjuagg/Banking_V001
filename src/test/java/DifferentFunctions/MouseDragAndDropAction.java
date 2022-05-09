package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropAction {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement Rbox=driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Ibox=driver.findElement(By.xpath("//div[@id='box106']"));
		Actions act= new Actions(driver);
		act.dragAndDrop(Rbox, Ibox).perform();
		
		
	}

}
