package com.raisin.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
    
    @FindBy(xpath="//a[text()='Start Saving']")
    WebElement startSavingLink;
    
    @FindBy(xpath="//button[text()='OK']")
    WebElement okButon;
    
    public HomePage(WebDriver driver)
    {    
        this.driver=driver;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PageFactory.initElements(driver, this);

		if(!startSavingLink.isDisplayed())
		{
			throw new ElementNotVisibleException("Start Saving Link is not visible");
		}
    }
    
    public OffersPage clickStartSaving()
    {
        startSavingLink.click();
        return new OffersPage(driver);
    }
    
   public HomePage clickOkButton()
    {
    	okButon.click();
    	return this;
    }
   
}
