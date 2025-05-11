package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;
import Pages.CheckoutPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import base.BaseTest;

public class CheckoutTest extends BaseTest{

	CheckoutPage checkout;
	LoginPage loginpage1;
	DashboardPage dashboard;
	
	@BeforeClass
	public void Setup() {
	    loginpage1 =new LoginPage(driver,loc);
        checkout =new CheckoutPage(driver,loc);
        dashboard =new DashboardPage(driver,loc);
	    loginpage1.enterusername("standard_user");
		loginpage1.enterpassword("secret_sauce");
		loginpage1.clicklogin();
	}
	
	@Test(priority=1)
	public void TC_01() throws InterruptedException {
		dashboard.addtocart(1);
		dashboard.addtocart(2);
        checkout.clickCart();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("checkouturl")));
	}
	
	@Test(priority=2)
	public void TC_02() throws InterruptedException {
		dashboard.removefromcart(1);
		int x= dashboard.numberofremove();
		if(x==1) {
			Assert.assertTrue(true);
		}
	}

	@Test(priority=3)
	public void TC_03() throws InterruptedException {
	      checkout.clickCheckout();
	      Thread.sleep(3000);
          Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("checkoutsteponeurl")));
	}
	

	@Test(priority=4)
	public void TC_04() throws InterruptedException {
		checkout.clickCancel();
		checkout.removefromcheckout(1);
		checkout.clickCheckout();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("checkoutsteponeurl")));

	}
	
	@Test(priority=5)
	public void TC_05() throws InterruptedException {
		driver.get(prop.getProperty("dashurl"));
		dashboard.addtocart(1);
		checkout.clickCart();
		checkout.clickCheckout();
		checkout.fillform("", "Smith", "12345");
		checkout.clickContinuecheckout();
		Thread.sleep(3000);
		Assert.assertTrue(checkout.getelement("FirstnameError").isDisplayed());
	}
	
	@Test(priority=6)
	public void TC_06() throws InterruptedException  {
        driver.navigate().refresh();
		checkout.fillform("Two", "", "54321");
		checkout.clickContinuecheckout();
		Thread.sleep(3000);
		Assert.assertTrue(checkout.getelement("LastnameError").isDisplayed());
	}
	@Test(priority=7)
	public void TC_07() throws InterruptedException  {
        driver.navigate().refresh();
		checkout.fillform("Third", "Third", "");
		checkout.clickContinuecheckout();
		Thread.sleep(3000);
		Assert.assertTrue(checkout.getelement("ZipcodeError").isDisplayed());
	}
	
	@Test(priority=8)
	public void TC_08()  {
		checkout.clickCancel();
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("checkouturl")));
	}
	
	@Test(priority=9)
	public void TC_09()  {
		checkout.clickCheckout();
		checkout.fillform("Neo", "Smith", "12345");
		checkout.clickContinuecheckout();
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("checkoutsteptwourl")));
	}
	@Test(priority=10)
	public void TC_10()  {
		checkout.clickCancel();
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("dashurl")));
	}
	@Test(priority=11)
	public void TC_11()  {
		dashboard.addtocart(1);
		checkout.clickCart();
		checkout.clickCheckout();
		checkout.fillform("Neo", "Smith","12345");
		checkout.clickContinuecheckout();
		checkout.clickFinish();
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ordercompleteurl")));
	}
	
}
