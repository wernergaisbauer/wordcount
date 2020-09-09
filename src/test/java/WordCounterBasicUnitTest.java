import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterBasicUnitTest {
    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounterBasic();
    }

    @Test
    public void TestWithFiveWords() {
        assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
    }

    @Test
    public void TestWithEmptyString() {
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void TestWithSingleCharacters() {
        assertEquals(5, wordCounter.countWords("a b c d e     $     ?"));
    }

    @Test
    public void TestWithSingleCharactersAndSpacesAround() {
        assertEquals(5, wordCounter.countWords("     a b c d e     $     ?    "));
    }

    @Test
    public void TestWithNonWords() {
        assertEquals(0, wordCounter.countWords("73374 23782"));
    }

    @Test
    public void TestWithWordsAndNonWords() {
        assertEquals(2, wordCounter.countWords("James Bond 73374 23782"));
    }

    @Test
    public void TestAverageWordLength() {
        assertEquals(3.6, wordCounter.averageWordLength("Mary had a little lamb"), 0.01);
    }
}
