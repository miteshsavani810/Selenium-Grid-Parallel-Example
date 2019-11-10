package testCases;

import org.testng.annotations.Test;


import framework.*;

public class test1 extends TestNG_Parent
{
 
    @Test
    public void testMethodOne() {
        driver.sGet("https://www.google.com");
        System.out.println(driver.sGetTitle());
    }
 
    @Test
    public void testMethodTwo() {
    	driver.sGet("https://www.google.com");
         System.out.println(driver.sGetTitle());
    }
    
    @Test
    public void testMethod2() {
    	driver.sGet("https://www.google.com");
         System.out.println(driver.sGetTitle());
    }
    
    @Test
    public void testMethod3() {
    	driver.sGet("https://www.google.com");
         System.out.println(driver.sGetTitle());
    }
    
    @Test
    public void testMethod4() {
    	driver.sGet("https://www.google.com");
         System.out.println(driver.sGetTitle());
    }
    
    @Test
    public void testMethod5() {
    	driver.sGet("https://www.google.com");
         System.out.println(driver.sGetTitle());
    }
    
}