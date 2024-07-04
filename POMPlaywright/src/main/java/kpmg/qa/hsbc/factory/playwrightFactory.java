package kpmg.qa.hsbc.factory;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;

public class playwrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;
	Properties prop;
	public Page initBrowser(Properties prop)
	{
		String BrowserName= prop.getProperty("browser").trim();
		System.out.println("Browser name is:" +BrowserName);
		playwright = Playwright.create();
		switch(BrowserName.toLowerCase()){
			case "chromium":
				browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "firefox":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "safari":
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "chrome":
				browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
				break;
				default :
					System.out.println("Please pass correct browser");
		}
		Dimension screenssize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenssize.getWidth();
		int height = (int)screenssize.getHeight();
		 context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
	      page = context.newPage();   
	      page.navigate(prop.getProperty("url").trim());
	      return page;
	}

	/**** this method is used to initialize the properties from Config properties
	 * @return 
	 * @throws IOException ***/
	public Properties init_prop() 
	{
		try{
			FileInputStream inf = new FileInputStream("./src/test/resource/config/config.properties");
			prop = new Properties();
			prop.load(inf);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return prop;
	}
}
