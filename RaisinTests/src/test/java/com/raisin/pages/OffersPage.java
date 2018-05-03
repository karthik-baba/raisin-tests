package com.raisin.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {

	WebDriver driver;

	@FindBy(xpath="//*[@id=\"local_currency_cb\"]")
	WebElement onlyEurCheckBox;

	@FindBy(xpath="//*[@id=\"early_termination_cb\"]")
	WebElement easyAccessCheck;

	@FindBy(xpath="//div[@class='prot-listing-count']/span")
	WebElement searchResult;

	@FindBy(xpath="//div[@ng-bind='product.rate.display_alt']")
	List<WebElement> offerRates;

	@FindBy(xpath="//button[text()='Show more offers']")
	WebElement showMoreOffersBtn;

	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		if(!onlyEurCheckBox.isDisplayed())
		{
			throw new ElementNotVisibleException("Check box is not displayed in the screen!!! Page not loaded");
		}
	}

	public void uncheckEur()
	{
		onlyEurCheckBox.click();
	}

	public void checkEasyAccess()
	{
		easyAccessCheck.click();
	}

	public String getText()
	{
		return searchResult.getText();
	}
	public OffersPage clickShowMoreOffers()
	{
		showMoreOffersBtn.click();

		return this;

	}
	public List<String> printOffers()
	{
		List<String> offers=new ArrayList();
		for(WebElement offer:offerRates)
		{
			offers.add(offer.getText());
		}
		return offers;		
	}
}
