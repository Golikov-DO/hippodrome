import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    double speed = 1.0;
    double acceleration = 1.0;
    String name = "test";

    @Test
    @DisplayName("Test Horse constructor with null first parameter only Exception")
    void testHorseConstructorWithNullFirstParameterOnlyException() {
        assertThrows(IllegalArgumentException.class,
            () -> new Horse(null,speed,acceleration));
    }

    @Test
    @DisplayName("Test Horse constructor with null first parameter Exception with message")
    void testHorseConstructorWithNullFirstParameterExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null,speed,acceleration));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "   "})
    @DisplayName("Test Horse constructor with empty line or whitespace characters first parameter only Exception")
    void testHorseConstructorWithEmptyLineOrWhitespaceCharactersFirstParameterOnlyException(String whitespace) {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(whitespace,speed,acceleration));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "   "})
    @DisplayName("Test Horse constructor with empty line or whitespace characters first parameter Exception with message")
    void testHorseConstructorWithEmptyLineOrWhitespaceCharactersFirstParameterExceptionWithMessage(String whitespace) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(whitespace,speed,acceleration));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Horse constructor with second parameter negative number only Exception")
    void testHorseConstructorWithSecondParameterNegativeNumberOnlyException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(name,-1 * speed,acceleration));
    }

    @Test
    @DisplayName("Test Horse constructor with second parameter negative number Exception with message")
    void testHorseConstructorWithSecondParameterNegativeNumberExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, -1 * speed,acceleration));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Horse constructor with third parameter negative number only Exception")
    void testHorseConstructorWithThirdParameterNegativeNumberOnlyException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, speed,- 1 * acceleration));
    }

    @Test
    @DisplayName("Test Horse constructor with third parameter negative number Exception with message")
    void testHorseConstructorWithThirdParameterNegativeNumberExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, speed, -1 * acceleration));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }
}