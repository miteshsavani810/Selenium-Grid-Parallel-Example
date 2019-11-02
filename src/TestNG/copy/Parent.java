package TestNG.copy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parent {
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
    }

 
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Aftermethod Parent. Thread id is: " + id);
    }
}
