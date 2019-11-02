How parallelism work in Selenium

There is two type of parallelism 
    - Class vise
    - Method vise
    
What code need to change to achive parallelism

 1. We need to create one HASHMAP object (e.g. <threadID, WebDriver> ) to store webdriver object of each parallel thread.
 2. We need to create object of new webDriver if it is not created for current thread either at BeforeClass and BeforeMethod 
 	and put it into HASHMAP object.
 3. At test case level, We can access webdriver from HASHMAP by giving thread Id.
 4. We have to create a Parent class where we have to define HASHMAP object as Public static and BeforeClass, BeforeMethod functions and in
 	test file we have to extends Parent class so that all mentioned Anotation method get executed.
 
Code changes


=========================================== Parent Class =================================

class Parent {

public static HashMap<long, webDriver> hm = new HashMap<long, webDriver>();

@BeforeClass
public void methodName() {
	CreateBrowserInstanceIfNotExistForThread( Thread.currentThread().getId());
}

@BeforeMethod
public void methodName() {
	CreateBrowserInstanceIfNotExistForThread( Thread.currentThread().getId());
}

public WebDriver myDriver() {
	hm.get(Thread.currentThread().getId());
}

private void CreateBrowserInstanceIfNotExistForThread(threadID) {
	if(!hm.contains(threadId)) {
		WebDriver driver = new ChromeDriver();
		hm.put(driver);
	}
}


===================================================================================================================


======================================TestNG Test class ==================================================

class Test extends Parent{
	
	public void testcase1() {
		
		myDriver().get('<URL>');
	}
	
	public void testcase2() {
		
		myDriver().get('<URL>');
	}
	
	public void testcase3() {
		
		myDriver().get('<URL>');
	}
	

}

===================================================================================================================



============================================= testng.xml file Parellel by Methods ================================

<suite name="Test-method Suite" parallel="methods" thread-count="2" >
  <test name="Test-method test" group-by-instances="true">
    <classes>
      <class name="tests.test1" />
    </classes>
  </test>
==================================================================================================================


============================================= testng.xml file Parellel by Class ================================

<suite name="Test-method Suite" parallel="classes" thread-count="2" >
  <test name="Test-method test" group-by-instances="true">
    <classes>
      <class name="tests.test1" />
      <class name="tests.test2" />
      <class name="tests.test3" />
    </classes>
  </test>
==================================================================================================================