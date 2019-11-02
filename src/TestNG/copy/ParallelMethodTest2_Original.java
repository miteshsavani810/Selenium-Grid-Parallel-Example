package TestNG.copy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class ParallelMethodTest2_Original extends Parent
{
	
	@BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforeclass EEEEEE . Thread id is: " + id);
    }
	
	@AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Afterclass  EEEEEE . Thread id is: " + id);
    }
	 
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Beforemethod EEEEE. Thread id is: " + id);
    }
 
    @Test
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 111111111. Thread id is: " + id);
    }
 
    @Test
    public void testMethods3() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 22222. Thread id is: " + id);
    }
    
    @Test
    public void testMethods4() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 33333. Thread id is: " + id);
    }
    
    @Test
    public void testMethods5() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 444444. Thread id is: " + id);
    }
    
    @Test
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 555555. Thread id is: " + id);
    }
 
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Aftermethod EEEEE. Thread id is: " + id);
    }
}