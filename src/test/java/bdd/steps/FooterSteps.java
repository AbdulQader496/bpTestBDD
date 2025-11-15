package bdd.steps;
import static org.testng.Assert.assertEquals;

import bdd.pages.HomePage;
import bdd.pages.MainPageNavigation;
import bdd.pages.PrivacyPolicyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterSteps {
    HomePage homePage = new HomePage();
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();

    @Then("I should see the footer text {string}")
    public void footerTextInHomePage(String expectedText) {
        String actual = homePage.getFooterCopyrightText();
        assertEquals(actual, expectedText, "Footer text mismatch!");
    }

    @Then("I should see a footer link labeled {string}")
    public void footerLinkLabeledInHomePage(String linkText) {
        String actual = homePage.getFooterPrivacyPolicyText();
        assertEquals(actual, linkText, "Footer link text mismatch!");
    }

    @Given("I navigate to Privacy Policy page")
    public void navigateToPrivacyPolicyPage() {
        homePage.clickNavigationLink(MainPageNavigation.Privacy_Policy);
    }

    @Then("I should see the footer text {string} in Privacy Policy page")
    public void footerTextInPrivacyPolicyPage(String expectedText) {
        // homePage.clickNavigationLink(MainPageNavigation.Privacy_Policy);
        String actual = privacyPolicyPage.getFooterCopyrightText();
        assertEquals(actual, expectedText, "Footer text mismatch!");
    }

    @Then("I should see a footer link labeled {string} in Privacy Policy page")
    public void footerLinkLabeledInPrivacyPolicyPage(String linkText) {
        // homePage.clickNavigationLink(MainPageNavigation.Privacy_Policy);
        String actual = privacyPolicyPage.getFooterPrivacyPolicyText();
        assertEquals(actual, linkText, "Footer link text mismatch!");
    }



}
