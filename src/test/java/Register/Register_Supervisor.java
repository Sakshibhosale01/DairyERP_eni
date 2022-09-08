package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.Login;
import POM_Classes.Supervisor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Supervisor {

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
		driver.findElement(By.xpath("//a[text()='User']")).click(); // click on user
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		String UserURL = "http://dairyerp.eanifarm.com/user_reg";
		soft.assertEquals(url, UserURL);
		System.out.println("URL verified");
	}

	@Test(priority = 2)
	public void selectUnit() throws InterruptedException {
		Supervisor s = new Supervisor(driver);
		s.enterName();
		s.selectAddress();
		s.unitDetails();
		s.UsernameAndpassword();
	}

}
