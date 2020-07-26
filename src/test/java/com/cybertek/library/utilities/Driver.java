package com.cybertek.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    //1-Make constructor private
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case"chrome-remote":
                    ChromeOptions chromeOptions=new ChromeOptions();
                    try {
                        URL url=new URL("http://54.160.59.195:4444/wd/hub");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                case "firefox-remote":
                    FirefoxOptions firefoxOptions=new FirefoxOptions();


                default:
                    throw new RuntimeException("Wrong browser name: "+browser);

            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }


}