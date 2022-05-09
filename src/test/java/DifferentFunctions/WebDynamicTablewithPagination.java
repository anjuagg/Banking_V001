package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDynamicTablewithPagination {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		WebElement user=driver.findElement(By.id("input-username"));
		user.clear();
		user.sendKeys("demo");
		
		WebElement pwd=driver.findElement(By.id("input-password"));
		pwd.clear();
		pwd.sendKeys("demo");
		WebElement login=driver.findElement(By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]"));
		login.click();
		
		//Sales-order
		
		driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		
		//Table
		// 1.find total no. of pages in table
		
		String text=driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 20 of 12816 (641 Pages)')]")).getText();
		System.out.println(text);
		
		int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		System.out.println("The total no. of pages are:  "+total_pages);
		
		for(int p=1;p<=5;p++)
		{
			
		//find the active page
		WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
		System.out.println("Active page is : "+active_page.getText());
		active_page.click();
		
		// find total no. of rows in active page
		//int rows=driver.findElements(By.xpath("//body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody/tr")).size();
		int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
		System.out.println("Number of rows:" +rows);
		
		//get the data from each row
		for(int r=1;r<=rows;r++)
		{
			String orderid=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
			String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
			String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[4]")).getText();
			//System.out.println(orderid+"       "+customerName+"       "+status);
		
			
			//fetch the data depdeding upon condition
			/*if (status.equals("Pending"))
			{
				System.out.println(orderid+"       "+customerName+"       "+status);
		
		}*/
			if(customerName.equals("Vikas Patil"))
			{
				System.out.println(orderid+"       "+customerName+"       "+status);
			}
		}
		
		//Move to next to active page then that page become active 
		String pageno=Integer.toString(p+1);
		driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
		
		
		
		}
		
		driver.quit();
		
		
		
	}

	}
