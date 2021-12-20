package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing res 2-1=1")
    public void res() {
        // Arrange
        Long number1 = 2L;
        Long number2 = 1L;
        Long expectedValue = 1L;

        // Act
        Long result = basicCalculator.res(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several res")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1,    1,   0",
            "1,    2,   -1",
            "52,  2, 50",
            "100,  1, 99"
    })
    public void severalRests(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.res(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing res 5*2=10")
    public void mult() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 2L;
        Long expectedValue = 10L;

        // Act
        Long result = basicCalculator.mult(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several mult")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "1,    1,   1",
            "10,    2,   20",
            "52,  -2, -104",
            "100,  5, 500"
    })
    public void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mult(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing div 20/5=4")
    public void div() throws IOException {
        // Arrange
        Long number1 = 20L;
        Long number2 = 5L;
        Long expectedValue = 4L;

        // Act
        Long result = basicCalculator.div(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several res")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "1,    1,   1",
            "20,    2,   10",
            "50,  2, 25",
            "100,  10, 10"
    })
    public void severalDivs(Long first, Long second, Long expectedResult) throws IOException {
        assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing div 20/0 throws Exception")
    public void divCeroError() throws IOException {
        // Arrange
        Long number1 = 20L;
        Long number2 = 0L;

        assertThrows(IOException.class,() ->basicCalculator.div(number1, number2));
    }

}