package com.aspiration.junit.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aspiration.base.BasePage;
import com.aspiration.base.ConfigReader;
import com.aspiration.pages.HomePage;
import com.aspiration.pages.SpendSavePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpendSavePageTest {
	WebDriver driver;
	BasePage basePage;
	SpendSavePage spendSavePage;
	HomePage homePage;

	By yearlyPaid = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[2]/div[2]/p[2]");
	By monthlyPaid = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/div[1]/div[2]/div[2]/p[1]");
	By autoImpactOpt = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[9]/div[1]/div[2]");
	By outOfNetOpt = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[10]/div[1]/div[2]");
	By autoOffsetOpt = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[9]/div[1]/div[2]");
	By purchaseInsuranceBy = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[11]/div[1]/div[2]");
	By autoOffsetOpt1 = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[9]/div[1]/div[3]/img");
	By outOfNetOpt1 = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[10]/div[1]/div[3]/img");
	By purchaseInsuranceOpt1 = By.xpath("//*[@id=\"__next\"]/div/section[7]/div/div[1]/ul/li[11]/div[1]/div[3]/img");

	@Before
	public void setUp() {

		basePage = new BasePage();
		driver = basePage.init_Driver();
		driver.get(ConfigReader.getProperty("url1"));
		spendSavePage = new SpendSavePage(driver);

	}

	@Test

	public void A_verifyTitleTest() {

		String ecpectedURL = "https://www.aspiration.com/spendandsave";
		String actualURL = ConfigReader.getProperty("url1");
		Assert.assertEquals("url of spendandsave ", ecpectedURL, actualURL);

	}

	@Test

	public void B_doVerifyAspirationPlusPaidYearlyTest() {
		String expectedPriceYearly = "$5.99/mo if you pay annually";
		String actualPriceYearly = spendSavePage.doVerifyAspirationPlusPaidYearly();
		Assert.assertEquals("User redirected to signup page ", expectedPriceYearly, actualPriceYearly);

	}

	@Test
	public void C_doVerifyAspirationPlusPaidMonthlyTest() {
		String expectedPriceMonthly = "$7.99/mo";
		String actualPriceYearly = spendSavePage.doVerifyAspirationPlusPaidMonthly();
		Assert.assertEquals("User redirected to signup page ", expectedPriceMonthly, actualPriceYearly);

	}

	@Test
	public void D_doVerifyUncheckedOptionOneAspiration() {
		boolean expectedUncheck = true;
		boolean actualUnCheck = spendSavePage.doVerifyUncheckedOptionOneAspiration();
		Assert.assertEquals(expectedUncheck, actualUnCheck);

	}

	@Test
	public void E_doVerifyUncheckedOptionTwoAspiration() {
		boolean expectedUncheck = true;
		boolean actualUnCheck = spendSavePage.doVerifyUncheckedOptionTwoAspiration();
		Assert.assertEquals(expectedUncheck, actualUnCheck);
	}

	@Test
	public void F_doVerifyUncheckedOptionThreeAspiration() {
		boolean expectedUncheck = true;
		boolean actualUnCheck = spendSavePage.doVerifyUncheckedOptionThreeAspiration();
		Assert.assertEquals(expectedUncheck, actualUnCheck);
	}

	@Test
	public void G_doVerifycheckedOptionOneAspirationPlus() {
		boolean expectedchecked = true;
		boolean actualChecked = spendSavePage.doVerifycheckedOptionOneAspirationPlus();
		Assert.assertEquals(expectedchecked, actualChecked);

	}

	@Test
	public void H_doVerifycheckedOptionTwoAspirationPlus() {
		boolean expectedchecked = true;
		boolean actualChecked = spendSavePage.doVerifycheckedOptionTwoAspirationPlus();
		Assert.assertEquals(expectedchecked, actualChecked);

	}

	@Test
	public void I_doVerifycheckedOptionThreeAspirationPlus() {
		boolean expectedchecked = true;
		boolean actualChecked = spendSavePage.doVerifycheckedOptionThreeAspirationPlus();
		Assert.assertEquals(expectedchecked, actualChecked);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}