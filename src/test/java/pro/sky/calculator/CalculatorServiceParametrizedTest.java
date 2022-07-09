package pro.sky.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceParametrizedTest {

    CalculatorService calc = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForPlusOperationTests")
    void correctPlusOperationWorkTests(int firstVar, int secondVar, int result) {
        assertEquals(calc.plus(firstVar,secondVar), result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusOperationTests")
    void correctMinusOperationWorkTests(int firstVar, int secondVar, int result) {
        assertEquals(calc.minus(firstVar,secondVar), result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyOperationTests")
    void correctMultiplyOperationWorkTests(int firstVar, int secondVar, int result) {
        assertEquals(calc.multiply(firstVar,secondVar), result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideOperationTests")
    void correctDivideOperationWorkTests(int firstVar, int secondVar, int result) {
        assertEquals(calc.divide(firstVar,secondVar), result);
    }

    @Test
    void correctDivideOnNullThrowExceptionTests() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }

    public static Stream<Arguments> provideParamsForPlusOperationTests() {
        return Stream.of(
                Arguments.of(2,3,5),
                Arguments.of(1,3,4)
        );
    }

    public static Stream<Arguments> provideParamsForMinusOperationTests() {
        return Stream.of(
                Arguments.of(3,3,0),
                Arguments.of(10,9,1)
        );
    }

    public static Stream<Arguments> provideParamsForMultiplyOperationTests() {
        return Stream.of(
                Arguments.of(3,3,9),
                Arguments.of(10,9,90)
        );
    }

    public static Stream<Arguments> provideParamsForDivideOperationTests() {
        return Stream.of(
                Arguments.of(6,3,2),
                Arguments.of(3,1,3)
        );
    }
}
