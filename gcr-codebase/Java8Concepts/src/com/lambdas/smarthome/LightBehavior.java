package com.lambdas.smarthome;

// Functional interface for light activation behavior
@FunctionalInterface
public interface LightBehavior {
    // single abstract method - defines what pattern to apply
    void activate(String trigger);
}