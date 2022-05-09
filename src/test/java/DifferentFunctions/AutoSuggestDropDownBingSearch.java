package DifferentFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDownBingSearch {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.bing.com/");// samecmethod can be used for google search
		driver.manage().window().maximize();
		
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		List<WebElement> list= driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println("size of auosuggestion :"+list.size());
		for(WebElement listitems:list)
		{
			if(listitems.getText().equals("selenium testing"))//listitems.getText().contains("testing") aslo work
			{
				listitems.click();
				break;
			}
		}
		
		

}
}
