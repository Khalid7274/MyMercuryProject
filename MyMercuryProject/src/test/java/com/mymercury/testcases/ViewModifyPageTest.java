package com.mymercury.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mymercury.base.BaseClass;
import com.mymercury.dataprovider.DataProviders;
import com.mymercury.pageobjects.LoginPage;
import com.mymercury.pageobjects.ViewModifyPage;

public class ViewModifyPageTest extends BaseClass{
	LoginPage loginPage;
	ViewModifyPage viewModifyPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Sanity, Regression"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void validateSourceDataByName(String uname, String pswd) throws InterruptedException, IOException{
		loginPage=new LoginPage();
		loginPage.loginn(uname,pswd);
		loginPage.clickDatasourceLink();
		viewModifyPage=loginPage.clickViewModifyLink();
		String actionDataSelectedByName=viewModifyPage.clickByDataBySourceName();
		String expectedData="Tester";
		Assert.assertEquals(actionDataSelectedByName, expectedData);
	}
	
	@Test(groups = {"Sanity, Regression"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void validateDataByAlais(String uname, String pswd) throws InterruptedException, IOException{
		loginPage=new LoginPage();
		loginPage.loginn(uname,pswd);
		loginPage.clickDatasourceLink();
		viewModifyPage=loginPage.clickViewModifyLink();
		String actionDataSelectedByName=viewModifyPage.verifyDataByAliasList();
		String expectedData="Khalid";
		Assert.assertEquals(actionDataSelectedByName, expectedData);
	}
}
