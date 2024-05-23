package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {
    private final String HOMEPAGE_URL = "https://cloud.google.com";
    @FindBy(xpath = "//div[@jsname='Ohx1pb']")
    WebElement searchIcon;
    @FindBy(xpath = "//*[@id='i4']")
    WebElement searchForm;

    public GoogleCloudHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudHomePage openPage() {
        logger.info("Google Cloud homepage opened");
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudHomePage clickSearchIcon() {
        elementClick(searchIcon);
        return this;
    }

    public GoogleCloudSearchPage searchQuery(String query) {
        visibilityOf(searchForm);
        searchForm.sendKeys(query);
        searchForm.sendKeys(Keys.ENTER);
        logger.info("Search request + '" + query + "' sent");

        return new GoogleCloudSearchPage(webDriver);
    }
}