package Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM_Classes.Registrations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateURL {

WebDriver driver;
	
	@BeforeClass
	public void LaunchedWeb() throws InterruptedException
	{
		WebDriverManager.chromiumdriver().setup();
		driver=new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		driver.manage().window().maximize();
	    Thread.sleep(5000);
	}
	
	@Test(priority=-1)
	public void MainURL() throws InterruptedException
	{
	     Thread.sleep(2000);
		 String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://dairyerp.eanifarm.com/default.html");
		System.out.println("Main URL is correct / Test Pass");
	}
	
	@Test(priority=0)
	public void DepartmentURL() throws InterruptedException
	{
		 Thread.sleep(2000);
		 Registrations r=new Registrations(driver);
		 r.clickOnRegister();
		 r.clickDepartment();
		 String url=driver.getCurrentUrl();
		 Assert.assertEquals(url, "http://dairyerp.eanifarm.com/department_reg");
		 System.out.println("URL Matched / Test Pass");
	}
	
	@Test(priority=0)
	public void DesignationURL() throws InterruptedException
	{
		 Thread.sleep(2000);
		 Registrations r=new Registrations(driver);
		 r.clickOnRegister();
		 r.clickOnDesignation();
		 String url=driver.getCurrentUrl();
		 Assert.assertEquals(url, "http://dairyerp.eanifarm.com/designation_reg");
		 System.out.println("URL Matched / Test Pass");
	}
	
	
}
