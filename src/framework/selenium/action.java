package framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.top;


public class action extends top{
	
	/*
	 * sType(locator)
	 * sSelectOption(locator, optionName)
	 * sClick(locator)
	 * sDoubleClick(locator)
	 * sGetClass(locator)
	 * sGetCurrentURL()
	 * sGetPageSource()
	 * sGetTitle()
	 * sGetText()
	 * sGetAttribute()
	 * sSendKeys(locator, keys)
	 * sSubmit()
	 * sSwitchToFrameByName(frameName)
	 * sSwitchToFrameById(frameId)
	 * sSwitchToFrameByLocator(locator)
	 * sSwitchToMainWindow()
	 * sIsElementEnable()
	 * sIsElementVisible()
	 * sWaitUntilElementVisible(Element)
	 * sFindElement(locator)
	 * 
	 *  */
	
	public void sGet(String url) {
		myDriver().get(url);
	}
	
	public String sGetTitle() {
		return myDriver().getTitle();
	}
	
	public String sGetPageSource() {
		return myDriver().getPageSource();
	}
	
	public String sGetCurrentPageURL() {
		return myDriver().getCurrentUrl();
	}
	
	public void sType(String locator, String text) {
		sFindElement(locator).sendKeys(text);
	}
	
public void sClick(String locator) {
	sFindElement(locator).click();
	}

public void sIsEnable(String locator) {
	sFindElement(locator).isEnabled();
}

public void sIsDisplay(String locator) {
	sFindElement(locator).isDisplayed();
}

private WebElement sFindElement(String locator) {
	
	WebElement webElement = null;
	String locatorValue = "";
	if (locator.indexOf("id=") > 0) {
		locatorValue = locator.replace("id=", "");
		webElement = myDriver().findElement(By.id(locatorValue));
	} else if (locator.indexOf("class=") > 0) {
		locatorValue = locator.replace("class=", "");
		webElement = myDriver().findElement(By.className(locatorValue));
	} else {
		locatorValue = locator.replace("xpath=", "");
		webElement = myDriver().findElement(By.xpath(locatorValue));
	}
	
	return webElement;		
}


public WebDriver myDriver() {
	return webDriverHashMap.get(Thread.currentThread().getId());
}
	
	

}
