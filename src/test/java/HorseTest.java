import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    String name = "test";
    double speed = 1.0;
    double distance = 1.0;
    
    @Test
    @DisplayName("Test Horse constructor with null first parameter only Exception")
    void testHorseConstructorWithNullFirstParameterOnlyException() {
        assertThrows(IllegalArgumentException.class,
            () -> new Horse(null,speed, distance));
    }

    @Test
    @DisplayName("Test Horse constructor with null first parameter Exception with message")
    void testHorseConstructorWithNullFirstParameterExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null,speed, distance));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "   "})
    @DisplayName("Test Horse constructor with empty line or whitespace characters first parameter only Exception")
    void testHorseConstructorWithEmptyLineOrWhitespaceCharactersFirstParameterOnlyException(String whitespace) {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(whitespace,speed, distance));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "   "})
    @DisplayName("Test Horse constructor with empty line or whitespace characters first parameter Exception with message")
    void testHorseConstructorWithEmptyLineOrWhitespaceCharactersFirstParameterExceptionWithMessage(String whitespace) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(whitespace,speed, distance));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Horse constructor with second parameter negative number only Exception")
    void testHorseConstructorWithSecondParameterNegativeNumberOnlyException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(name,-1 * speed, distance));
    }

    @Test
    @DisplayName("Test Horse constructor with second parameter negative number Exception with message")
    void testHorseConstructorWithSecondParameterNegativeNumberExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, -1 * speed, distance));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Horse constructor with third parameter negative number only Exception")
    void testHorseConstructorWithThirdParameterNegativeNumberOnlyException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, speed,- 1 * distance));
    }

    @Test
    @DisplayName("Test Horse constructor with third parameter negative number Exception with message")
    void testHorseConstructorWithThirdParameterNegativeNumberExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, speed, -1 * distance));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test get the name which is equal to the first parameter of the constructor ")
    void testGetTheNameWhichIsEqualToTheFirstParameterOfTheConstructor() {
        Horse horse = new Horse(name, speed, distance);
        assertEquals(name, horse.getName());
    }

    @Test
    @DisplayName("Test get a number that is equal to the second parameter of the constructor")
    void testGetANumberThatIsEqualToTheSecondParameterOfTheConstructor() {
        Horse horse = new Horse(name, speed, distance);
        assertEquals(speed, horse.getSpeed());
    }

    @Test
    @DisplayName("Test get a number that is equal to the third parameter of the constructor")
    void testGetANumberThatIsEqualToTheThirdParameterOfTheConstructor() {
        Horse horse = new Horse(name, speed, distance);
        assertEquals(distance, horse.getDistance());
    }

    @Test
    @DisplayName("Test get zero in distance if two parameters are passed to the constructor ")
    void testGetZeroInDistanceIfTwoParametersArePassedToTheConstructor() {
        Horse horse = new Horse(name,speed);
        assertEquals(0, horse.getDistance());
    }

    @Test
    @DisplayName("Test to check that the method calls the getRandomDouble method internally with parameters 0.2 and 0.9")
    void testToCheckThatTheMethodCallsTheGetRandomDoubleMethodInternallyWithParameters02And09() {
        double expectedFirst = 0.2;
        double expectedSecond = 0.9;
        try (MockedStatic<Horse> mocked = mockStatic(Horse.class)) {
            Horse horse = new Horse(name,speed,distance);
            horse.move();
            mocked.verify(() -> Horse.getRandomDouble(eq(expectedFirst),eq(expectedSecond)),times(1));
        }
    }

    @ParameterizedTest
    @ValueSource (doubles = {0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9})
    @DisplayName("Test to check that the getRandomDouble method calculate new distance with parameters 0.2 and 0.9")
    void testToCheckThatTheGetRandomDoubleMethodCalculateNewDistanceWithParameters02And09(double expectedDistance) {
        Horse horse = new Horse(name,speed,distance);
        try (MockedStatic<Horse> mocked = mockStatic(Horse.class)) {
            mocked.when(() -> Horse.getRandomDouble(0.2,0.9)).thenReturn(expectedDistance);
            horse.move();
            double expectedResultDistance = distance + speed * Horse.getRandomDouble(0.2, 0.9);
            assertEquals(expectedResultDistance, horse.getDistance());
        }
    }
}