package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static Properties prop= new Properties();
	public static Properties loc = new Properties();
	public String filepath ="/Users/apple/eclipse-workspace/PracticeProject/src/test/resources/testdata/TestdataDemo.xlsx";
	
	@BeforeSuite
	public void Propload() throws IOException {
		
		FileInputStream configFis = new FileInputStream("/Users/apple/eclipse-workspace/PracticeProject/src/test/resources/configfiles/config.properties");
		prop.load(configFis);
		
		FileInputStream locFis =new FileInputStream("/Users/apple/eclipse-workspace/PracticeProject/src/test/resources/configfiles/locators.properties");
		loc.load(locFis);
	}
	
	@BeforeTest
    public void setupbrowser() {
	  
	
	  if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
		  WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();

	  }
	  if(prop.getProperty("browser").equalsIgnoreCase("Firefox")){
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(prop.getProperty("testurl"));
	
     }
	
	@AfterClass
	public void Close() {
		driver.quit();
	}

}
