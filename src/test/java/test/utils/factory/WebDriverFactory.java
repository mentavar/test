package test.utils.factory;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import test.utils.Test;
import test.utils.config.EnvDataConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
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

    public WebDriverFactory(Test test) {
        this.test = test;
        envDataConfig = new EnvDataConfig();
        context = test.context();

          AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withAppiumJS(
                        new File("C:\\Users\\ftheofil\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();


//        String filePath1 = "node/AppiumServerGUI/resources/app/node_modules/appium/build/lib/main.js";
//        File file1 = new File(filePath1);
//        String absolutePath1 = file1.getAbsolutePath();
//
//        String filePath2 = "nodeexe/nodejs/node.exe";
//        File file2 = new File(filePath2);
//        String absolutePath2 = file2.getAbsolutePath();
//
//
//        AppiumServiceBuilder builder = new AppiumServiceBuilder();
//        builder.withIPAddress("127.0.0.1")
//                .usingPort(4723)
//                .withAppiumJS(new File(absolutePath1))
//                .usingDriverExecutable(new File(absolutePath2));
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
//        service.start();


        DesiredCapabilities caps1 = new DesiredCapabilities();
        caps1.setCapability("deviceName", "Pixel_6_API_33_1");
        //caps1.setCapability("udid", "40475748"); //DeviceId from "adb devices" command
        caps1.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps1.setCapability("platformName", "Android");
        caps1.setCapability("platformVersion", "13.0");
        caps1.setCapability("automationName", "UiAutomator2");
        caps1.setCapability("skipUnlock", "true");
        caps1.setCapability("appPackage", "com.google.android.youtube");
        caps1.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        caps1.setCapability("noReset", "false");
        caps1.setCapability("fullReset", "false");
        try {
            driver1 = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps1);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver1, 50);
    }

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }


}
