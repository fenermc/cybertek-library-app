package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    @Given("I am the login page")
    public void i_am_the_login_page() {
        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.emailAddress.sendKeys(ConfigurationReader.getProperty("lib_22_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("lib_22_password"));
        loginPage.signInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected = "dashboard";
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual=Driver.getDriver().getCurrentUrl();
        //System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        loginPage.emailAddress.sendKeys(ConfigurationReader.getProperty("stu_11_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("stu_11_password"));
        loginPage.signInButton.click();
    }

    @Then("books  should be displayed")
    public void booksShouldBeDisplayed() {
        String expected="books";

        wait.until(ExpectedConditions.urlContains(expected));

        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));


    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.emailAddress.sendKeys(username);


    }

    @And("I enter password {string}")
    public void iEnterPasswordNpAxVIh(String password) {
        loginPage.password.sendKeys(password);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.signInButton.click();
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int userCount ) {
        String expected=String.valueOf(userCount);


        wait.until(ExpectedConditions.visibilityOf(dashboardPage.userCount));


        Assert.assertTrue("actual number is not the same",dashboardPage.userCount.getText().equals(expected));

    }

}
