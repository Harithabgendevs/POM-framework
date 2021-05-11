package com.crm.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmObjects {
	WebDriver driver;
	
	public CrmObjects(WebDriver driver){
	this.driver=driver;
	 PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	 public WebElement contactsLabel;
	
	@FindBy(id="first_name")
	public WebElement firstName;
	
	@FindBy(id="surname")
	public WebElement lastName;
	
	@FindBy(name="client_lookup")
	public WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//td[contains(text(),'User: Haritha B')]")
	@CacheLookup
	public WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	public WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	public WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	public WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	public WebElement tasksLink;
	
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	public WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	public WebElement crmLogo;
	



	
	

	

}
