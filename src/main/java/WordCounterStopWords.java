import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounterStopWords extends WordCounterBasic {
    private String[] stopWords;

    public void initStopWords() {
        String text = FileReader.readFile("./src/main/resources/stopwords.txt");
        stopWords = getSplitStrings(text);
    }

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
}
