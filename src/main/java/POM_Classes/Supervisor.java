package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Supervisor {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder=\"Enter first name\"]")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@placeholder=\"Enter last name\"]")
	private WebElement LastName;

	@FindBy(xpath = "//input[@placeholder=\"Enter Mobile 1\"]")
	private WebElement MobileNo;

	@FindBy(xpath = "//input[@placeholder=\"Enter user name\"]")
	private WebElement Username;

	@FindBy(xpath = "//input[@ng-model=\"frm.Password\"]")
	private WebElement Password;

	public Supervisor(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterName() throws InterruptedException {
		FirstName.click();
		FirstName.sendKeys("Raya");
		Thread.sleep(1000);
		LastName.click();
		LastName.sendKeys("Shirke");
		Thread.sleep(1000);
		MobileNo.click();
		MobileNo.sendKeys("5252525252");
	}

	public void selectAddress() throws InterruptedException {
		Thread.sleep(1000);
		WebElement state = driver.findElement(By.name("state"));
		Select State = new Select(state);
		State.selectByIndex(3);

		Thread.sleep(1000);
		WebElement district = driver.findElement(By.name("district"));
		Select Dist = new Select(district);
		Dist.selectByIndex(2);

		Thread.sleep(1000);
		WebElement taluka = driver.findElement(By.name("taluka"));
		Select Tal = new Select(taluka);
		Tal.selectByIndex(4);

		Thread.sleep(1000);
		WebElement village = driver.findElement(By.name("village"));
		Select Village = new Select(village);
		Village.selectByIndex(3);
	}

	public void scrollingPage() throws InterruptedException {
		Thread.sleep(2000);
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].scrollIntoView()", Username);
//		jsExecutor.executeScript("arguments[0].scrollIntoView().window.scrollBy(0,500)");
//		Actions act=new Actions(driver);
//		act.scrollToElement(Username);
		Actions a = new Actions(driver);
		//scrolling down a page
	     a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	}

	public void unitDetails() throws InterruptedException {
		// SelectUnit
		WebElement unitList = driver.findElement(By.xpath("//input[@placeholder=\"Select or search Unit\"]"));
		unitList.click();
		unitList.sendKeys("003-STPL Unit 3");
		Thread.sleep(2000);

		// select Department
		WebElement Dep = driver.findElement(By.xpath("//select[@ng-model=\"frm.Dept\"]"));
		Select s = new Select(Dep);
		s.selectByIndex(3);

		// select Designation
//		WebElement Desi=driver.findElement(By.xpath("//select[@ng-model=\"frm.Designation\"]"));
//		Select p=new Select(Desi);
//		p.selectByIndex(1);
	}

	public void UsernameAndpassword() {
		Username.click();
		Username.sendKeys("ABCD");
		Password.click();
		Password.sendKeys("1234");
	}
}
