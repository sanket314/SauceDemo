package Pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver, Properties loc) {
		super(driver, loc);
	}
	  
  
	public void opensidemenu() {
		click("Sidemenu");
	}
	
	public void clickAllitems() {
		opensidemenu();
		click("Allitems");
	}
	
	public void logout() {
		opensidemenu();
		click("logoutbtn");
	}
	
	public void closemenu() {
		click("CloseSidemenu");
	}
	
	public void clickSorting() {
		click("Sortingicon");
	}
	
	public void addtocart(int index) {

		driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])["+index+"]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void removefromcart(int index) {
		driver.findElement(By.xpath("(//button[contains(text(),'REMOVE')])["+index+"]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int numberofadd() {
	   List<WebElement> add =driver.findElements(By.xpath("(//button[contains(text(),'ADD TO CART')])[\"+index+\"]"));
	   return add.size();
	   
	}
	
	public int numberofremove() {
		List<WebElement> remove =driver.findElements(By.xpath("(//button[contains(text(),'REMOVE')])[\"+index+\"]"));
	     return remove.size();
	}
	public void clickItem(String item) {
        String xpath = String.format("//div[normalize-space()='%s']", item);
        driver.findElement(By.xpath(xpath)).click();
        }
	
	public void selectsorting(String sort) {
		driver.findElement(By.xpath(loc.getProperty("Sortingicon"))).click();
        WebElement element = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select drp = new Select(element);
		drp.selectByVisibleText(sort);
		
	}
	
}