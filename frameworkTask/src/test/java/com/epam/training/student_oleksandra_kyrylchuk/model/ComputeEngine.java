package com.epam.training.student_oleksandra_kyrylchuk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ComputeEngine {

    private int numberOfInstances;
    private String operationSystemSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String GPUType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    private String cost;
    private String machineTypeSetUp;

}
