package test.utils;

import test.utils.common.Logger;
import test.utils.factory.ContextFactory;
import test.utils.factory.PageObjectFactory;
import test.utils.factory.WebDriverFactory;

import java.io.IOException;

public class Test {


    WebDriverFactory webDriverFactory;

    PageObjectFactory pageObjectFactory;

    ContextFactory contextFactory;

    Logger logger;

    public Test() throws IOException {
        contextFactory = new ContextFactory();
        webDriverFactory = new WebDriverFactory(Test.this);
        pageObjectFactory = new PageObjectFactory(Test.this);
        logger = new Logger();
    }

    public Logger logger() {
        return logger;
    }

    public PageObjectFactory mobile() {
        return pageObjectFactory;
    }

    public ContextFactory context() {
        return contextFactory;
    }

    public WebDriverFactory webDriverFactory() {
        return webDriverFactory;
    }

}
