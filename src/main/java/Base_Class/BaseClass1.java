package Base_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	WebDriver driver;
	
	public static WebDriver getDriver(String Browser) throws InterruptedException
	{
		WebDriver driver = null;
		
		if(Browser.equals("Chrome"))
		{
			WebDriverManager.chromiumdriver().setup();
			driver =new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		return driver;
		
		
	}


}
