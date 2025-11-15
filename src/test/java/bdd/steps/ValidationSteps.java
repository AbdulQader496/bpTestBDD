package bdd.steps;

import static org.testng.Assert.assertEquals;

import bdd.pages.HomePage;
import io.cucumber.java.en.Then;

public class ValidationSteps {
    HomePage homePage = new HomePage();
    
     @Then("I should see systolic validation message {string}")
    public void systolic_validation(String expected) {
        String actual = homePage.getSystolicValueValidationText();
        assertEquals(actual, expected, "Incorrect systolic validation message!");
    }

    @Then("I should see diastolic validation message {string}")
    public void diastolic_validation(String expected) {
        String actual = homePage.getDiastolicValueValidationText();
        assertEquals(actual, expected, "Incorrect diastolic validation message!");
    }

    @Then("I should see value comparison validation {string}")
    public void comparison_validation(String expected) {
        String actual = homePage.getValueGreaterValidationText();
        assertEquals(actual, expected, "Incorrect comparison validation message!");
    }
}
