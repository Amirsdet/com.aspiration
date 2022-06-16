package com.aspiration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aspiration.base.BasePage;
import com.aspiration.utils.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By spendSave = By.xpath("//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a");
	By welcomeMsg = By.xpath("/html/body/div[4]/div/div/div/div[2]/h5");
	By getSarted = By.xpath("//*[@id=\"__next\"]/div/header/ul[2]/li[2]/button");

//spend&save page locators
	By aspiration = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[1]/div[1]/span");
	By aspirationPlus = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[2]/div[1]/span");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

// Operations
	/*
	 * Verify that as a user, they can view our products and prices by navigating
	 * from the home page to our products page via the “Spend & Save” link at the
	 * top of the home page
	 */
	public String doVerifyTitle() {
		return elementUtil.doGetPageTitle();
	}

	public void doClickSpendSave() {
		elementUtil.doClick(spendSave);

	}

	public String doRedirectToSpendAndSavePage() {

		return elementUtil.doGetPageUrl();// getting the url of spend & save page

	}

	public void doClickGetStarted() {
		elementUtil.doClick(getSarted);

	}

	public String doRedirectToSignupPage() {
		doClickGetStarted();
		return ElementUtil.FluentWait(driver, By.xpath("/html/body/div[4]/div/div/div/div[2]/h5"), 30).getText();

	}

	public boolean AspirationPlus() {
		return elementUtil.doIsDisplayed(aspirationPlus);

	}

	public boolean Aspiration() {
		return elementUtil.doIsDisplayed(aspiration);

	}

}
