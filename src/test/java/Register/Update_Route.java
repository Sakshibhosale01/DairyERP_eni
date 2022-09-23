package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.Login;
import POM_Classes.Route;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_Route {

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
		driver.findElement(By.xpath("//span[@class=\"ng-binding\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Route']")).click(); // click on route
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		String RouteURL = "http://dairyerp.eanifarm.com/route_reg";
		soft.assertEquals(url, RouteURL);
		System.out.println("URL verified");
	}

	@Test(priority = 2)
	public void createRoute() throws InterruptedException {
		Route r = new Route(driver);
		r.enterRouteCode();
		r.enterRouteName();
		r.selectUnit();
		r.save();
		r.close();
	}

	@Test(priority = 3)
	public void verifySave() {
		WebElement ele = driver.findElement(By.xpath("//td[@title='pune-karad']"));
		String eleText = ele.getText();
		soft.assertEquals(eleText, "pune-karad");
		System.out.println("Allready Exist");
	}

}
