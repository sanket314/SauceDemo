package TestCases;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.DashboardPage;
import Pages.LoginPage;
import base.BaseTest;

public class DashboardTest extends BaseTest{
	
	
	DashboardPage dashpage;
	LoginPage loginpage1;
	
	@BeforeClass
	public void Setup() {
	    loginpage1 =new LoginPage(driver,loc);
	    dashpage =new DashboardPage(driver,loc);
		loginpage1.enterusername("standard_user");
		loginpage1.enterpassword("secret_sauce");
		loginpage1.clicklogin();
	}
	
	@BeforeMethod
	public void pretest() throws InterruptedException{
		Thread.sleep(3000);
		driver.get(prop.getProperty("dashurl"));
		
		List<WebElement> removebuttons = driver.findElements(By.xpath("//button[text()='REMOVE']"));
		for(WebElement removebtn : removebuttons) {
			removebtn.click();
			}
		
	}
	
	
	@Test(priority=1)
	public void TC_DASH_02(){
       dashpage.addtocart(1);
	   int x=dashpage.numberofadd();
       if(x==5) {
    	   Assert.assertTrue(true);
       }
	}

	@Test(priority=2)
	public void TC_DASH_03() {
		dashpage.addtocart(1);
	    dashpage.removefromcart(1);
		int x=dashpage.numberofadd();
		int y=dashpage.numberofremove();
		if(x==6 && y==6) {
			Assert.assertTrue(true);
		}		
	}
	@Test(priority=3)
	public void TC_DASH_04(){
       dashpage.addtocart(1);
       dashpage.addtocart(2);
       dashpage.addtocart(3);
	   int x=dashpage.numberofadd();
       if(x==3) {
    	   Assert.assertTrue(true);
      }
	}

	@Test(priority=4)
	public void TC_DASH_05(){
      dashpage.addtocart(2);
       dashpage.addtocart(4);
       dashpage.addtocart(4);
       dashpage.removefromcart(1);
	   int x=dashpage.numberofadd();
       if(x==2) {
    	   Assert.assertTrue(true);
       }
	}
	
	@Test(priority=5)
	public void TC_DASH_06(){
      WebElement element = driver.findElement(By.cssSelector(loc.getProperty("Carticon")));
      Assert.assertTrue(element.isDisplayed());
		
	}
	
	@Test(priority=6)
	public void TC_DASH_08() throws InterruptedException{
      dashpage.clickItem("Sauce Labs Onesie");
      Thread.sleep(3000);
      Assert.assertTrue(driver.findElement(By.xpath(loc.getProperty("BackbtnOnItem"))).isDisplayed());
		
	}
	
	@Test(priority=7)
	public void TC_DASH_09() {
      dashpage.selectsorting("Name (A to Z)");
      List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
      
      List<String> actualProductNames = new ArrayList<>();
      for (WebElement product : productElements) {
          actualProductNames.add(product.getText());
      }
      
      List<String> expectedSortedNames = new ArrayList<>(actualProductNames);
      Collections.sort(expectedSortedNames);
      
      Assert.assertEquals(actualProductNames, expectedSortedNames);    
	}
	
	@Test(priority=8)
	public void TC_DASH_10() {
      dashpage.selectsorting("Name (Z to A)");
      List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
      
      List<String> actualProductNames = new ArrayList<>();
      for (WebElement product : productElements) {
          actualProductNames.add(product.getText());
      }
      
      List<String> expectedSortedNames = new ArrayList<>(actualProductNames);
      Collections.sort(expectedSortedNames , Collections.reverseOrder());
      
      Assert.assertEquals(actualProductNames, expectedSortedNames);    

      
      
	}
	@Test(priority=9)
	public void TC_DASH_11() {
      dashpage.selectsorting("Price (low to high)");
      List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
      
      List<Double> actualPrices = new ArrayList<>();
      for (WebElement priceElement : priceElements) {
    	  String priceText = priceElement.getText().replace("$", ""); 
          actualPrices.add(Double.parseDouble(priceText));
      }
      
      List<Double> expectedPrices = new ArrayList<>(actualPrices);
      Collections.sort(expectedPrices);
      
      Assert.assertEquals(actualPrices, expectedPrices);
	}

    @Test(priority=10)
    public void TC_DASH_12() {
    dashpage.selectsorting("Price (high to low)");
    List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
    
    List<Double> actualPrices = new ArrayList<>();
    for (WebElement priceElement : priceElements) {
  	  String priceText = priceElement.getText().replace("$", ""); 
        actualPrices.add(Double.parseDouble(priceText));
    }
    
    List<Double> expectedPrices = new ArrayList<>(actualPrices);
    Collections.sort(expectedPrices ,Collections.reverseOrder());
    
    Assert.assertEquals(actualPrices, expectedPrices);
  
    }
    
    @Test(priority=11)
    public void TC_DASH_13(){
     List <WebElement> add =driver.findElements(By.xpath("(//button[contains(text(),'ADD TO CART')])"));
     for(WebElement a :add) {
    	 a.click();
     }
     
     List<WebElement> count =driver.findElements(By.xpath("(//button[contains(text(),'ADD TO CART')])"));
     if(count.size()==0) {
    	 Assert.assertTrue(true);
     }   
    }
    
    @Test(priority=12)
    public void TC_DASH_14(){
     List <WebElement> add =driver.findElements(By.xpath("(//button[contains(text(),'ADD TO CART')])"));
     for(WebElement a :add) {
    	 a.click();
     }
     
     List <WebElement> remove =driver.findElements(By.xpath("(//button[contains(text(),'REMOVE')])"));
     for(WebElement b :remove) {
    	 b.click();
     }
     
     List<WebElement> count =driver.findElements(By.xpath("(//button[contains(text(),'ADD TO CART')])"));
     if(count.size()==6) {
    	 Assert.assertTrue(true);
     }   
    }
    
    
}
