package bdd.steps;

import static org.testng.Assert.assertEquals;

import bdd.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BpCatagorySteps {
    HomePage homePage = new HomePage();

@When("I enter systolic value {string}")
public void enter_systolic(String value) { homePage.enterSystolicValue(value); }

@When("I enter diastolic value {string}")
public void enter_diastolic(String value) { homePage.enterDiastolicValue(value); }

@When("I click the Submit button")
public void click_submit() { homePage.clickSubmitButton(); }

@Then("I should see the BP category as {string}")
public void verify_category(String expected) {

    String result = homePage.getBPCategoryResult();
    assertEquals(result, expected);
    // assert result.contains("Ideal Blood Pressure") : "Expected 'Ideal blood pressure' but got '" + result + "'";
    // String idealText = homePage.getIdealBPCategoryText();
    // assert idealText.equals("Blood Pressure Category: Ideal") : "Expected 'Ideal' but got '" + idealText + "'";
}

}
