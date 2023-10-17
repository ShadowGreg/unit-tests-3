package seminars.third.hw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MainHWTest {
    private final MainHW mainHW = new MainHW();

    @Test
    @DisplayName("Проверка метода evenOddNumber с четным числом")
    public void testEvenOddNumberWhenEvenThenTrue() {
        // Arrange
        int input = 2;

        // Act
        boolean result = mainHW.evenOddNumber(input);

        // Assert
        assertTrue(result, "Ожидаемое истинное значение для четного числа");
    }

    @Test
    @DisplayName("Проверка метода evenOddNumber с нечетным числом")
    public void testEvenOddNumberWhenOddThenFalse() {
        // Arrange
        int input = 3;

        // Act
        boolean result = mainHW.evenOddNumber(input);

        // Assert
        assertFalse(result, "Ожидаемое false для нечетного числа");
    }

    @Test
    @DisplayName("Проверка метода evenOddNumber с нулем")
    public void testEvenOddNumberWhenZeroThenTrue() {
        // Arrange
        int input = 0;

        // Act
        boolean result = mainHW.evenOddNumber(input);

        // Assert
        assertTrue(result, "Ожидаемое значение true для нуля");
    }

    @Test
    @DisplayName("Тест метода isInRange с числом в пределах диапазона")
    public void testIsInRangeWhenNumberIsWithinRangeThenReturnTrue() {
        // Arrange
        MainHW mainHW = new MainHW();
        int number = 50;

        // Act
        boolean result = MainHW.isInRange(number);

        // Assert
        assertTrue(result, "Ожидалось, что isInRange вернет true, когда число находится в пределах диапазона");
    }

    @Test
    @DisplayName("Тест метода isInRange с числом вне диапазона")
    public void testIsInRangeWhenNumberIsOutsideRangeThenReturnFalse() {
        // Arrange
        MainHW mainHW = new MainHW();
        int number = 101;

        // Act
        boolean result = MainHW.isInRange(number);

        // Assert
        assertFalse(result, "Ожидалось, что isInRange вернет false, когда число находится вне диапазона");
    }

    @Test
    @DisplayName("Тест метода isInRange с числом, равным нижней границе")
    public void testIsInRangeWhenNumberIsEqualToLowerBoundThenReturnFalse() {
        // Arrange
        MainHW mainHW = new MainHW();
        int number = 25;

        // Act
        boolean result = MainHW.isInRange(number);

        // Assert
        assertFalse(result, "Ожидалось, что isInRange вернет false, когда число равно нижней границе диапазона");
    }

    @Test
    @DisplayName("Тест метода isInRange с числом, равным верхней границе")
    public void testIsInRangeWhenNumberIsEqualToUpperBoundThenReturnFalse() {
        // Arrange
        MainHW mainHW = new MainHW();
        int number = 100;

        // Act
        boolean result = MainHW.isInRange(number);

        // Assert
        assertFalse(result, "Ожидалось, что isInRange вернет false, когда число равно верхней границе диапазона");
    }
}
