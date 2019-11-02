package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {

	String driverPath = null;
	WebDriver driver = null;
	
	public Browsers() {
		driverPath = System.getProperty("user.dir") + "\\driverFiles\\";
	}
	
	public synchronized WebDriver getWebDriver() {
		return this.getWebDriver("");
	}

	public synchronized WebDriver getWebDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			driverPath += "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			break;
			
		default:
			driverPath += "geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			break;
		}

		return driver;
	}

}
