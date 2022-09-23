package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Animal {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder=\"Enter Name\"]")
	private WebElement Name;

	@FindBy(xpath = "//input[@ng-model=\"frm.EntryDate\"]")
	private WebElement date;
	
	@FindBy(xpath = "//input[@placeholder=\"DOB\"]")
	private WebElement dateOfBirth;
	
	public Animal(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
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
		
		Thread.sleep(2000);
	}
	
	public void buffaloInfo() {
		WebElement species = driver.findElement(By.name("specie"));
		Select Spe = new Select(species);
		Spe.selectByIndex(2);
		
		WebElement breed = driver.findElement(By.name("breed"));
		Select Breed= new Select(breed);
		Breed.selectByIndex(4);
		
		WebElement stage = driver.findElement(By.name("stage"));
		Select Stage= new Select(stage);
		Stage.selectByIndex(4);
	}
	
	public void enterName() {
		Name.click();
		Name.sendKeys("saguna");
	}
	
	public void selectEntryDate() throws InterruptedException {
		Thread.sleep(2000);
		date.click();
		WebElement listYear = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		listYear.click();
		Select Sele_year = new Select(listYear);
		Sele_year.selectByVisibleText("2000");

		WebElement listMonth = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		listMonth.click();
		Select Sele_month = new Select(listMonth);
		Sele_month.selectByVisibleText("Apr");

		WebElement date = driver.findElement(By.xpath("//a[@class=\"ui-state-default\"]"));// a[text()='12']
		date.click();
	}

	public void selectDOB() throws InterruptedException {
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
	
	
}






