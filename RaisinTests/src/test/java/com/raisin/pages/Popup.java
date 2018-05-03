package com.raisin.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Popup {
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButon;
	public Popup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		if(!okButon.isDisplayed())
		{
			throw new ElementNotVisibleException("Popup is not displayed!!");
		}
	}
	public HomePage clickOk()
	{
		okButon.click();
		return new HomePage(driver);
	}
}
