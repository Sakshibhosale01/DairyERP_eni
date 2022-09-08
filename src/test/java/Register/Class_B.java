package Register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base_Class.BaseClass1;
import POM_Classes.Login;

public class Class_B{
	
	WebDriver driver;
	
	@Test
	public void Login_Page() throws InterruptedException
	{
		BaseClass1 B= new BaseClass1();
		B.getDriver("Chrome");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.get("http://dairyerp.eanifarm.com/dashboard");
//		driver.manage().window().maximize();
//		Thread.sleep(5000);
		Login l= new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
	}
	
	
	
	

}
