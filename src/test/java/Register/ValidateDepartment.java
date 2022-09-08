package Register;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.Login;
import POM_Classes.Registrations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateDepartment {

	WebDriver driver;
	SoftAssert soft = new SoftAssert();

	@BeforeClass
	public void demo1() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test(priority = -2)
	public void Login_Page() throws InterruptedException {
		Thread.sleep(4000);
		Login l = new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
		Thread.sleep(4000);
	}

	@Test(priority = -1)
	public void Register() throws InterruptedException {
		Thread.sleep(5000);
		Registrations f = new Registrations(driver);
		f.clickOnRegister();
		f.clickDepartment();
	}

	@Test(priority = 0)
	public void enterDepaName() throws InterruptedException {
		Thread.sleep(3000);
		WebElement departmentName = driver.findElement(By.name("departmentName"));
		departmentName.click();
		departmentName.sendKeys("Seller");
	}

	@Test(priority = 1)
	public void enterDescriptionOfDepa() throws InterruptedException {
		Thread.sleep(2000);
		WebElement Description = driver.findElement(By.name("DepartmentDescription"));
		Description.click();
		Description.sendKeys("Taking milk from Units and provide to local areas");
	}

	@Test(priority = 2)
	public void clickOnSave() throws InterruptedException {
		// driver.findElement(By.xpath("//button[@class='btn btnS
		// btn-warning']")).click(); //Clear
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // Save
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void VerifyDataSubmit() throws InterruptedException {
		Thread.sleep(1000);
		WebElement AllreadyExist = driver.findElement(By.xpath("//p[text()='Department Already Exists']"));
		String AllreadyDataSaved = AllreadyExist.getText();
		soft.assertEquals(AllreadyDataSaved, "Department Registered Successfully'");
		System.out.println("Department Allready Exist");
		/*
		 * Thread.sleep(1000); WebElement savedNoti=driver.findElement(By.
		 * xpath("//p[text()='Department Registered Successfully']")); String
		 * SaveNotiText=savedNoti.getText(); soft.assertEquals(SaveNotiText,
		 * "Department Registered Successfully");
		 * System.out.println("Department Registered Successfully");
		 */
		WebElement close = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-danger btnS']"));
		close.click();

	}

	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
