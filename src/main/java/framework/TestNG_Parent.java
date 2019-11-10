package framework;

import java.util.HashMap;
import java.util.Map;
import selenium.Browsers;
import selenium.action;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestNG_Parent extends top{
	
	
	public static action driver = new action();
		 
    @BeforeSuite
    public void beforeSuite() {
    	long threadId = Thread.currentThread().getId();
        //System.out.println("BeforeSuite Parent . Thread threadId is: " + threadId);
    }

    @Parameters({ "browser" })	
	@BeforeClass
    public void beforeClass(@Optional("firefox") String browser) {
        long threadId = Thread.currentThread().getId();
        
        //System.out.println("Beforeclass Parent . Thread threadId is: " + threadId);
        
        if (!webDriverHashMap.containsKey(threadId)) {
        	
        	WebDriver driver = new Browsers().getWebDriver(browser);
		    //System.out.println("Current Hm size : " + webDriverHashMap.size() + "and threadId is " + threadId);
		    webDriverHashMap.put(threadId, driver);
		    
		    
		    //System.out.println("Browser CLASSS for this Thread " + threadId + " is not present");
        } else {
        	//System.out.println(" Browser CLASSS This Thread " + threadId + " already initiat browser");
        }
    }
    
    @Parameters({ "browser" })
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser) {
        long threadId = Thread.currentThread().getId();
        //System.out.println("Beforemethod Parent. Thread threadId is: " + threadId);
        
        if (!webDriverHashMap.containsKey(threadId)) {
        	WebDriver driver = new Browsers().getWebDriver(browser);
		    webDriverHashMap.put(threadId, driver);
		    
		   // System.out.println("Browser METHOD for this Thread " + threadId + " is not present");
        } else {
        //	System.out.println(" Browser METHOD This Thread " + threadId + " already initiat browser" + webDriverHashMap.size());
        }
    }
	
	@AfterClass
    public void afterClass() {
        long threadId = Thread.currentThread().getId();
        //System.out.println("Afterclass  Parent . Thread threadId is: " + threadId);
        
    }
	
	@AfterSuite
    public void afterSuite() {
        long threadId = Thread.currentThread().getId();
        //System.out.println("AfterSuite  Parent . Thread threadId is: " + threadId);
        
        // iterate all map value and close all driver now
        //System.out.println(webDriverHashMap.size());
        for (Map.Entry<Long,WebDriver> entry : webDriverHashMap.entrySet())  {
            //System.out.println("Key = " + entry.getKey());
            entry.getValue().close();
        }
    }
	 

 
    @AfterMethod
    public void afterMethod() {
        long threadId = Thread.currentThread().getId();
        //System.out.println("Aftermethod Parent. Thread threadId is: " + threadId);
    } 
}
