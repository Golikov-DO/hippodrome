import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HippodromeTest {
    @Test
    @DisplayName("Test Hippodrome constructor with null parameter only Exception")
    void testHippodromeConstructorWithNullParameterOnlyException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));
    }

    @Test
    @DisplayName("Test Hippodrome constructor with null parameter Exception with message")
    void testHippodromeConstructorWithNullParameterExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Hippodrome constructor with empty list parameter only Exception")
    void testHippodromeConstructorWithEmptyListParameterOnlyException() {
        List<Horse> list = List.of();
        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(list));
    }

    @Test
    @DisplayName("Test Hippodrome constructor with empty list parameter Exception with message")
    void testHippodromeConstructorWithEmptyListParameterExceptionWithMessage() {
        List<Horse> list = List.of();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(list));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Test the Hippodrome method getHorse that should returns a list that contains the same objects and in the same order as the list that was passed to the constructor.")
    void testTheHippodromeMethodGetHorseThatShouldReturnsAListThatContainsTheSameObjectsAndInTheSameOrderAsTheListThatWasPassedToTheConstructor() {
        List<Horse> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Horse("Name" + i, Math.random() * 0.5 + 2.5));
        }
        Hippodrome hippodrome = new Hippodrome(list);
        List<Horse> hippodromeList = hippodrome.getHorses();
        assertEquals(list, hippodromeList);
    }

    @Test
    @DisplayName("Test the Hippodrome move method that should call the move method on all horses.")
    void testTheHippodromeMoveMethodThatShouldCallTheMoveMethodOnAllHorses() {
        List<Horse> mockList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mockList.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(mockList);
        hippodrome.move();
        for (Horse movebleHorse : mockList) {
            verify(movebleHorse, times(1)).move();
        }
    }

    @Test
    @DisplayName("Test the Hippodrome getWinner method that should return the horse with the highest distance value")
    void testTheHippodromeGetWinnerMethodThatShouldReturnTheHorseWithTheHighestDistanceValue() {
        List<Horse> horseList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horseList.add(new Horse("Name" + i, Math.random() * 0.5 + 2.5));
        }
        Hippodrome hippodrome = new Hippodrome(horseList);
        hippodrome.move();
        Horse winnerHorse = hippodrome.getWinner();
        double distance = winnerHorse.getDistance();
        for (Horse horseWithHighestDistance : horseList) {
            assertTrue(distance >= horseWithHighestDistance.getDistance());
        }
    }
}