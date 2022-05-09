package DifferentFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		//Full Page Screenshot
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File tgt= new File(".\\Screenshots\\image.png");
		FileUtils.copyFile(src, tgt);
		
		//Specific portion screenshot
		
		//WebElement portion=driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]"));
		WebElement portion=driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]"));
				File src1=portion.getScreenshotAs(OutputType.FILE);
				File tgt1= new File(".\\Screenshots\\image3.png");
				FileUtils.copyFile(src1, tgt1);
				
			// Screenshot of an webElement
				
				WebElement logo=driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]"));
						File src2=logo.getScreenshotAs(OutputType.FILE);
						File tgt2= new File(".\\Screenshots\\image2.png");
						FileUtils.copyFile(src2, tgt2);
				
	}

}
