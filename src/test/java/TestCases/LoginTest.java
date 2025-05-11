package TestCases;


import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.LoginPage;
import base.BaseTest;
import utilities.ReadXls;

public class LoginTest extends BaseTest{
	
	LoginPage loginpage;

	@BeforeMethod
	public void initPage() {
		driver.get(prop.getProperty("testurl"));
		loginpage=new LoginPage(driver,loc);
		
	}
	
	public void getdatafromexcel(int rownum) {
		Map<String,String> rowdata=null;
		try {
			rowdata=ReadXls.getRowdata(filepath, "Login", rownum);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 String username=rowdata.get("Username");
	 String password=rowdata.get("Password");
	 
	 loginpage.enterusername(username);
	 loginpage.enterpassword(password);
	 loginpage.clicklogin();	
	 
	}
	
	
	@Test(priority=1)
	public void TC01(){
		getdatafromexcel(1);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("dashurl"));
	
	}
   

	@Test(priority=2)
	public void TC02(){
		getdatafromexcel(2);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("testurl"));
	
	}
	
	@Test(priority=3)
	public void TC03(){
        getdatafromexcel(3);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("testurl"));
	
	}
	@Test(priority=4)
	public void TC04(){
		getdatafromexcel(4);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("testurl"));
	
	}
	
	@Test(priority=5)
	public void TC05(){
		getdatafromexcel(5);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("testurl"));
	
	}
	@Test(priority=6)
	public void TC06(){
		getdatafromexcel(6);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("testurl"));
	
	}
   
	@Test(priority=7)
	public void TC07(){
		getdatafromexcel(7);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("testurl"));
	
	}
	
	@Test(priority=8)
	public void TC08(){
		getdatafromexcel(8);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("testurl"));
	
	}
	@Test(priority=9)
	public void TC09(){
		getdatafromexcel(9);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("testurl"));
	
	}
	
	@AfterMethod
	public void Exit() throws InterruptedException {
		if(driver.getCurrentUrl().equals(prop.getProperty("dashurl"))) {
			driver.findElement(By.xpath(loc.getProperty("Sidemenu"))).click();
			driver.findElement(By.xpath(loc.getProperty("logoutbtn"))).click();
			Thread.sleep(4000);        
		}
	}
}
