package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrations {

WebDriver driver;

	@FindBy (xpath="//span[@class='ng-binding']")
	private WebElement register;

	@FindBy (xpath="//a[text()='Department']")
	private WebElement Department;
	
	@FindBy (xpath="//a[@href=\"designation_reg\"]")
	private WebElement Designation;
	
	@FindBy (xpath="//a[@href=\"unit_reg\"]")
	private WebElement unit;

	public Registrations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnRegister() throws InterruptedException
	{
		Thread.sleep(2000);
	    register.click();
	}
	
	public void clickDepartment() throws InterruptedException 
	{
		Thread.sleep(2000);
		Department.click();
	}
	
	public void clickOnDesignation() throws InterruptedException
	{
		Thread.sleep(2000);
		Designation.click();
	}
	
	public void clickOnUnit() throws InterruptedException
	{
		Thread.sleep(3000);
		unit.click();
	}
}
