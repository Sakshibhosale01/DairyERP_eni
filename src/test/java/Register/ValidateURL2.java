package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateURL2 {

	WebDriver driver;

	@BeforeClass
	public void LaunchedWeb() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = -1)
	public void LoginURL() throws InterruptedException {
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://dairyerp.eanifarm.com/");
		System.out.println("Login URL is correct / Test Pass");
	}
	
	@Test(priority = 0)
	public void Login_Page() throws InterruptedException {
		Thread.sleep(2000);
		Login l = new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
		Thread.sleep(4000);
	}
	
	@Test(priority = 1)
	public void DashboardURL() throws InterruptedException {
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://dairyerp.eanifarm.com/dashboard");
		System.out.println("Dashboard URL is correct / Test Pass");
	}
	
	@Test(priority = 2)
	public void routeURL() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Register']")).click();     //click on register
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Route']")).click();             //click on route
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://dairyerp.eanifarm.com/route_reg");
		System.out.println("Route URL is correct / Test Pass");
		driver.navigate().back();
	}
	
	@Test(priority = 3, timeOut=10000)
	public void unitURL() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Register']")).click();     //click on register
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Unit']")).click();             //click on unit
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://dairyerp.eanifarm.com/unit_reg");
		System.out.println("Unit URL is correct / Test Pass");
		driver.navigate().back();
	}
	
	@Test(priority = 4)
	public void userURL() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Register']")).click();     //click on register
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='User']")).click();             //click on route
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://dairyerp.eanifarm.com/user_reg");
		System.out.println("User URL is correct / Test Pass");
		driver.navigate().back();
	}
}



