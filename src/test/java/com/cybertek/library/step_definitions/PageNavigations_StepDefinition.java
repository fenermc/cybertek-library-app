package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageNavigations_StepDefinition {
    UsersPage usersPage = new UsersPage();
    BasePage basePage = new BasePage();
    Select select;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("I click  on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                basePage.dashboardPageLink.click();
                break;
            case "users":
                basePage.usersPageLink.click();
                break;
            case "books":
                basePage.booksPageLink.click();
        }

    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        wait.until(ExpectedConditions.visibilityOf(usersPage.show));
        select = new Select(usersPage.show);
        String expected = String.valueOf(int1);


        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals(expected,select.getFirstSelectedOption().getText());


    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(io.cucumber.datatable.DataTable dataTable) {

    }


}
