package task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void firstComparatorTest() {
        String[] actual = {"string", "test", "first", "кто тут?"};
        String[] expected = {"кто тут?", "string", "test", "first"};
        Arrays.sort(actual, new FirstComparator("t"));
        assertArrayEquals(
                expected,
                actual
        );
    }

    @Test
    void secondCompareTest() {
        String[] actual = {"favail", "sssss", "agufadodolas"};
        String[] expected = {"agufadodolas", "favail", "sssss"};
        Arrays.sort(actual, new SecondComparator("fa", "l"));
        assertArrayEquals(
                expected,
                actual
        );
    }

    @Test
    void parseStringTest() {
        String string = "1 2 3, 4 a5a 6 789 0";
        assertEquals(
                "one two three, four a5a six 789 zero",
                task2.Main.parseString(string)
        );
    }
}