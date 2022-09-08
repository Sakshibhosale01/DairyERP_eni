package Register;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Class.BaseClass1;
import POM_Classes.Login;
import POM_Classes.Registrations;
import POM_Classes.Search;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateDesignation {

	WebDriver driver;

	@BeforeClass
	public void demo1() throws InterruptedException {
//		BaseClass1 B= new BaseClass1();
//	    B.getDriver("Chrome");
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test(priority = 0)
	public void Login_Page() throws InterruptedException {
		Thread.sleep(4000);
		Login l = new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	public void Register() throws InterruptedException {
		Thread.sleep(5000);
		Registrations f = new Registrations(driver);
		f.clickOnRegister();
		f.clickOnDesignation();
		Thread.sleep(2000);
	}

	@Test(priority = 2, enabled = false)
	public void Test2() throws InterruptedException {
		Search s = new Search(driver);
		s.enterInput();
		s.ClickOnsearchBTN();
	}

	@Test(priority = 2)
	public void selectDepartment() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.name("department"));
		Select s = new Select(dropdown);
		s.getOptions();
		s.selectByIndex(4);
	}

	@Test(priority = 3)
	public void enterDesignationName() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.name("DesignationName"));
		ele.click();
		ele.sendKeys("Marketing");
	}
	
	@Test(priority = 4, dependsOnMethods="enterDesignationName")
	public void selectDesignationLevel() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.name("designationLevel"));
		Select s = new Select(ele);
		s.selectByIndex(2);
	}

	@Test(priority = 5, dependsOnMethods="selectDesignationLevel")
	public void enterDesignationDescription() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.name("DesignationDescription")).sendKeys("Buy the products from Dairy Units and supply to small small shopkeepers");
	}
	
	@Test(priority=6, dependsOnMethods="enterDesignationDescription")
	public void SaveOrClear() throws InterruptedException
	{
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[text()='Save']")).click();
	     driver.findElement(By.xpath("//button[text()='Clear']")).click();
	}
	
	@AfterClass
	public void close()
	{
		//driver.close();
	}
}
