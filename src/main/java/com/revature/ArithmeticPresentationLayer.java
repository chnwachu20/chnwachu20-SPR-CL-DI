package com.revature;

import com.revature.components.Adder;
import com.revature.components.Multiplier;
import com.revature.components.Squarer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * To show off how dependency injection works, this class
 * uses the Adder, Multiplier, and Squarer classes to
 * perform mathematical operations and return the results
 * as strings.
 *
 * The @Autowired annotation is used to inform Spring to automatically find the most appropriate bean to wire into this
 * class (based on the name & type of the Object used). 
 * Here, we demonstrate dependency injection using:
 * - Constructor injection for Squarer.
 * - Setter injection for Multiplier.
 * - Field injection for Adder.
 */
@ComponentScan(basePackages = "com.revature.components")
@Component
public class ArithmeticPresentationLayer {
    // Field injection for Adder
    @Autowired
    private Adder adder;

    // Setter injection for Multiplier
    private Multiplier multiplier;

    // Constructor injection for Squarer
    private final Squarer squarer;

    @Autowired
    public ArithmeticPresentationLayer(Squarer squarer) {
        this.squarer = squarer;
    }

    @Autowired
    public void setMultiplier(Multiplier multiplier) {
        this.multiplier = multiplier;
    }

    public static void main(String[] args) {
        // Create the Spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(ArithmeticPresentationLayer.class);

        // Retrieve the ArithmeticPresentationLayer bean from the container
        ArithmeticPresentationLayer app = context.getBean(ArithmeticPresentationLayer.class);

        // Example usage
        System.out.println(app.addConvertToString(3, 4));      // The result of 3.0 + 4.0 is 7.0
        System.out.println(app.multiplyConvertToString(3, 4)); // The result of 3.0 * 4.0 is 12.0
        System.out.println(app.squareConvertToString(5));      // The result of 5.0 squared is 25.0
    }

    /**
     * @param a - number 1
     * @param b - number 2
     * @return the addition operation as a String, see tests for specific formatting
     */
    public String addConvertToString(double a, double b) {
        return String.format("The result of %.1f + %.1f is %.1f", a, b, adder.add(a, b));
    }

    /**
     * @param a - number 1
     * @param b - number 2
     * @return the multiplication operation as a String, see tests for specific formatting
     */
    public String multiplyConvertToString(double a, double b) {
        return String.format("The result of %.1f * %.1f is %.1f", a, b, multiplier.multiply(a, b));
    }

    /**
     * @param a - number 1
     * @return the square operation as a String, see tests for specific formatting
     */
    public String squareConvertToString(double a) {
        return String.format("The result of %.1f squared is %.1f", a, squarer.getSquare(a));
    }
}
