import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounterStopWords extends WordCounterBasic {
    protected String[] stopWords;

    public void initStopWords() {
        String text = FileReader.readFile("./src/main/resources/stopwords.txt");
        stopWords = getSplitStrings(text);
    }

    @Override
    public int countWords(String text) {
        initStopWords();
        int wordCount = 0;
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (!s.isEmpty() && matches && !Arrays.asList(stopWords).contains(s)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    @Override
    public double averageWordLength(String text) {
        initStopWords();
        int numberOfWords = 0;
        int totalWordLength = 0;
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (!s.isEmpty() && matches && !Arrays.asList(stopWords).contains(s)) {
                numberOfWords++;
                totalWordLength += s.length();
            }
        }
        return ((double) totalWordLength / (double) numberOfWords);
    }
}
