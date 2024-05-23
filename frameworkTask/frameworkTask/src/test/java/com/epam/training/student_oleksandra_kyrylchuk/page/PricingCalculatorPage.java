package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";
    @FindBy(xpath = "//*[@id='c11']")
    WebElement numberOfInstancesInput;
    @FindBy(xpath = "//span[contains(text(), 'Operating System / Software')]/ancestor::div[2]")
    WebElement operationSystemSoftwareInput;
    @FindBy(xpath = "//span[contains(text(), 'Machine Family')]/ancestor::div[2]")
    WebElement machineFamilyInput;
    @FindBy(xpath = "//span[contains(text(), 'Series')]/ancestor::div[2]")
    WebElement seriesInput;
    @FindBy(xpath = "//span[contains(text(), 'Machine type')]/ancestor::div[2]")
    WebElement machineTypeInput;
    @FindBy(xpath = "//button[contains(@aria-label, 'Add GPUs')]/ancestor::div[4]")
    WebElement addGPUsInput;
    @FindBy(xpath = "//span[contains(text(), 'GPU Model')]/ancestor::div[2]")
    WebElement GPUTypeInput;
    @FindBy(xpath = "//span[contains(text(), 'Number of GPUs')]/ancestor::div[2]")
    WebElement numberOfGPUsInput;
    @FindBy(xpath = "//span[contains(text(), 'Local SSD')]/ancestor::div[2]")
    WebElement localSSDInput;
    @FindBy(xpath = "//span[contains(text(), 'Region')]/ancestor::div[2]")
    WebElement datacenterLocationInput;

    @FindBy(xpath = "//button[contains(@aria-label, 'Open Share Estimate dialog')]")
    WebElement openShareEstimate;
    @FindBy(xpath = "//a[contains(@track-name, 'open estimate summary')]")
    WebElement openEstimateSummary;

    public PricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static String getHOMEPAGE_URL() {
        return HOMEPAGE_URL;
    }

    public PricingCalculatorPage fillComputeEngineForm(int numberOfInstances, String operationSystemSoftware,
                                                       String provisioningModel, String machineFamily, String series,
                                                       String machineType, String localSSD, String datacenterLocation,
                                                       String committedUsage, boolean addGPUs, String GPUType, int numberOfGPUs) {
        visibilityOf(numberOfInstancesInput);
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(String.valueOf(numberOfInstances));
        logger.info("Number of instances '" + numberOfInstances + "' selected");

        elementClick(operationSystemSoftwareInput);
        elementClick(findBy(By.xpath("//span[contains(text(), '" + operationSystemSoftware + "')]/ancestor::li")));
        logger.info("Operation system software '" + operationSystemSoftware + "' selected");

        elementClick(findBy(By.xpath("//label[contains(text(), '" + provisioningModel + "')]/parent::*")));
        logger.info("Provision model '" + provisioningModel + "' selected");

        elementClick(machineFamilyInput);
        elementClick(findBy(By.xpath("//span[contains(text(), '" + machineFamily + "')]/ancestor::li")));
        logger.info("Machine family '" + machineFamily + "' selected");

        elementClick(seriesInput);
        elementClick(findBy(By.xpath("//span[contains(text(), '" + series + "')]/ancestor::li")));
        logger.info("Series '" + series + "' selected");

        elementClick(machineTypeInput);
        elementClick(findBy(By.xpath("//span[contains(text(), '" + machineType + "')]/ancestor::li")));
        logger.info("machine type '" + machineType + "' selected");

        if (addGPUs) {
            visibilityOf(addGPUsInput);
            elementClick(addGPUsInput);
            logger.info("Added GPUS '" + addGPUs + "' selected");

            elementClick(GPUTypeInput);
            elementClick(findBy(By.xpath("//span[contains(text(), '" + GPUType + "')]/ancestor::li")));
            logger.info("GPU type '" + GPUType + "' selected");

            elementClick(numberOfGPUsInput);
            elementClick(findBy(By.xpath("//ul[contains(@aria-label, 'Number of GPUs')]//li[contains(@data-value, '" + numberOfGPUs + "')]")));
            logger.info("Number of GPUs '" + numberOfGPUs + "' selected");
        }

        elementClick(localSSDInput);
        elementClick(findBy(By.xpath("//span[contains(text(), '" + localSSD + "')]/ancestor::li")));
        logger.info("Local SSD '" + localSSD + "' selected");

        elementClick(datacenterLocationInput);
        elementClick(findBy(By.xpath("//span[contains(text(), '" + datacenterLocation + "')]/ancestor::li")));
        logger.info("Datacenter Location '" + datacenterLocation + "' selected");

        visibilityOf(findBy(By.xpath("//label[contains(text(), '" + committedUsage + "')]/ancestor::div[1]")));
        elementClick(findBy(By.xpath("//label[contains(text(), '" + committedUsage + "')]/ancestor::div[1]")));
        logger.info("Committed usage '" + committedUsage + "' selected");

        return this;
    }

    public PricingCalculatorPage waitForCostEvaluation(String cost) {

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.textToBe(By.xpath("//div[contains(text(), 'Estimated cost')]/following-sibling::div/label"), cost));
        logger.info("Waited for cost '" + cost + "' evaluated");
        return this;
    }

    public PricingCalculatorPage openEstimateShare() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openShareEstimate);
        visibilityOf(findBy(By.xpath("//button[contains(@aria-label, 'Open Share Estimate dialog')]")));
        elementClick(openShareEstimate);
        logger.info("Open share estimate clicked");
        return this;
    }

    public EstimateSummaryPage openEstimateSummary() {
        visibilityOf(findBy(By.xpath("//a[contains(@track-name, 'open estimate summary')]")));
        elementClick(openEstimateSummary);
        logger.info("Open estimate summary clicked");

        return new EstimateSummaryPage(webDriver);
    }
}
