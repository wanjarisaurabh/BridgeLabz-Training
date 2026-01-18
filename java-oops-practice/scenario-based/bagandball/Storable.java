package com.scenariobasedquestion.bagandball;

/**
 * Interface defining Storable behavior
 * Both Bag and Ball can be stored and have common attributes
 */
public interface Storable {
    
    /**
     * Gets the unique identifier
     * @return ID as String
     */
    String getId();
    
    /**
     * Gets the color
     * @return Color as String
     */
    String getColor();
    
    /**
     * Displays information about the storable item
     */
    void displayInfo();
}
