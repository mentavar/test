package test.utils.factory;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import test.utils.Test;
import test.utils.config.EnvDataConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    Test test;

    AndroidDriver<MobileElement> driver;

    WebDriverWait wait;

    EnvDataConfig envDataConfig;


    ContextFactory context;

    public AndroidDriver<MobileElement> driver1;
    public AppiumDriverLocalService service;

    private EnvironmentVariables env;

    public WebDriverFactory(Test test) throws IOException {
        this.test = test;
        envDataConfig = new EnvDataConfig();
        context = test.context();


        DesiredCapabilities caps1 = new DesiredCapabilities();
        caps1.setCapability("deviceName", "Pixel_6_API_33_1");
        //caps1.setCapability("udid", "40475748"); //DeviceId from "adb devices" command
        caps1.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps1.setCapability("platformName", "Android");
        caps1.setCapability("platformVersion", "13.0");
        caps1.setCapability("automationName", "UiAutomator2");
        caps1.setCapability("appium:uiautomator2ServerLaunchTimeout", 120000);
        caps1.setCapability("appium:uiautomator2ServerInstallTimeout", 120000);
        caps1.setCapability("appium:androidInstallTimeout", 200000);
        caps1.setCapability("skipUnlock", "false");
        caps1.setCapability("appPackage", "com.google.android.youtube");
        caps1.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        caps1.setCapability("noReset", "false");
        caps1.setCapability("fullReset", "false");
        try {
            driver1 = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        wait = new WebDriverWait(driver1, 3600);
        File screenshot = driver1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot1.png"));
        String screenshotPath = "artifacts/screenshots/" + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(screenshot, new File(screenshotPath));
    }

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
