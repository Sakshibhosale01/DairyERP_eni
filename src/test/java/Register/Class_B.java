package Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import Base_Class.BaseClass1;
import Base_Class.Class2;
import Listeners.Class_listerner;
import POM_Classes.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class_B extends Class_listerner{

	WebDriver driver;
	
	@Test()
	public void Login_Page() throws InterruptedException
	{
		Class2 B= new Class2();
	    B.launchapp("chrome");
		B.launchapp("ie");
		B.launchapp("firefox");
		Login l= new Login(driver);
		l.enterUsername();
		l.enterPassword();
		l.clickOnSubmit();
	}
	//html/body/div[1]/div/div/div/div[1]/div[3]/div[1]/button/div/span

/*	
	public class DP
	{
	    @DataProvider (name = "data-provider")
	     public Object[][] dpMethod(){
		 return new Object[][] {{"FirstName"}, {"LastName"}};
	     }
		
	    @Test (dataProvider = "data-provider")
	    public void myTest (String val) {
	        System.out.println("Passed Parameter Is : " + val);
	    }
	}*/
}