package bdd.steps;

import bdd.hooks.Hooks;
import bdd.pages.HomePage;
import bdd.pages.MainPageNavigation;
import bdd.pages.PrivacyPolicyPage;
import io.cucumber.java.en.*;

import static org.testng.Assert.*;

public class PrivacyPolicyPageSteps {
    HomePage homePage = new HomePage();
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
    

    @Given("I open the BP Home Page")
    public void i_open_the_bp_home_page() {
        
    }

    @When("I click on the Privacy Policy link")
    public void i_click_on_the_privacy_policy_link() {
        homePage.clickNavigationLink(MainPageNavigation.Privacy_Policy);
    }

    @Then("I should be redirected to the Privacy Policy page titled {string}")
    public void i_should_be_redirected_to_the_privacy_policy_page(String expectedTitle) {
        String actualTitle = privacyPolicyPage.verifyPrivacyPolicyPageTitle("Privacy Policy");
        assertEquals(actualTitle, "Privacy Policy", "Privacy Policy page title does not match.");
    }
}
