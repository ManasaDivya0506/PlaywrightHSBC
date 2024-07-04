package kpmg.qa.hsbc.page;

import com.microsoft.playwright.Page;

public class MFAscreenPage {
	Page page;
	//*********Locator****************
	private String MFAContinue = "//button[@id='continue']";
	private String MFACancel = "//button[@id='cancel']";
	
	//******** Page Construction***********
	public MFAscreenPage(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page ;
	}
	
	//****** Page Actions *********//
   public BrokerHomePage MFAContinueclick()
   {
	   page.waitForTimeout(20000);
	   page.click(MFAContinue);
	   return new BrokerHomePage(page);
   }
   public void BrokerMFACancelclick()
   {
	   page.click(MFACancel);
   }
 

}
