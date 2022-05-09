package BankingTestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BankingPageObjects.Login_Page;
import BankingUtilities.XLUtilities;

public class TC_LoginDDT_002 extends BaseClass {


	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd)
{
	Login_Page lp= new Login_Page(driver);
	lp.setUserName(user);
	logger.info("user name provided");
	
	lp.setPassword(pwd);
	logger.info("password provided");
	lp.clickSubmit();
	
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("login failed");
		
	}
	
	else
	{
		Assert.assertTrue(true);
		logger.info("login passed");
		lp.clickLogout();
		driver.switchTo().alert().accept();//close logout alert
		driver.switchTo().defaultContent();
	}
}
	
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not 
	{
		try
		{
			driver.switchTo().alert();
				return true;
		}
		catch(NoAlertPresentException e)
		{ return false;
	}
	}
	
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException
	{

	String path=System.getProperty("user.dir")+"/src/test/java/BankingTestdata/Logintestdata1.xlsx";
	int rownum=XLUtilities.getRowCount(path, "Sheet1");
	int colcount=XLUtilities.getCellCount(path, "Sheet1", 1);
	String logindata[][]= new String[rownum][colcount];
	for(int i=1;i<=rownum;i++)
	{
		for(int j= 0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtilities.getCellData(path, "Sheet1", i, j);
			
		}
	}
	return logindata;
	
	
	}	
	
	
}