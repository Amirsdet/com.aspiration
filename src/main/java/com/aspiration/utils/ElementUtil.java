package com.aspiration.utils;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties prop;

	// Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jsUtil = new JavaScriptUtil(driver);
	}

	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}

	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;

	}

	public String doGetPageUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting URL...");
		}
		return null;
	}

	/**
	 * @author
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (true) {
				jsUtil.flash(element);
			}
		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element...");
		}
		return element;
	}

	public String getElementText(By locator) {

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (true) {
				jsUtil.flash(element);
			}

		} catch (Exception e) {
			System.out.println("some exception got occured while geting texy element...");
		}
		return element.getText();
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(locator);

		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element..." + locator);
		}
		return elements;
	}

	/**
	 * this method is used to click the weblement on the basis of By locator
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element...");
		}

	}

	/**
	 * this method is used to send value in a field
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {

		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occured while entering values in a field...");
		}
	}

	/**
	 * isDisplayed
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;

	}

	/**
	 * isEnabled
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsEnabled(By locator) {
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;

	}

	/**
	 * isSeelcted
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsSelected(By locator) {
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;

	}

	/**
	 * Gettext
	 * 
	 * @param locator
	 * @return
	 */

	/**
	 * Fluent wait
	 */
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting text...");
		}
		return null;
	}

	public static WebElement FluentWait(WebDriver driver, By locatorBy, long timeOut) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchFieldException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locatorBy);
			}

		});
		return element;
	}

}
