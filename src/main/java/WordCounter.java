import java.util.regex.Pattern;

public class WordCounter {
    private static final String wordDefinition = "[a-zA-Z]+";

    private String[] getSplitStrings(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        return input.split("\\s+");
    }

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
}
