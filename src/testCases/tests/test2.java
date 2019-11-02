package testCases.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
 
import framework.*;

public class test2 extends TestNG_Parent
{
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public void commonMethod(long threadID) {
		
		driver.sGet(baseUrl);
	      String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = driver.sGetTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
	}
	
    @Test
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 111111111. Thread id is: " + id);
        this.commonMethod(id);
    }
 
    @Test
    public void testMethods3() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 22222. Thread id is: " + id);
        this.commonMethod(id);
    }
    
    @Test
    public void testMethods4() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 33333. Thread id is: " + id);
        this.commonMethod(id);
    }
    
    @Test
    public void testMethods5() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 444444. Thread id is: " + id);
        this.commonMethod(id);
    }
    
    @Test
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("method EEEEE 555555. Thread id is: " + id);
        this.commonMethod(id);
    }
 
}