/**
 * 
 */
package com.mymercury.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mymercury.actiondriver.Action;
import com.mymercury.base.BaseClass;

/**
 * @author Nematullah Khalid
 *
 */
public class LoginPage extends BaseClass{

	@FindBy (xpath= "//input[@name='userId']")
	WebElement userName;
	
	@FindBy (xpath= "//input[@name='password']")
	WebElement password;
	
	@FindBy  (xpath= "//*[contains(@valued,'Login']")
	WebElement loginBtn;
	
	
	@FindBy (xpath= "//a[@role='button' and text()='Data Source'")
	WebElement dataSourceLink;
	
	@FindBy (xpath= "//a[contains(.,'Add')]")
	WebElement addLink;
	
	@FindBy (xpath= "//a[contains(.,'View/Modify')]")
	WebElement viewModifyLink;
	
	@FindBy (xpath = "//h2[normalize-space()='View Modify']")
	WebElement viewModifyMessage;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//We write like this if we want to go to AddDataSourcePage
	public AddDataSourcePage login(String uname, String pass) {
		Action.type(userName, uname);
		Action.type(password, pass);
		Action.click(getDriver(), loginBtn);
		return new AddDataSourcePage();
	}
	
	public void loginn(String uname, String pass) {
		Action.type(userName, uname);
		Action.type(password, pass);
		Action.click(getDriver(), loginBtn);
	}
	
	public void clickLoginButton() {
		Action.click(getDriver(), loginBtn);
	}
	public void clickDatasourceLink() {
		Action.click(getDriver(), dataSourceLink);
	}
	
	public void clickAddLink() {
		Action.click(getDriver(), addLink);
	}
	
	public ViewModifyPage clickViewModifyLink() {
		Action.click(getDriver(), viewModifyLink);
		return new ViewModifyPage();
	}
	
	public boolean validateViewModify() {
		Action.fluentWait(getDriver(), viewModifyMessage, 10);
		return Action.isDisplayed(getDriver(), viewModifyMessage);
	}
}
