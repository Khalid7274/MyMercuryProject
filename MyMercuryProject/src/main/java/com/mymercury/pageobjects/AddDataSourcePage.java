package com.mymercury.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mymercury.actiondriver.Action;
import com.mymercury.base.BaseClass;

public class AddDataSourcePage extends BaseClass{

	@FindBy (xpath="//@[id='dataSourceName']")
	WebElement sourceDataName;
	
	@FindBy (xpath="//@[id='dataSourceAlias']")
	WebElement dataSourceAlias;
	
	@FindBy (xpath="//@[id='name0']")
	WebElement contactName;
	
	@FindBy (xpath="//button[@class='App_btnSize__vb7DC form-input-submit btn btn-secondary']")
	WebElement clickSaveBtn;
	
	@FindBy (xpath="//b[text()='Add Contact']")
	WebElement addContact;
	
	@FindBy (xpath="//textarea[@id='description'")
	WebElement descriptionText;
	
	
	
	public AddDataSourcePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void addDataSourceInformation(String dataSname, String dataSourcealias, String contact) {
		Action.type(sourceDataName, dataSname);
		Action.type(dataSourceAlias, dataSourcealias);
		Action.type(contactName, contact);
		Action.click(getDriver(), clickSaveBtn);
	}
	
	
	public boolean verifyDescriptionText() {
		Action.type(descriptionText, "This is Discription Field");
		boolean descText=Action.isDisplayed(getDriver(), descriptionText);
		return descText;
	}
	
	public String getDataSourcePageUrl() {
		String datSourcePageUrl=getDriver().getCurrentUrl();
		return datSourcePageUrl;
	}
}
