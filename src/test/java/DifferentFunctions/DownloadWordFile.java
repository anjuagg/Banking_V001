package DifferentFunctions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) {
		
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		
		//Chrome
		HashMap preferences=new HashMap();
		preferences.put(location, preferences);
		//preferences.put("disable-popup-blocking", true);
		preferences.put("download.default_directory", location);
		
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("disable-popup-blocking");
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		
		//Firefox
		
		/*HashMap preferences=new HashMap();
		preferences.put("download.default_directory", location);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setExperimentalOption("prefs", preferences);
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
		profile.setPreference("browser.download.folderList", 2);//0 for desktop 1 for download 2 for desired location
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver(options);*/
		
		//Edge
		/*HashMap preferences=new HashMap();
		preferences.put("download.default_directory", location);
		
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver(options);*/
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		

	}

}
