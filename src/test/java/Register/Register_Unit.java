package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.Login;
import POM_Classes.Unit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Unit {

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
		driver.findElement(By.xpath("//a[text()='Unit']")).click(); // click on unit
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		String UnitURL = "http://dairyerp.eanifarm.com/unit_reg";
		soft.assertEquals(url, UnitURL);
		System.out.println("URL verified");
	}

	@Test(priority = 2)
	public void createUnit() throws InterruptedException {
		Unit u = new Unit(driver);
		u.enterMCCCode();
		u.enterUnitName();
		u.selectDate();
		u.selectAddress();
		u.selectLocation();
	}

	@Test(priority = 3)
	public void vendorInfo() throws InterruptedException {
		Unit u = new Unit(driver);
		u.scrollingPage();
		Thread.sleep(1000);
		u.vendorInfo();
	}

	@Test(priority = 4)
	public void clickOnClear() throws InterruptedException {
		Unit u = new Unit(driver);
		u.clickOnClear();
		WebElement clearOrNot = driver.findElement(By.xpath("//input[@placeholder='Enter MCC Code']"));
		String nu = clearOrNot.getText();
		System.out.println(nu.isBlank());
		System.out.println("All Data should be clear");
	}

	@Test(priority = 5, enabled = false)
	public void clickOnSave() throws InterruptedException {
		Unit u = new Unit(driver);
		u.clickOnSave();
	}
}
