package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WelcomePricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//c-wiz[1]//button")
    WebElement addToEstimateButton;
    @FindBy(xpath = "//div[h2/text()='Compute Engine']")
    WebElement computeEngineButton;

    protected WelcomePricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WelcomePricingCalculatorPage addToEstimateClick() {
        visibilityOf(addToEstimateButton);
        actionClick(addToEstimateButton);
        return this;
    }

    public PricingCalculatorPage computeEngineClick() {
        visibilityOf(computeEngineButton);
        actionClick(computeEngineButton);
        return new PricingCalculatorPage(webDriver);
    }

    private void actionClick(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.sendKeys(webElement, Keys.TAB).build().perform();
        logger.info(webElement + " clicked");
    }
}
