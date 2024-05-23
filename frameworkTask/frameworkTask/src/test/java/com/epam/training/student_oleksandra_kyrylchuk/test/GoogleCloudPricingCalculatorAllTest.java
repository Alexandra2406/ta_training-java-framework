package com.epam.training.student_oleksandra_kyrylchuk.test;

import com.epam.training.student_oleksandra_kyrylchuk.model.ComputeEngine;
import com.epam.training.student_oleksandra_kyrylchuk.page.GoogleCloudHomePage;
import com.epam.training.student_oleksandra_kyrylchuk.service.ComputeEngineCreator;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorAllTest extends CommonConditions {

    private final ComputeEngine computeEngine = ComputeEngineCreator.withDataFromProperty();

    @Test(description = "Initialize, fill and check result Google Cloud Pricing Calculator Test")
    public void testGoogleCloudPricingCalculator() {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage
                .openPage()
                .clickSearchIcon()
                .searchQuery(SEARCH_TERM)
                .openPricingCalculatorPage(SEARCH_TERM)
                .addToEstimateClick()
                .computeEngineClick()
                .fillComputeEngineForm(computeEngine.getNumberOfInstances(), computeEngine.getOperationSystemSoftware(),
                        computeEngine.getProvisioningModel(), computeEngine.getMachineFamily(), computeEngine.getSeries(),
                        computeEngine.getMachineTypeSetUp(), computeEngine.getLocalSSD(), computeEngine.getDatacenterLocation(),
                        computeEngine.getCommittedUsage(), computeEngine.isAddGPUs(), computeEngine.getGPUType(), computeEngine.getNumberOfGPUs())
                .waitForCostEvaluation(computeEngine.getCost())
                .openEstimateShare()
                .openEstimateSummary()
                .switchToNewWindow()
                .checkCommittedUsage(computeEngine.getCommittedUsage())
                .checkCostEstimateSummary(computeEngine.getCost())
                .checkDatacenterLocation(computeEngine.getDatacenterLocation())
                .checkGPUModel(computeEngine.getGPUType())
                .checkLocalSSD(computeEngine.getLocalSSD())
                .checkMachineType(computeEngine.getMachineType())
                .checkNumberOfGPUs(String.valueOf(computeEngine.getNumberOfGPUs()))
                .checkProvisioningModel(computeEngine.getProvisioningModel())
                .checkOperationSystemSoftware(computeEngine.getOperationSystemSoftware())
                .checkNumberOfInstances(String.valueOf(computeEngine.getNumberOfInstances()));
    }
}
