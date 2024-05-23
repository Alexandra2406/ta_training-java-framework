package com.epam.training.student_oleksandra_kyrylchuk.test;

import com.epam.training.student_oleksandra_kyrylchuk.driver.DriverSingleton;
import com.epam.training.student_oleksandra_kyrylchuk.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class CommonConditions {

    protected static WebDriver driver;
    protected static final String SEARCH_TERM = "Google Cloud Pricing Calculator";

    @BeforeTest(alwaysRun = true)
    protected void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterSuite(alwaysRun = true)
    protected void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
