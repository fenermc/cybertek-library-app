package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UsersTable_StepDefinitions {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    UsersPage usersPage = new UsersPage();
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List <String> expectedList) throws InterruptedException {
      wait.until(ExpectedConditions.visibilityOf(usersPage.columnsHeader.get(0)));
        //System.out.println(expectedList);
        List<String>actualList=new ArrayList <>();

        List<WebElement>webElementList=usersPage.columnsHeader;
        //System.out.println(webElementList.get(0).getText());
        for (WebElement each:webElementList) {
            actualList.add(each.getText());
        }
       // System.out.println(actualList);
        Assert.assertEquals(actualList,expectedList);

    }
    }
