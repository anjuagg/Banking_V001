package DifferentFunctions;

import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.ca/");
		driver.manage().window().maximize();
		
		// how to capture all links
		List<WebElement> links=driver.findElements(By.tagName("a"));// all the web links have anchor tag a
		int totlinks=links.size();
		System.out.println("The total no of links are "+totlinks);
		//driver.findElement(By.linkText("Deals Store")).click();
		//driver.findElement(By.partialLinkText("Store")).click();
		
		//Normal for loop
		/*for(int i=0;i<totlinks;i++)
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			
		}*/
		
		//Using for each loop
				for(WebElement linklist:links)
		{
			System.out.println("The inner text of links  "+linklist.getText());
			System.out.println("The proper url address of link is :"+linklist.getAttribute("href"));
		}
		
		driver.close();
		
	}
}
