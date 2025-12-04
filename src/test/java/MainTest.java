import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @Disabled("Тест пройден за 20 секунд. Отключен что-бы не занимал время при запуске всех тестов.")
    @DisplayName("The Main test checks that the main method runs for no longer than 22 seconds test disabled")
    void theMainTestChecksThatTheMainMethodRunsForNoLongerThan22SecondsTestDisabled() {
        String[] arguments = {"arg1", "arg2", "timeout_test"};
        assertTimeout(
                ofSeconds(22), () -> Main.main(arguments)
        );
    }

}