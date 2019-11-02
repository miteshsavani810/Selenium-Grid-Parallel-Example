package TestNG.copy;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParallelClassesTestOne
{
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforeclass QQQQQQ . Thread id is: " + id);
    }
    
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforemethod QQQQQQ. Thread id is: " + id);
    }
 
    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("method QQQQQQ  11111. Thread id is: " + id);
    }
 
    @Test
    public void testMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("method QQQQQQ 22222. Thread id is: " + id);
    }
    
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Aftermethod QQQQQQ. Thread id is: " + id);
    }
 
    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Afterclass  QQQQQQ . Thread id is: " + id);
    }
}