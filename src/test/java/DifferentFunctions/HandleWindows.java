package DifferentFunctions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String orig=driver.getWindowHandle();
		System.out.println("The window id of original window: "+orig);
		
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		
		Set<String> winids= driver.getWindowHandles();// in set duplicates are not allowed
		
		//First method iterator to get all browser window ids
		/*Iterator<String> s=winids.iterator();
		String parentWinId=s.next();
		String childWinId= s.next();
		
		System.out.println("The window id of parent window: "+parentWinId);
		System.out.println("The window id of child window: "+childWinId);*/
		
		//second method-using List/ArrayList
		List<String> winIdList= new ArrayList(winids);// list duplicates are allowed
		String parid=winIdList.get(0);
		String childid=winIdList.get(1);
		System.out.println("The window id of parent window: "+parid);
		System.out.println("The window id of child window: "+childid);
		
		// how to use window id for switching
		
		/*System.out.println("the title of parent window is  "+driver.getTitle());
		driver.switchTo().window(childid);
		System.out.println("the title of child window is  "+driver.getTitle());
		
		driver.switchTo().window(parid);
		System.out.println("the title of parent window is  "+driver.getTitle());*/
		
		//For each loop
		for(String winid:winIdList)
		{
			String title= driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			if(title.equals("OrangeHRM"))// for closing particular window
				driver.close();
			
		}
		//driver.close();
		//driver.quit();
		
	
		
		
		
		
		
		
	}

}
