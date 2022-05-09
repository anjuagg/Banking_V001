package DifferentFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlejqueryDropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("justAnInputBox")).click();
		//selectmultiplechoices(driver,"choice 1");
		//selectmultiplechoices(driver,"choice 1", "choice 2","choice 2 3","choice 6","choice 6 2 3");
		selectmultiplechoices(driver,"all");
		
			
	}
	
	public static void selectmultiplechoices(WebDriver driver,String...value)
	{
		By locator=By.xpath("//div[@id='comboTree87834DropDownContainer']/ul/li/span[@class='comboTreeItemTitle']");
		//By locator=By.xpath("//span[@class='comboTreeItemTitle']");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));//return true if element found otherwise exception thrown
				//WebElement ele=driver.findElement(locator);
		List<WebElement>choicesdrp=driver.findElements(locator);
		
		//List<WebElement> choicesdrp=driver.findElements(By.xpath("//div[@id='comboTree87834DropDownContainer']//li//span[@class='comboTreeItemTitle']"));
		System.out.println(choicesdrp.size());
		
		//[@class='comboTreeItemTitle']"));
		
		/*List<WebElement> choicesdrp=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement ele:choicesdrp)
			{
				String text=ele.getText();
				for(String val:value)
				{
					if(text.equals(val))
				{
					ele.click();
					break;
				}}
				}

			}
		else
		{
			
			for(WebElement choices:choicesdrp)
			{
				
				System.out.println("hi");
				System.out.println(choices.getText());
				choices.click();
				
			}
		}*/
		driver.quit();
		
		

	}
}


