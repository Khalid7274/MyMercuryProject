/**
 * 
 */
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

/**
 * @author Nematullah Khalid
 *
 */
public class LoginPageTest extends BaseClass{
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
	
	//We can write in this way if we want to chain pages
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest() {
		loginPage=new LoginPage();
		addDataSourcePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualUrl=addDataSourcePage.getDataSourcePageUrl();
		String expectedUrl="http://mercuryexample.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void fnDataSourceAddLink(String uname, String pswd) throws InterruptedException, IOException{
		loginPage=new LoginPage();
		loginPage.loginn(uname,pswd);
		loginPage.clickDatasourceLink();
		loginPage.clickAddLink();
	}
	
	
	@Test(groups = {"Sanity, Regression"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void fnDataSourceViewModifyLink(String uname, String pswd) throws InterruptedException, IOException{
		loginPage=new LoginPage();
		loginPage.loginn(uname,pswd);
		loginPage.clickDatasourceLink();
		loginPage.clickViewModifyLink();
		boolean result=loginPage.validateViewModify();
		Assert.assertTrue(result);
		
	}
}
