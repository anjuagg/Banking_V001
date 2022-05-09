package DifferentFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		
		//how many rows in table
		
		int rows=driver.findElements(By.xpath("//body/div[1]/main[1]/div[4]/div[1]/table[1][@class='table']/tbody/tr")).size();
		System.out.println("Total no of rows in a table :  "+rows);
		
		//How many columns in a table
		
		int cols=driver.findElements(By.xpath("//body/div[1]/main[1]/div[4]/div[1]/table[1][@class='table']/thead/tr/th")).size();
		System.out.println("Total no of coloumns in a table :  "+cols);
		
		// Retrieve the specific row column data
		String value= driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[4]/div[1]/table[1][@class='table']/tbody[1]/tr[3]/td[1]")).getText();
		System.out.println("The specfic value is:  "+value);
		
		// Retrieve all data from table
		
		System.out.println("/n The data from table is:    ");
		for (int r=1;r<=rows;r++)
		{
			for (int c=1;c<cols;c++)
			{
				String  data=driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[4]/div[1]/table[1][@class='table']/tbody[1]/tr["+r+"]/td["+c+"]")).getText();
				System.out.println("The values are:  "+data);
			}
			System.out.println();
		}
		
		
		driver.quit();
		
	}

}
