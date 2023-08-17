package test.stepdefs;

import test.utils.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GeneralStepDefs {

    Test test;

    public GeneralStepDefs() {
        this.test = new Test();
    }

    @Given("user opens youtube")
    public void user_requests_for_id_authentication() {
        test.mobile().sampleTestYoutubePage().verifyHomePageElements();
    }

}