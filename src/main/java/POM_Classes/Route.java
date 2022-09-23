package POM_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Route {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Enter Route Code']")
	private WebElement RouteCode;

	@FindBy(xpath = "//input[@placeholder='Enter Route Name']")
	private WebElement RouteName;

	@FindBy(xpath = "//div[@class='selectize-input']")
	private WebElement SelectUnit;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement UnitName;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//span[text()='Close']")
	private WebElement close;

	public Route(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterRouteCode() throws InterruptedException {
		Thread.sleep(2000);
		RouteCode.click();
		RouteCode.sendKeys("057");
		Thread.sleep(1000);
	}

	public void enterRouteName() throws InterruptedException {
		RouteName.click();
		RouteName.sendKeys("pune-banglore");
		Thread.sleep(1000);
	}

	public void selectUnit() throws InterruptedException {
		SelectUnit.click();
		// Thread.sleep(2000);
		// WebElement list=driver.findElement(By.xpath("//input[@placeholder='Select or
		// search Unit']"));
		// Select s=new Select(list);
		// Thread.sleep(1000);
		// System.out.println(s.getOptions());
		// s.deselectByVisibleText("003-STPL Unit 3");
		Thread.sleep(3000);
		// list.click();
		driver.findElement(By.xpath("//span[text()='003-STPL Unit 3']")).click();
		SelectUnit.click();
		driver.findElement(By.xpath("//span[text()='004-STPL Unit 4']")).click();
		SelectUnit.click();
		driver.findElement(By.xpath("//span[text()='005-STPL Unit 5']")).click();
		// UnitName.sendKeys("003-STPL Unit 3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-success px-2 mr-2']")).click();      //add button 
	}

	public void save() throws InterruptedException {
		Thread.sleep(2000);
		save.click();
	}

	public void close() throws InterruptedException {
		Thread.sleep(2000);
		close.click();
	}
}
