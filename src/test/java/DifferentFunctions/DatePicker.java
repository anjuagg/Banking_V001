package DifferentFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click(); //opens date picker
		
		String day="10";
		String month="July";
		String year="2022";
		while(true)
		{
			String mthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[]=mthyear.split(" ");
			String mth=arr[0];
			String yr=arr[1];
						
			if(mth.equalsIgnoreCase(month) && yr.equals(year))
				break;
			else
			driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).click();
			
		}
		//Date Selection
		List<WebElement> dates= driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement ele:dates)
		{
			String date=ele.getText();
			if(date.equals(day))
			{
				ele.click();
			break;
		}
		}
		driver.quit();
		
	
		
		
	}
}
