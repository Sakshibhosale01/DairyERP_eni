package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Farmer {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder=\"Enter first name\"]")
	private WebElement FirstName;

	@FindBy(xpath = "//input[@placeholder=\"Enter last name\"]")
	private WebElement LastName;

	@FindBy(xpath = "//input[@placeholder=\"Enter Mobile 1\"]")
	private WebElement MobileNo;

	@FindBy(xpath = "//button[@class='ui-datepicker-trigger']")
	private WebElement date;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clear;

	public Farmer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterFarmerInfo() throws InterruptedException {
		Thread.sleep(1000);
		FirstName.click();
		FirstName.sendKeys("jay");
		Thread.sleep(1000);
		LastName.click();
		LastName.sendKeys("Jadhav");
		Thread.sleep(1000);
		MobileNo.click();
		MobileNo.sendKeys("5656565656");
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

	public void clickOnClear() throws InterruptedException {
		Thread.sleep(2000);
		clear.click();
	}

	public void clickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		save.click();
	}
}
