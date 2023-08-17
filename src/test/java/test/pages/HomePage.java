package test.pages;

import test.android.HomeElements;
import test.utils.Test;
import test.utils.common.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {

    Logger logger;

    Test test;

    public HomePage(Test test) {
        this.test = test;
        logger = test.logger();
    }

    public void verifyHomePageElements(){
        test.webDriverFactory().getWait().until(ExpectedConditions.visibilityOfElementLocated(HomeElements.homePageLogo));
    }

}
