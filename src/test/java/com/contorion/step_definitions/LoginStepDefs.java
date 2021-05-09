package com.contorion.step_definitions;

import com.contorion.pages.Dashboard;
import com.contorion.utilities.ConfigurationReader;
import com.contorion.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
    Dashboard dashboard = new Dashboard();

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.get().get(ConfigurationReader.get("homePageURL"));

        if (!dashboard.acceptCookies.isEmpty()) {
            dashboard.acceptCookies.get(0).click();
        }
        Assert.assertEquals("verify the title", ConfigurationReader.get("homePageTitle"), Driver.get().getTitle());
    }

    @Given("user navigates to {string}")
    public void user_navigates_to(String module) throws Exception{
        switch (module) {
            case "login page":
                dashboard.anmelden.click();
                break;
            case "other modules":
                //to be added
                break;
            default:
                throw new Exception("please enter a valid module!");
        }

    }

    @When("the user hovers on {string}")
    public void the_user_hovers_on(String module) throws Exception {
        Actions action = new Actions(Driver.get());

        switch (module) {
            case "anmelden":
                action.moveToElement(dashboard.anmelden).perform();
                break;
            case "other modules":
                //to be added
                break;
            default:
                throw new Exception("please enter a valid module!");
        }

    }

    @When("user enters credentials and clicks Jetzt anmelden")
    public void user_enters_credentials_and_clicks_Jetzt_anmelden() throws InterruptedException {
        dashboard.inputMail.sendKeys(ConfigurationReader.get("email"));
        dashboard.inputPassword.sendKeys(ConfigurationReader.get("password"));

        String currentPage = Driver.get().getCurrentUrl();
        if (!currentPage.equals(ConfigurationReader.get("homePageURL"))) {
            dashboard.loginPageLogin.click();
        }
        else {
            dashboard.homePageLogin.click();
        }
    }

    @Then("user should succesfully login")
    public void user_should_succesfully_login() {
        String expectedMessage = ConfigurationReader.get("loginSuccessMessage");
        Assert.assertEquals(expectedMessage, dashboard.successMessage.getText());
    }


}