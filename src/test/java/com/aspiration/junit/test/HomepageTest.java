package com.aspiration.junit.test;

import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.aspiration.base.BasePage;
import com.aspiration.base.ConfigReader;
import com.aspiration.pages.HomePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomepageTest {

	WebDriver driver;
	BasePage basePage;
	Properties pros;
	HomePage homePage;

	@Before
	public void setUp() {

		basePage = new BasePage();
		driver = basePage.init_Driver();
		homePage = new HomePage(driver);
		ConfigReader.setProperty("url", "https://www.aspiration.com/");
	}

	@Test

	public void A_doVerifyTitleTest() {
		String expectedTitle = "Green Banking Alternative: Save Money & The Planet | Aspiration";
		String actualtitle = homePage.doVerifyTitle();
		org.junit.Assert.assertEquals(expectedTitle, actualtitle);

	}

	@Test
	public void B_doClickSpendSaveTest() {

		homePage.doClickSpendSave();
		// Verify the ink of the page spend&save
		String spendAndSaveActualURL = homePage.doRedirectToSpendAndSavePage();
		String spendAndExpectedURL = "https://www.aspiration.com/spendandsave";
		Assert.assertEquals("User redirected to spend&Save page ", spendAndExpectedURL, spendAndSaveActualURL);

	}

	@Test

	public void C_aspirationCardIsDisplayed() throws Exception {
		B_doClickSpendSaveTest();
		Assert.assertTrue("Asspiration card is displayed", homePage.Aspiration());
		Thread.sleep(5000);
	}

	@Test

	public void D_aspirationCardPlusIsDisplayed() {
		B_doClickSpendSaveTest();
		Assert.assertTrue("Asspiration card plus is displayed", homePage.AspirationPlus());
	}

	@Test
	public void E_doClickGetStarted() {
		homePage.doClickGetStarted();

	}

	@Test
	public void F_welcomeMsgIsDisplayedTest() {
		E_doClickGetStarted();
		String ExpectedWelcomeMsg = "Enter your email to get started";
		String actualWelcomeMsg = homePage.doRedirectToSignupPage();
		Assert.assertEquals("User redirected to signup page ", ExpectedWelcomeMsg, actualWelcomeMsg);

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
