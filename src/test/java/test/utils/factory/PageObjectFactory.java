package test.utils.factory;

import test.pages.*;
import test.utils.Test;

public class PageObjectFactory {

    Test test;

    HomePage authenticationVerifier;

    public PageObjectFactory(Test test) {
        this.test = test;
    }

    public HomePage sampleTestYoutubePage() {
        return (authenticationVerifier == null) ? authenticationVerifier = new HomePage(test) : authenticationVerifier;
    }

}
