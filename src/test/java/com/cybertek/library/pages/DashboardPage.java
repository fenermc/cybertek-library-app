package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboard;
    @FindBy(id="user_count")
    public WebElement numberUser;

}
