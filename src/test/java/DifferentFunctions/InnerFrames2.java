package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrames2 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement inner_frame=driver.findElement(By.xpath("//body/iframe[1]"));
		
		driver.switchTo().frame(inner_frame);
		String text=driver.findElement(By.xpath("//body//h1")).getText();
		System.out.println(text);
		
		driver.switchTo().parentFrame();
		String out_txt=driver.findElement(By.xpath("//body//h2")).getText();
		System.out.println(out_txt);
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("HTML Iframes")).click();
		driver.quit();
		
		
	}

}
