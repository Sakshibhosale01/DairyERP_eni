package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

	WebDriver driver;
	
	@FindBy (xpath="//input[@placeholder='Enter code/ name/ mobile 1']")
	private WebElement EnterName;
	
	@FindBy (xpath="//button[@class='btn ml-2 btnS btnSearch']")
	private WebElement search;
	
	public Search(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void enterInput() throws InterruptedException
	{
		Thread.sleep(2000);
		EnterName.sendKeys("Jan mat sansta");
	}
	
	public void ClickOnsearchBTN() throws InterruptedException
	{
		Thread.sleep(2000);
		search.click();
	}
	
	
}
