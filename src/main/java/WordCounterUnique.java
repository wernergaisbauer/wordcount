import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class WordCounterUnique extends WordCounterStopWords {
    private Map<String, Integer> words = new HashMap<>();

    public int countWords(String text) {
        initStopWords();
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (!s.isEmpty() && matches && !Arrays.asList(stopWords).contains(s)) {
                Integer numberOfOccurances = words.get(s);
                if (numberOfOccurances != null) {
                    words.put(s, numberOfOccurances + 1);
                } else {
                    words.put(s, 1);
                }
            }
        }
        return words.entrySet().size();
    }
}
