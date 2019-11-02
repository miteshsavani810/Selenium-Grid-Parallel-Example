package TestNG.copy;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParallelClassesTestTwo
{
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforeclass WWWWWW. Thread id is: " + id);
    }
    
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforemethod WWWWW. Thread id is: " + id);
    }
 
    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("method  WWWWWW 11111111. Thread id is: " + id);
    }
 
    @Test
    public void testMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("method WWWWWW 22222222. Thread id is: " + id);
    }
    
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Aftermethod WWWWWW. Thread id is: " + id);
    }
 
    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Afterclass  WWWWWW . Thread id is: " + id);
    }
}