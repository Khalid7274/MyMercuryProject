package com.mymercury.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mymercury.base.BaseClass;
import com.mymercury.dataprovider.DataProviders;
import com.mymercury.pageobjects.AddDataSourcePage;
import com.mymercury.pageobjects.LoginPage;

public class AddDataSourcePageTest extends BaseClass{
	
	LoginPage loginPage;
	AddDataSourcePage addDataSourcePage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups="Regression", dataProvider="DataSource", dataProviderClass= DataProviders.class)
	public void fnDataSourceViewModifyLink(String sourceDataName, String sourceAlais, String contactName) throws InterruptedException, IOException{
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.clickDatasourceLink();
		loginPage.clickAddLink();
		addDataSourcePage.addDataSourceInformation(sourceDataName, sourceAlais, contactName);
		boolean decriptionTex=addDataSourcePage.verifyDescriptionText();
		String expectedDescText="This is Discription Field";
		Assert.assertEquals(decriptionTex, expectedDescText);
	}
	
}
