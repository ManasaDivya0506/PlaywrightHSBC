package kpmg.qa.hsbc.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import kpmg.qa.hsbc.base.BaseTest;
import kpmg.qa.hsbc.constants.AppConstants;

public class MFAPageTest extends BaseTest {
	@Test
	public void MFAScreen()
	{
	
		loginpage = homepage.selectBrokerpage();
		mfpage = loginpage.BrokerLogin(prop.getProperty("username").trim(), prop.getProperty("Password").trim());
		mfpage.MFAContinueclick();
		//Assert.assertEquals(mfpage.getBrokerHomepgetitle(), AppConstants.BHOME_PAGE_TITLE);
	}

}
