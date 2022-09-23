package Listeners;
import org.testng.ITestContext; 
import org.testng.ITestListener; 
import org.testng.ITestResult;

public class Class_listerner implements ITestListener {
	
	
    public void onTestStart(ITestResult result) { 
        System.out.println("onTestStart>> ");
       }
//
//    public void onTestSuccess(ITestResult result) {
//        System.out.println("onTestSuccess>> ");
//       }
//
//    public void onTestFailure(ITestResult result) { 
//        System.out.println("onTestFailure >> ");
//       }
//
//    public void onTestSkipped(ITestResult result) { 
//        System.out.println("onTestSkipped>> ");
//       }

//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        System.out.println("onTestFailedButWithinSuccessPercentage>> ");
//       }
//	
//	    public void onStart(ITestContext context) {
//	        System.out.println("onStart>> ");
//	       }
//	
	    public void onFinish(ITestContext context) { 
	        System.out.println("onFinish>> ");
	       }
	 
		public void onTestSuccess(ITestResult result) {  
		System.out.println("Test case Success : "+result.getName());  
		}  
		  
		public void onTestFailure(ITestResult result) {  
		System.out.println("Test case Failure : "+result.getName());  
		}  
		  
		public void onTestSkipped(ITestResult result) {  
		System.out.println("Test case Skipped : "+result.getName());  
		}  
		  
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		System.out.println("Test case Failure : "+result.getName());  
		}    
		    
}
