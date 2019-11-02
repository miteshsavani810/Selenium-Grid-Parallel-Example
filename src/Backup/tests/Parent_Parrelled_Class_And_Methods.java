package orgn;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Parent_Parrelled_Class_And_Methods {
	
	//public WebDriver driver = null;
	//public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public static HashMap<Long,WebDriver> hm = new HashMap<Long,WebDriver>();	
	
	public Parent() {
//		if (hm == null) {
//		//hm = new HashMap<Long,WebDriver>();
//		System.out.println("hm is Null");
//		} else {
//			System.out.println("hm is not NULLLL");
//		}
	}
	 
    @BeforeSuite
    public void beforeSuite() {
    	long id = Thread.currentThread().getId();
        System.out.println("BeforeSuite Parent . Thread id is: " + id);
    	//hm = new HashMap<Long,WebDriver>();   
    }

	
	@BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforeclass Parent . Thread id is: " + id);
        
        if (!hm.containsKey(id)) {
	        String driverPath = "C:\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
		    WebDriver driver = new FirefoxDriver();
		    System.out.println("Current Hm size : " + hm.size() + "and id is " + id);
		    hm.put(id, driver);
		    System.out.println("After adding Hm size : " + hm.size());
		    
		    System.out.println("Browser CLASSS for this Thread " + id + " is not present");
        } else {
        	System.out.println(" Browser CLASSS This Thread " + id + " already initiat browser");
        }
    }
	
	@AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Afterclass  Parent . Thread id is: " + id);
        
        // iterate all map value and close all driver now
        
//        for (Map.Entry<Long,WebDriver> entry : hm.entrySet())  {
//            System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue());
//            entry.getValue().close();
//        }
    }
	
	@AfterSuite
    public void afterSuite() {
        long id = Thread.currentThread().getId();
        System.out.println("AfterSuite  Parent . Thread id is: " + id);
        
        // iterate all map value and close all driver now
        System.out.println(hm.size());
        for (Map.Entry<Long,WebDriver> entry : hm.entrySet())  {
            System.out.println("Key = " + entry.getKey());
            entry.getValue().close();
        }
    }
	 
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforemethod Parent. Thread id is: " + id);
        if (!hm.containsKey(id)) {
	        String driverPath = "C:\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
		    WebDriver driver = new FirefoxDriver();
		    hm.put(id, driver);
		    
		    System.out.println("Browser METHOD for this Thread " + id + " is not present");
        } else {
        	System.out.println(" Browser METHOD This Thread " + id + " already initiat browser" + hm.size());
        }
    }

 
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Aftermethod Parent. Thread id is: " + id);
        //hm.get(id).close();
    }
    
    public WebDriver myDriver() {
    	return hm.get(Thread.currentThread().getId());
    }
}
