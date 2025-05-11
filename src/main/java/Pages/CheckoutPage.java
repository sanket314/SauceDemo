package Pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver, Properties loc) {
		super(driver, loc);
	}
	
	public void clickCart() {
		driver.findElement(By.cssSelector(loc.getProperty("Carticon"))).click();;
	}
	
	public void clickContinue() {
		click("ContinueShoppingbtn");
	}
	
	public void clickCheckout() {
	     click("Checkoutbtn");
	}
	
	public void removefromcheckout(int index) {
		driver.findElement(By.xpath("(//button[@class='btn_secondary cart_button'][normalize-space()='REMOVE'])["+index+"]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int removecount() {
		List<WebElement> remove=driver.findElements(By.xpath("(//button[@class='btn_secondary cart_button'][normalize-space()='REMOVE'])"));
		return remove.size();		
	}
	
	public void clickContinuecheckout() {
		click("Continuebtn");
	}
	public void clickCancel() {
		click("Cancelbtn");
	}
	public void fillform(String fname ,String lname ,String Zip) {
		
		type("FirstName", fname);
		type("LastName", lname);
		type("ZipCode", Zip);	
	}
	
	public void clickFinish() {
		driver.findElement(By.xpath(loc.getProperty("Finishbtn"))).click();
	}
}
