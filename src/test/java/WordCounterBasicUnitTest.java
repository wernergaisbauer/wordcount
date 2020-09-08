import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterBasicUnitTest {
    private WordCounterBasic wordCounterBasic;

    @Before
    public void init() {
        wordCounterBasic = new WordCounterBasic();
    }

    @Test
    public void TestWithFiveWords() {
        assertEquals(5, wordCounterBasic.countWords("Mary had a little lamb"));
    }

    @Test
    public void TestWithEmptyString() {
        assertEquals(0, wordCounterBasic.countWords(""));
    }

    @Test
    public void TestWithSingleCharacters() {
        assertEquals(5, wordCounterBasic.countWords("a b c d e     $     ?"));
    }

    @Test
    public void TestWithSingleCharactersAndSpacesAround() {
        assertEquals(5, wordCounterBasic.countWords("     a b c d e     $     ?    "));
    }

    @Test
    public void TestWithNonWords() {
        assertEquals(0, wordCounterBasic.countWords("73374 23782"));
    }
}
