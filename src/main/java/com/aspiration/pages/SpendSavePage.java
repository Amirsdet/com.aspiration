package com.aspiration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aspiration.base.BasePage;
import com.aspiration.utils.ElementUtil;

public class SpendSavePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By aspiration = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[1]/div[1]/span");
	By aspirationPlus = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[2]/div[1]/span");
	By yearlyPaid = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[2]/div[2]/p[2]");
	By monthlyPaid = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[2]/div[2]/p[1]");
	By autoImpactOpt = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[9]/div[1]/div[2]");
	By outOfNetOpt = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[10]/div[1]/div[2]");
	By autoOffsetOpt = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[9]/div[1]/div[2]");
	By purchaseInsuranceBy = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[11]/div[1]/div[2]");
	By autoOffsetOpt1 = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[9]/div[1]/div[3]/img");
	By outOfNetOpt1 = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[10]/div[1]/div[3]/img");
	By purchaseInsuranceOpt1 = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[11]/div[1]/div[3]/img");

	public SpendSavePage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;

	}

	// Operations

	public void verifyTitle() {
		elementUtil.doGetPageTitle();

	}

	public String doVerifyAspirationPlusPaidYearly() {
		return elementUtil.getElementText(yearlyPaid);
	}

	public String doVerifyAspirationPlusPaidMonthly() {
		return elementUtil.getElementText(monthlyPaid);
	}

	public Boolean doVerifyUncheckedOptionOneAspiration() {
		return elementUtil.doIsDisplayed(autoImpactOpt);
	}

	public Boolean doVerifyUncheckedOptionTwoAspiration() {
		return elementUtil.doIsDisplayed(outOfNetOpt);

	}

	public Boolean doVerifyUncheckedOptionThreeAspiration() {

		return elementUtil.doIsDisplayed(purchaseInsuranceBy);
	}

	public Boolean doVerifycheckedOptionOneAspirationPlus() {
		return elementUtil.doIsDisplayed(autoOffsetOpt1);

	}

	public Boolean doVerifycheckedOptionTwoAspirationPlus() {

		return elementUtil.doIsDisplayed(outOfNetOpt1);

	}

	public Boolean doVerifycheckedOptionThreeAspirationPlus() {

		return elementUtil.doIsDisplayed(purchaseInsuranceOpt1);

	}

}
