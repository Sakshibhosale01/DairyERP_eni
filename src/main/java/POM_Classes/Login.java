package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement Username;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement Password;

	@FindBy (xpath="//button[@type='submit']")
	private WebElement submit;
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void enterUsername() throws InterruptedException
	{
	    Username.click();
	    Username.sendKeys("stpl");
	    Thread.sleep(1000);
	}
	
	public void enterPassword() throws InterruptedException
	{
		Password.click();
		Password.sendKeys("stpl");
		  Thread.sleep(1000);
	}
	
	public void clickOnSubmit() throws InterruptedException
	{
		submit.click();
		  Thread.sleep(1000);
	}
}
