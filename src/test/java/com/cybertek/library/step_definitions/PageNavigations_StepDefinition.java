package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageNavigations_StepDefinition {
    UsersPage usersPage = new UsersPage();
    BasePage basePage = new BasePage();
    Select select;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("I click  on {string} link")
    public void i_click_on_link(String link) throws InterruptedException {
//        switch (link.toLowerCase()) {
//            case "dashboard":
//                basePage.dashboardPageLink.click();
//                break;
//            case "users":
//                basePage.usersPageLink.click();
//                break;
//            case "books":
//                basePage.booksPageLink.click();
//                break;
//        }
        wait.until(ExpectedConditions.visibilityOf(basePage.usersPageLink));
        basePage.usersPageLink.click();

    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        wait.until(ExpectedConditions.visibilityOf(usersPage.showRecordsDropdown));
        select = new Select(usersPage.showRecordsDropdown);
        String expected = String.valueOf(int1);


        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List <String> option) {

//        System.out.println("option.size() = " + option.size());
//        System.out.println("option = " + option);

        select = new Select(usersPage.showRecordsDropdown);
        List <WebElement> webElements = select.getOptions();
        List <String> actualTexts = new ArrayList <>();
        for (WebElement each : webElements) {

            actualTexts.add(each.getText());
        }
        Assert.assertEquals(option,actualTexts);


    }
//    @Then("table should have following column names:")
//    public void table_should_have_following_column_names(List<String>expectedList) throws InterruptedException {
//        Thread.sleep(3000);
//        show_records_should_have_following_options(expectedList);
//        List<String>actualList=new ArrayList <>();
//
//        List<WebElement>webElementList=usersPage.columnsHeader;
//        System.out.println(webElementList.get(0));
//        for (WebElement each:webElementList) {
//            actualList.add(each.getText());
//        }
//        System.out.println(actualList);
//
//    }
}
