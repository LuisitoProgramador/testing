import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
    private Calculator calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Test addition of two numbers")
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0));
    }
    
    @Test
    @DisplayName("Test subtraction of two numbers")
    public void testSubtract() {
        assertEquals(1.0, calculator.subtract(3.0, 2.0));
    }
    
    @Test
    @DisplayName("Test multiplication of two numbers")
    public void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0));
    }
    
    @Test
    @DisplayName("Test division of two numbers")
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0));
    }
    
    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6.0, 0.0));
    }
    
    @Test
    @DisplayName("Test if number is even")
    public void testIsEven() {
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(5));
    }
    
    @Test
    @DisplayName("Test absolute value")
    public void testAbsoluteValue() {
        assertEquals(5, calculator.absoluteValue(-5));
        assertEquals(5, calculator.absoluteValue(5));
    }
    
    @Test
    @DisplayName("Test average of a list of numbers")
    public void testAverage() {
        List<Double> numbers = Arrays.asList(2.0, 4.0, 6.0);
        assertEquals(4.0, calculator.average(numbers));
    }
    
    @Test
    @DisplayName("Test empty list for average")
    public void testAverageEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(Arrays.asList()));
        
    }
    
    @Test
    @DisplayName("Test maximum of a list of numbers")
    public void testMaximum() {
        List<Double> numbers = Arrays.asList(2.0, 4.0, 6.0);
        assertEquals(6.0, calculator.maximum(numbers));
    }
    
    @Test
    @DisplayName("Test minimum of a list of numbers")
    public void testMinimum() {
        List<Double> numbers = Arrays.asList(2.0, 4.0, 6.0);
        assertEquals(2.0, calculator.minimum(numbers));
        
    }
    
}
