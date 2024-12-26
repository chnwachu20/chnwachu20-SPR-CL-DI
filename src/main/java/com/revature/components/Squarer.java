package com.revature.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The current functionality of the Application requires the "Squarer" class to be retrieved from the Application
 * Context - which you can think of as the current pool of usable Spring Beans.
 */
@Component
public class Squarer {
    /**
     * TODO: Inject this field
     */
    Multiplier multiplier;

    /**
     * Leverage the Multiplier dependency to multiply a value with itself.
     * This will only work if Multiplier was successfully autowired into this class.
     * @param value some number
     * @return value^2
     */
    public double getSquare(double value){
        return multiplier.multiply(value, value);
    }
}