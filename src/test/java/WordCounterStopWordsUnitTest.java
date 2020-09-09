import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterStopWordsUnitTest {
    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounterStopWords();
    }

    @Test
    public void TestWithStopword() {
        assertEquals(4, wordCounter.countWords("Mary had a little lamb"));
    }

    @Test
    public void TestWithTwoStopwords() {
        assertEquals(4, wordCounter.countWords("Mary had a little lamb on"));
    }

    @Test
    public void TestWithNoStopwords() {
        assertEquals(4, wordCounter.countWords("Mary had little lamb"));
    }

    @Test
    public void TestWithJustStopwords() {
        assertEquals(0, wordCounter.countWords("the a on off"));
    }

    @Test
    public void TestWithStopwords() {
        assertEquals(5, wordCounter.countWords("the a on off my name is James Bond a"));
    }

    @Test
    public void TestWithEmptyString() {
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void TestAverageWordLength() {
        assertEquals(4.25, wordCounter.averageWordLength("Mary had a little lamb"), 0.01);
    }

    @Test
    public void TestAverageWordLengthHumpty() {
        assertEquals(6.42, wordCounter.averageWordLength("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), 0.01);
    }
}
