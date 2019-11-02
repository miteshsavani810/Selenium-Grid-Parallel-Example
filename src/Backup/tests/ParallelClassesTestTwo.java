package tests;

import org.testng.annotations.Test;


import framework.*;

public class ParallelClassesTestTwo extends Parent
{
 
    @Test
    public void testMethodOne() {
        myDriver().get("https://www.google.com");
        System.out.println(myDriver().getTitle());
    }
 
    @Test
    public void testMethodTwo() {
    	 myDriver().get("https://www.yahoo.com");
         System.out.println(myDriver().getTitle());
    }
    
}