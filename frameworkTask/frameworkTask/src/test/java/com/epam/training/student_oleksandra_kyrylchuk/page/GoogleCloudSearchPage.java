package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(), 'Google Cloud Pricing Calculator')]")
    WebElement pricingCalculatorLink;

    protected GoogleCloudSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WelcomePricingCalculatorPage openPricingCalculatorPage() {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", visibilityOf(pricingCalculatorLink));

        elementClick(pricingCalculatorLink);
        logger.info("Google Cloud Pricing Calculator page opened");

        return new WelcomePricingCalculatorPage(webDriver);
    }
}
