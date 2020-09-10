import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCounterUniqueWordsUnitTest {
    private WordCounterUnique wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounterUnique();
    }

    @Test
    public void TestHumpty() {
        assertEquals(6, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
    }

    @Test
    public void TestMary() {
        assertEquals(4, wordCounter.countWords("Mary had a little lamb"));
    }

    @Test
    public void TestMaryDouble() {
        assertEquals(4, wordCounter.countWords("Mary had a little lamb Mary had a little lamb"));
    }

    @Test
    public void TestRandom() {
        assertEquals(5, wordCounter.countWords("a b c d e f. a b c d e f."));
    }

    @Test
    public void TestRandomDash() {
        assertEquals(6, wordCounter.countWords("a-b-c-d-e-f. a b c d e f."));
    }

    @Test
    public void TestRandomDashMultiple() {
        assertEquals(4, wordCounter.countWords("a-b-c-d-e-f. a-b c-d-e f."));
    }

    @Test
    public void TestRandomDashMultipleWithSpaces() {
        assertEquals(3, wordCounter.countWords("   abc a-b-c c abc   "));
    }

    @Test
    public void TestWithEmptyString() {
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void TestIndexMary() {
        List<String> index = Arrays.asList("had", "lamb", "little", "Mary");
        assertEquals(index, wordCounter.index("Mary had a little lamb"));
    }

    @Test
    public void TestIndexHumpty() {
        List<String> index = Arrays.asList("fall", "great", "had", "Humpty-Dumpty", "sat", "wall");
        assertEquals(index, wordCounter.index("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
    }
}
