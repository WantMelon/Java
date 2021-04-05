package task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void firstComparatorTest() {
        String[] arr = {"string", "test", "first", "кто тут?"};
        Arrays.sort(arr, new FirstComparator("t"));
        assertEquals(
                "[test, string, first, кто тут]",
                Arrays.toString(arr)
        );
    }
}