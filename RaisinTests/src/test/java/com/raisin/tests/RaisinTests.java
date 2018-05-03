package com.raisin.tests;
import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.ResourceUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.raisin.pages.HomePage;
import com.raisin.pages.OffersPage;
import com.raisin.pages.Popup;

import junit.framework.Assert;

public class RaisinTests {
	WebDriver driver;
	public static String url="https://www.raisin.com/";
		
	@BeforeTest
	@Parameters({"pathToDriver"})
	public void setup(@Optional String pathToDriver)
	{
		
		File chromeDriver = null;
		try {
			chromeDriver = ResourceUtils.getFile("classpath:BrowserDrivers/chromedriver.exe");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	@Test
	public void VerificationTest() throws InterruptedException
	{
		//First Step
		driver.get(url);	
		Popup popupPage=new Popup(driver);
				
		HomePage homePage=popupPage.clickOk();
		OffersPage offersPage=homePage.clickStartSaving();
		
		offersPage.uncheckEur();
		offersPage.checkEasyAccess();
		OffersPage temp=offersPage.clickShowMoreOffers();
		Thread.sleep(2000);
		
		Assert.assertEquals("10 offers match your search", offersPage.getText());
		System.out.println(temp.printOffers());
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
