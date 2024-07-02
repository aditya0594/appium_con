package Pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class practics_alert extends BaseTest{
    @Test(priority = 1,enabled = true)
    public void loginDialogCopyPaste() throws MalformedURLException, InterruptedException {
        //adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
        // adb shell dumpsys window | find "mCurrentFocus"  - Windows

        // artical - testsigma


        //App Package & App Activity
        // (//android.widget.EditText)[1] --xpath type
        //

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.app.AlertDialogSamples");
        //driver.startActivity(activity);

        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();
        driver.setClipboardText("Adityapawar");
        driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys(driver.getClipboardText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Password@123");
        driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));


    }
    @Test(priority = 2,enabled = true)
    public void click_Checkbox() throws MalformedURLException, InterruptedException {
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        //driver.startActivity(activity);  --deprecated
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.app.AlertDialogSamples"));


        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Text Entry dialog\"]")).click();
        driver.setClipboardText("Adityapawar");
        driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys(driver.getClipboardText());
        Thread.sleep(2000);

    }
    @Test(priority = 3,enabled = true)
    public void LoginPage() throws MalformedURLException, InterruptedException {
        Activity activity = new Activity("io.appium.android.api", "/com.androidsample.generalstore.MainActivity");
        //driver.startActivity(activity);  --deprecated
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.api/com.androidsample.generalstore.MainActivity"));


        driver.findElement(By.id("android:id/text1")).click();
        scrollToText("Austria");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
        driver.setClipboardText("Adityapawar");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(driver.getClipboardText());
        Thread.sleep(3000);
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }
    @Test(priority = 4,enabled = true)
    public void ToastMessage() throws MalformedURLException, InterruptedException {
        Activity activity = new Activity("io.appium.android.api", "/com.androidsample.generalstore.MainActivity");
        //driver.startActivity(activity);  --deprecated
        driver.findElement(By.id("android:id/text1")).click();
        scrollToText("Austria");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //android.widget.toast
        Thread.sleep(1000);
        String str = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        System.out.println(str);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(str,"Please enter name");
        softAssert.assertAll();
    }
    @Test(priority = 5,enabled = true)
    public void addtocart() throws MalformedURLException, InterruptedException {
        Activity activity = new Activity("io.appium.android.api", "/com.androidsample.generalstore.MainActivity");
        //driver.startActivity(activity);  --deprecated
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.api/com.androidsample.generalstore.MainActivity"));


        driver.findElement(By.id("android:id/text1")).click();
        scrollToText("Austria");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
        driver.setClipboardText("Adityapawar");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(driver.getClipboardText());
        Thread.sleep(3000);
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        int productscount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0; i<productscount; i++){
            String productName =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            scrollToText("Converse All Star");
            if(productName.equalsIgnoreCase("Converse All Star")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(7000);
    }


}
