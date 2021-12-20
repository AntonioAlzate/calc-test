package co.com.sofka.app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BasicCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);
    public static final String ERROR_DIVISION = "No es posible dividir entre cero";

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long res(Long number1, Long number2) {
        logger.info( "resting {} - {}", number1, number2 );
        return number1 - number2;
    }

    public Long mult(Long number1, Long number2) {
        logger.info( "multiplying {} * {}", number1, number2 );
        return number1 * number2;
    }

    public Long div(Long number1, Long number2) throws IOException {
        logger.info( "Dividing {} / {}", number1, number2 );

        if(number2 == 0){
            logger.info(ERROR_DIVISION);
            throw new IOException(ERROR_DIVISION);
        }

        return number1 / number2;
    }

}
