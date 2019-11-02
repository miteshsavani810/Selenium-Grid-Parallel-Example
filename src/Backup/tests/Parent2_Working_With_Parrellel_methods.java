package orgn;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parent2_Working_With_Parrellel_methods {
	
	//public WebDriver driver = null;
	//public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public HashMap<Long,WebDriver> hm=new HashMap<Long,WebDriver>();   
	
	@BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforeclass Parent . Thread id is: " + id);
    }
	
	@AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Afterclass  Parent . Thread id is: " + id);
    }
	 
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforemethod Parent. Thread id is: " + id);
        String driverPath = "C:\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
	    WebDriver driver = new FirefoxDriver();
	    hm.put(id, driver);
    }

 
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Aftermethod Parent. Thread id is: " + id);
        hm.get(id).close();
    }
}
