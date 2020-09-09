import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterUniqueWordsUnitTest {
    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounterUnique();
    }

    @Test
    public void TestHumpty() {
        assertEquals(7, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
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
        assertEquals(5, wordCounter.countWords("a-b-c-d-e-f. a b c d e f."));
    }

    @Test
    public void TestWithEmptyString() {
        assertEquals(0, wordCounter.countWords(""));
    }
}
