package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    protected WebDriver webDriver;
    protected final Logger logger = LogManager.getRootLogger();
    protected Capabilities cap;
    protected String browserName;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        cap = ((RemoteWebDriver) webDriver).getCapabilities();
        browserName = cap.getBrowserName().toLowerCase();
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement visibilityOf(WebElement webElement) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement findBy(By by) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void elementClick(WebElement webElement) {
        try {
            logger.info("Trying to click web element " + webElement);
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(webElement))
                    .click();

        } catch (ElementClickInterceptedException e) {
            logger.warn("Click intercepted, trying alternative methods...");

            Actions actions = new Actions(webDriver);
            actions.sendKeys(webElement, Keys.TAB).build().perform();
        }
        logger.info("Web element " + webElement + "clicked");
    }

}
