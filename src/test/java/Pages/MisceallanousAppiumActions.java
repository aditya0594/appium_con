package Pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MisceallanousAppiumActions extends BaseTest{

	@Test
	public void Miscellanous() throws MalformedURLException
	{
		//adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
		// adb shell dumpsys window | find "mCurrentFocus"  - Windows

		//App Package & App Activity
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.app.AlertDialogSamples");
		//driver.startActivity(activity);

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();

		// to rotate the screen we have one class "DeviceRotation" Class
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");

		//copy paste
		//copy to clipboard- paste it clipboard
		driver.setClipboardText("Rahul Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText()); //this paste the copy text


		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

		// navigation button of android
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
		
		
		
		
		//set wifi name

	
			
	}
	
	
}
