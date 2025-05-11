package Pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	

	public LoginPage(WebDriver driver, Properties loc) {
		super(driver, loc);
	}
	
	public void enterusername(String name) {
		type("Username", name);
	}
	public void enterpassword(String password) {
		type("Password", password);
	}
	public void clicklogin(){
		click("Loginbtn");
	}
 
	
}
