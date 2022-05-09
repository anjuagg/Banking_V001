package DifferentFunctions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedDropDown {
	public static void main(String[] args) {
		
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.twoplugs.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
	WebElement drp=driver.findElement(By.name("category_id"));
	Select drpservices= new Select(drp);
		
	List<WebElement>options=drpservices.getOptions();
	
	ArrayList orig=new ArrayList();
	ArrayList temp=new ArrayList();
	
	for(WebElement ele:options)
		
	{
		
		if (!ele.getText().equals("All"))
				{
			
		orig.add(ele.getText());// only storing the text value of options not web element
		temp.add(ele.getText());
		
	}}
	System.out.println("original list :"+orig);
	System.out.println("temporary list :"+temp);
	
	Collections.sort(temp);
	
	System.out.println("original list After sorting:"+orig);
	System.out.println("temporary list After sorting:"+temp);
	
	if(orig.equals(temp))
		System.out.println("dropdownlist is sorted");// we are checking dropdown list is sorted or not 
	else
		System.out.println("dropdownlist is not sorted");
	
	
	driver.quit();
	
	
	
	

}
}
