package Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate_Login {

	WebDriver driver;
	
	@BeforeClass
	public void demo1() throws InterruptedException
	{
		WebDriverManager.chromiumdriver().setup();
		driver=new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		driver.manage().window().maximize();
	    Thread.sleep(5000);
	}
	
	@Test(priority=0)
	public void Login_Page() throws InterruptedException
	{
		Thread.sleep(4000);
		Login l= new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
		Thread.sleep(4000);
		System.out.println("Login successfull");
	}
}
