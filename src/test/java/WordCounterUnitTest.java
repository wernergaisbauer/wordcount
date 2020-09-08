import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterUnitTest {
    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounter();
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
}
