package com.scenariobasedquestion.parkease;

/**
 * Interface for calculating parking charges
 */
public interface IPayable {
    double calculateCharges(int duration);
}
