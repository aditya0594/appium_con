package Pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	String path;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{

		 service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		path = System.getProperty("user.dir");
								
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("RZ8NA1P2S8D");
			options.setChromedriverExecutable(path+"//Driver/chromedriver.exe");
			options.setCapability("browserName", "Chrome");
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
        service.stop();
		}
	
}
