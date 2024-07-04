package kpmg.qa.hsbc.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import jdk.internal.util.xml.impl.Input;
import kpmg.qa.hsbc.base.BaseTest;
import kpmg.qa.hsbc.excelutil.GetInputDataFromExcel;
import kpmg.qa.hsbc.page.BrokerNewRequestPage;

public class BrokerNewRequestPageTest extends BaseTest {



	@Test(priority =1)
	public void pagenavigation()
	{
		loginpage = homepage.selectBrokerpage();
		//**************Unhide this after MFA activation
		mfpage = loginpage.BrokerLogin(prop.getProperty("username").trim(), prop.getProperty("Password").trim());
		bhomepage = mfpage.MFAContinueclick();
		//********* hide this after MFA activation
		//bhomepage = loginpage.BrokerLogin(prop.getProperty("username").trim(), prop.getProperty("Password").trim());
		//bhomepage.BRequestClick();
		brequesthomepage= bhomepage.BRequestClick();
		BNewReqPage = brequesthomepage.NewRequestbuttonclick();
		
	}
	
	@Test(dataProvider = "exceldata", dataProviderClass = GetInputDataFromExcel.class)
	public void NewSRCreation(Object[][] testData)
	{
		
	/*	loginpage = homepage.selectBrokerpage();
		//mfpage = loginpage.BrokerLogin(prop.getProperty("username").trim(), prop.getProperty("Password").trim());
		bhomepage = mfpage.MFAContinueclick();
		System.out.println("*****************MFA Done*****************");
		brequesthomepage = bhomepage.BRequestClick();
		System.out.println("*****************Request tab click Done*****************");
		brequesthomepage.NewRequestbuttonclick();
		System.out.println("*****************New Request button click Done*****************");
		
		//System.out.println("Request type is " +Reqtype);
		 */ 
		 
		// = new BrokerNewRequestPage(page, testData);
		//BNewReqPage.BrokerNewRequestPage(page, testData);
		mySRpage =BNewReqPage.newdealNoSRCreation();
		
		
	}
	
	

}
