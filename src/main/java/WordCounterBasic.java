import java.util.regex.Pattern;

public class WordCounterBasic implements WordCounter {
    protected static final String wordDefinition = "[a-zA-Z-]+";

    @Override
    public String[] getSplitStrings(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        return input.split("[\\s.]+");
    }

    @Override
    public int countWords(String text) {
        int wordCount = 0;
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (!s.isEmpty() && matches) {
                wordCount++;
            }
        }
        return wordCount;
    }

    @Override
    public double averageWordLength(String text) {
        int numberOfWords = 0;
        int totalWordLength = 0;
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (!s.isEmpty() && matches) {
                numberOfWords++;
                totalWordLength += s.length();
            }
        }
        return ((double) totalWordLength / (double) numberOfWords);
    }
}
