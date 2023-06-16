import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTests {
    Calculator calculator = new Calculator();

    @Test
    public void plusTest() {
        //given
        int expected = 3, a = 1, b = 2;

        //act
        int result = calculator.plus.apply(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void powTest(int number, int expected) {
        //act
        int result = calculator.pow.apply(number);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(2, 4),
                Arguments.of(-4, 16),
                Arguments.of(5, 25)
        );
    }

    @Test
    public void divideTest() {
        //given
        int a = 2, b = 1;

        //act
        int result = calculator.devide.apply(a, b);
        Executable executable = () -> calculator.devide.apply(a, b);

        //assert
        Assertions.assertDoesNotThrow(executable);
    }
}