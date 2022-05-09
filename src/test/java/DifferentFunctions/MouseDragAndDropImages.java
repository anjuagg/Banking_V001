package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropImages {
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		WebElement frame1=driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]/iframe[1]"));
		driver.switchTo().frame(frame1);
		WebElement img1=driver.findElement(By.xpath("//body/div[1]/ul[1]/li[1]/img[1]"));
		WebElement dest=driver.findElement(By.xpath("//div[@id='trash']"));
		Actions act =new Actions(driver);
		act.dragAndDrop(img1, dest).perform();
		

}
}
