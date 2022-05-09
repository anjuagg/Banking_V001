package DifferentFunctions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkExample {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		//driver.get("https://www.google.ca/");
		//driver.get("https://epsb.ca/schools/schoolzone/");

		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));// all the web links have anchor tag a
		int totlinks=links.size();
		System.out.println("the total no of links are:  "+totlinks);
		int brokenlink=0;
		int validlink=0;
		for(WebElement linklist:links)
		{
			
			String url=linklist.getAttribute("href");
			if(url.equals(null)|| url.isEmpty())
			{
				System.out.println("The url is empty");
				continue;
			}
			
				URL link=new URL(url);// it convert href into actual url
				try {
				HttpURLConnection httpconn= (HttpURLConnection)link.openConnection();
				int code=httpconn.getResponseCode();
				System.out.println(code);
				if(code>=400)
				{
					System.out.println("The link is broken :"+code);
					brokenlink++;
				}
				else
				{
					System.out.println("The link is valid :"+code);
					validlink++;
				}}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
		}
		System.out.println("The total broken links are "+brokenlink);
		System.out.println("The total valid links are "+validlink);
		
		
		driver.quit();
		

	}

}
