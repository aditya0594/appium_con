package Pages;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{

	@Test (priority=1,enabled = true )
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	{

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//where to scroll is known prior
		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+ "\"));
		scrollToText("Visibility");
	}
	@Test (priority=2,enabled = true)
	public void ScrollDemoTest1() throws MalformedURLException, InterruptedException
	{
		//No prior idea
		scrollToEndAction();
	}
	
	
}
