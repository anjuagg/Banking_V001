package DifferentFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxFunctions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// 1. Select specific check box
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//2. select all check boxes
		List<WebElement> daycheck=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		int totcheck=daycheck.size();
		
			//using for loop
			//for(int i=0;i<totcheck;i++)
			//	daycheck.get(i).click();
		
			//using for each loop
			//for(WebElement ele:daycheck)
				//ele.click();
			
			//3. select multiple check boxes by choice (eg. Monday &Sunday)
			/*for(WebElement ele:daycheck)
			{
				if(ele.getAttribute("id").equals("monday") || ele.getAttribute("id").equals("sunday"))
					ele.click();
			}*/
		
		//4.Select last two check boxes
		//total no of checkboxex-no of checkboxes want to select =starting index
		//7-2=5
		
		for(int i=totcheck-2;i<totcheck;i++)
			daycheck.get(i).click();
		
		//5. Select first two check boxes
		for(int i=0;i<totcheck;i++)
		{
			if(i<2)
				daycheck.get(i).click();
		}
		
		
		
	}

}
