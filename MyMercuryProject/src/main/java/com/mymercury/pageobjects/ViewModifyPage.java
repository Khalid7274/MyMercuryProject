package com.mymercury.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mymercury.actiondriver.Action;
import com.mymercury.base.BaseClass;

public class ViewModifyPage extends BaseClass {

	@FindBy (xpath="//*[@id='dataSourceNameSelect']")
	WebElement clickDataSourceNameSelect;
	
	@FindBy (xpath="//*[@id='dataSourceAliasSelect']")
	WebElement clickDataSourceAlias;
	
	@FindBy (xpath="//*[@id='dataSourceName']")
	WebElement clickDataSourceName;
	
	public ViewModifyPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String clickByDataBySourceName() {
		Action.selectByVisibleText(clickDataSourceName, "Tester");
		Select selectReturnData=new Select(clickDataSourceName);
		String sDataByName=selectReturnData.getFirstSelectedOption().getText();
		return sDataByName;
	}
	
	public String verifyDataByAliasList() {
		Action.selectByVisibleText(clickDataSourceAlias, "Khalid");
		Select selectReturnData=new Select(clickDataSourceName);
		String sDataByAlias=selectReturnData.getFirstSelectedOption().getText();
		return sDataByAlias;
		
	}
	
	public boolean getDataBySourceNameDropdown() {
		return Action.selectByVisibleText(clickDataSourceNameSelect, "Nematullah");
	}
}
