public interface WordCounter {
    String[] getSplitStrings(String input);
    int countWords(String text);
    double averageWordLength(String text);
}
