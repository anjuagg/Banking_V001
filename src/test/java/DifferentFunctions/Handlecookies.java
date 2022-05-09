package DifferentFunctions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlecookies {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");

		// How to capture all cookies from browser
		Set<Cookie> cookies =driver.manage().getCookies();
		System.out.println("The total no of cookies are:  " +cookies.size());//3

		//How to print cookies from browser
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+ " : " + cookie.getValue());
		}
		
		//how to add cookies to browser
		Cookie cookieobj= new Cookie("NewCookiegenrated", "123456");
		driver.manage().addCookie(cookieobj);
		
			cookies =driver.manage().getCookies();
			System.out.println("The total no of cookies after adding are:  " +cookies.size());// should 4
			
		// How to delete specified cookie by cookieobj and cookiename
		//driver.manage().deleteCookie(cookieobj);
		
			driver.manage().deleteCookieNamed("NewCookiegenrated");
			cookies =driver.manage().getCookies();
			System.out.println("The total no of cookies after deleting are:  " +cookies.size());//should 3
		
			// How to delete all cookies
			driver.manage().deleteAllCookies();
			cookies =driver.manage().getCookies();
			System.out.println("The total no of cookies after deleting are:  " +cookies.size());//should 0

			driver.quit();
			
	}

}
