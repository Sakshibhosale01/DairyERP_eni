package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Unit {
	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder=\"Enter MCC Code\"]")
	private WebElement MCCcode;

	@FindBy(xpath = "//input[@placeholder=\"Enter Unit Name\"]")
	private WebElement UnitName;

	@FindBy(xpath = "//button[@class='ui-datepicker-trigger']")
	private WebElement date;

	@FindBy(xpath = "//input[@placeholder=\"Enter Unit Location\"]")
	private WebElement unitLocation;

	@FindBy(xpath = "//input[@placeholder='Enter Vendor Name']")
	private WebElement VendorName;

	@FindBy(xpath = "//input[@placeholder='Enter Contact no.']")
	private WebElement contactNo;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clear;

	public Unit(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterMCCCode() throws InterruptedException {
		Thread.sleep(1000);
		MCCcode.click();
		MCCcode.sendKeys("XYZ");
	}

	public void enterUnitName() throws InterruptedException {
		Thread.sleep(1000);
		UnitName.click();
		UnitName.sendKeys("Jay Ganga Dairy Alibag");
	}

	public void selectDate() throws InterruptedException {
		Thread.sleep(2000);
		date.click();
		WebElement listYear = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		listYear.click();
		Select Sele_year = new Select(listYear);
		Sele_year.selectByVisibleText("2010");

		WebElement listMonth = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		listMonth.click();
		Select Sele_month = new Select(listMonth);
		Sele_month.selectByVisibleText("Apr");

		WebElement date = driver.findElement(By.xpath("//a[@class=\"ui-state-default\"]"));// a[text()='12']
		date.click();
	}

	public void selectAddress() throws InterruptedException {
		Thread.sleep(1000);
		WebElement state = driver.findElement(By.name("state"));
		Select State = new Select(state);
		State.selectByIndex(3);

		Thread.sleep(1000);
		WebElement district = driver.findElement(By.name("district"));
		Select Dist = new Select(district);
		Dist.selectByIndex(5);

		Thread.sleep(1000);
		WebElement taluka = driver.findElement(By.name("taluka"));
		Select Tal = new Select(taluka);
		Tal.selectByIndex(5);

		Thread.sleep(1000);
		WebElement village = driver.findElement(By.name("village"));
		Select Village = new Select(village);
		Village.selectByIndex(5);
	}

	public void selectLocation() throws InterruptedException {
		Thread.sleep(1000);
		unitLocation.click();
		Thread.sleep(1000);
		unitLocation.sendKeys("Georai , Ankota");
	}

	public void scrollingPage() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView()", VendorName);
		// "arguments[0].scrollIntoView()", window.scrollBy(0,500)
//		Actions act=new Actions(driver);
//		act.scrollToElement(VendorName);
	}

	public void vendorInfo() throws InterruptedException {
		Thread.sleep(2000);
		VendorName.click();
		VendorName.sendKeys("Mohan");
		Thread.sleep(1000);
		contactNo.click();
		contactNo.sendKeys("4455667788");
	}

	public void clickOnClear() throws InterruptedException {
		Thread.sleep(2000);
		clear.click();
	}

	public void clickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		save.click();
	}

}
