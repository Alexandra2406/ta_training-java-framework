package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EstimateSummaryPage extends AbstractPage {

    @FindBy(xpath = "//h5[contains(text(), 'Total estimated cost')]/following-sibling::h4")
    WebElement costSummary;
    @FindBy(xpath = "//span[contains(text(), 'Number of Instances')]/following-sibling::span")
    WebElement numberOfInstances;
    @FindBy(xpath = "//span[contains(text(), 'Operating System / Software')]/following-sibling::span")
    WebElement operationSystemSoftware;
    @FindBy(xpath = "//span[contains(text(), 'Provisioning Model')]/following-sibling::span")
    WebElement provisioningModel;
    @FindBy(xpath = "//span[contains(text(), 'Committed use discount options')]/following-sibling::span")
    WebElement committedUsage;
    @FindBy(xpath = "//span[contains(text(), 'Machine type')]/following-sibling::span")
    WebElement machineType;
    @FindBy(xpath = "//span[contains(text(), 'GPU Model')]/following-sibling::span")
    WebElement modelGPU;
    @FindBy(xpath = "//span[contains(text(), 'Number of GPUs')]/following-sibling::span")
    WebElement numberOfGPUs;
    @FindBy(xpath = "//span[contains(text(), 'Local SSD')]/following-sibling::span")
    WebElement localSSD;
    @FindBy(xpath = "//span[contains(text(), 'Region')]/following-sibling::span")
    WebElement datacenterLocation;

    public EstimateSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EstimateSummaryPage switchToNewWindow() {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
        logger.info("WebDriver switched to last window");
        return this;
    }

    public EstimateSummaryPage checkCostEstimateSummary(String expected) {
        logger.info("Checking total estimated cost");
        Assert.assertEquals(visibilityOf(costSummary).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkNumberOfInstances(String expected) {
        logger.info("Checking number of instances");
        Assert.assertEquals(visibilityOf(numberOfInstances).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkProvisioningModel(String expected) {
        logger.info("Checking provisioning model");
        Assert.assertEquals(visibilityOf(provisioningModel).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkOperationSystemSoftware(String expected) {
        logger.info("Checking operation system software");
        Assert.assertEquals(visibilityOf(operationSystemSoftware).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkMachineType(String expected) {
        logger.info("Checking machine type");
        Assert.assertEquals(visibilityOf(machineType).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkLocalSSD(String expected) {
        logger.info("Checking local SSD");
        Assert.assertEquals(visibilityOf(localSSD).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkDatacenterLocation(String expected) {
        logger.info("Checking datacenter Location");
        Assert.assertEquals(visibilityOf(datacenterLocation).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkCommittedUsage(String expected) {
        logger.info("Checking committed usage");
        Assert.assertEquals(visibilityOf(committedUsage).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkNumberOfGPUs(String expected) {
        logger.info("Checking number of GPUs");
        Assert.assertEquals(visibilityOf(numberOfGPUs).getText().strip(), expected);
        return this;
    }

    public EstimateSummaryPage checkGPUModel(String expected) {
        logger.info("Checking GPU model");
        Assert.assertEquals(visibilityOf(modelGPU).getText().strip(), expected);
        return this;
    }

}
