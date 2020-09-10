import java.util.*;
import java.util.regex.Pattern;

public class WordCounterUnique extends WordCounterStopWords {

    private Map<String, Integer> getUniqueWords(String text) {
        Map<String, Integer> words = new HashMap<>();
        initStopWords();
        String[] split = getSplitStrings(text);
        if (split == null) return null;
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
        return words;
    }

    @Override
    public int countWords(String text) {
        Map<String, Integer> uniqueWords = getUniqueWords(text);
        if (uniqueWords == null) return 0;
        return uniqueWords.entrySet().size();
    }

    public List<String> index(String text) {
        Map<String, Integer> uniqueWords = getUniqueWords(text);
        if (uniqueWords == null) return null;
        List<String> index = new ArrayList<>(uniqueWords.keySet());
        index.sort(String::compareToIgnoreCase);
        return index;
    }
}
