package Register;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driven {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7020614851");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("312687");
		driver.findElement(By.xpath("(//span[text()='Login'])[2]")).click();
		
			
	// to fetch only 1 item from excel
		FileInputStream file=new FileInputStream("Z:\\Daily Task\\Automation-Excel.xlsx");//excel path
		Sheet sheet =WorkbookFactory.create(file).getSheet("Sheet1"); //sheet name of excel
		String data=sheet.getRow(0).getCell(0).getStringCellValue();
		
		WebElement searchbox=driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchbox.sendKeys(data);
		WebElement searchbtn=driver.findElement(By.xpath("//button[@type='submit']"));
		searchbtn.click();
		Thread.sleep(3000);
		for(int i=0;i<data.length();i++)
		{
		searchbox.sendKeys(Keys.BACK_SPACE);
		}	
	   // to fetch all item from excel
		for(int j=0;j<4;j++)
		{
			String data1;
			try
			{
			data1=sheet.getRow(j).getCell(0).getStringCellValue();	
			}
			catch(Exception e)
			{
				data1=String.valueOf(sheet.getRow(j).getCell(0).getNumericCellValue());
			}
			
			Thread.sleep(2000);
			searchbox.sendKeys(data1);
			searchbtn.click();
			Thread.sleep(2000);
			for(int i=0;i<data.length();i++)
			{
				searchbox.sendKeys(Keys.BACK_SPACE);
			}		}			
		}	
}
