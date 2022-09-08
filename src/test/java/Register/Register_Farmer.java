package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.Farmer;
import POM_Classes.Login;
import POM_Classes.Unit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Farmer {

	WebDriver driver;
	SoftAssert soft = new SoftAssert();

	@BeforeClass
	public void demo1() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void Login_Page() throws InterruptedException {
		Thread.sleep(3000);
		Login l = new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void verifylink() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class=\"ng-binding\"]")).click(); // Click on register
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Farmer']")).click(); // click on farmer
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		String UserURL = "http://dairyerp.eanifarm.com/farmer_reg";
		soft.assertEquals(url, UserURL);
		System.out.println("URL verified");
	}

	@Test(priority = 2)
	public void enterFarmerDetails() throws InterruptedException {
		Farmer f = new Farmer(driver);
		f.enterFarmerInfo();
		f.selectDate();
		f.selectAddress();
	}

	@Test(priority = 3)
	public void clickOnClear() throws InterruptedException {
		Farmer f = new Farmer(driver);
		f.clickOnClear();
		WebElement clearOrNot = driver.findElement(By.xpath("//input[@placeholder=\"Enter first name\"]"));
		String name = clearOrNot.getText();
		System.out.println(name.isBlank());
		System.out.println("All Data should be clear");
	}

	@Test(priority = 4, enabled = false)
	public void clickonSave() throws InterruptedException {
		Farmer f = new Farmer(driver);
		f.clickOnSave();
	}
}
