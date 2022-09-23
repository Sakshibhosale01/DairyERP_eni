package Register;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	WebDriver driver;

	
	public void demo() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dairyerp.eanifarm.com/dashboard");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Login l = new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class=\"ng-binding\"]")).click(); // Click on register
		Thread.sleep(2000);
	}

	public void demo1() throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("Z:\\Daily Task\\Automation-Excel.xlsx"); // excel path
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1"); // sheet name of excel
		String data = sheet.getRow(0).getCell(0).getStringCellValue();
        
	}
}
