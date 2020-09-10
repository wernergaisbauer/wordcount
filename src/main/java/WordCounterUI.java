import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WordCounterUI {
    private WordCounter wordCounterStop = new WordCounterStopWords();
    private WordCounterUnique wordCounterUnique = new WordCounterUnique();

    public static void main(String[] args) {
        WordCounterUI wordCounterInterface = new WordCounterUI();
        if (args != null && args.length > 0 && args[0] != null) {
            if (Arrays.asList(args).contains("-index")) {
                Optional<String> optional = Arrays.stream(args).filter(arg -> arg.contains("-dictionary")).findFirst();
                if (optional.isPresent()) {
                    String[] split = optional.get().split("-dictionary=");
                    if (split.length > 1) {
                        wordCounterInterface.countWordsFromCLIWithIndexAndDictionary(split[1]);
                    }
                } else {
                    wordCounterInterface.countWordsFromCLIWithIndex();
                }
            } else {
                wordCounterInterface.countWordsFromFile(args[0]);
            }
        } else {
            wordCounterInterface.countWordsFromCLI();
        }
    }

    private void countAndPrintMetrics(String text) {
        int wordCountStop = wordCounterStop.countWords(text);
        int wordCountUnique = wordCounterUnique.countWords(text);
        double averageWordLength = wordCounterStop.averageWordLength(text);
        DecimalFormat df = new DecimalFormat("#.##");
        averageWordLength = Double.parseDouble(df.format(averageWordLength));
        System.out.println("Number of words: " + wordCountStop + ", unique: " + wordCountUnique + "; average word length: " + averageWordLength);
    }

    private void printIndex(String text) {
        List<String> index = wordCounterUnique.index(text);
        System.out.println("Index:");
        for (String word : index) {
            System.out.println(word);
        }
    }

    private void printIndexDictionary(String text, String dictionaryFileName) {
        IndexData indexData = wordCounterUnique.indexDictionary(text, dictionaryFileName);
        System.out.println("Index (unknown: " + indexData.getUnkownWords() + "):");
        for (String word : indexData.getIndex()) {
            System.out.println(word);
        }
    }

    private void countWordsFromFile(String fileName) {
        String text = FileReader.readFile("./src/main/resources/" + fileName);
        countAndPrintMetrics(text);
    }

    private void countWordsFromCLI() {
        String text;
        text = readTextFromCLI();
        while (text != null && !text.isEmpty()) {
            countAndPrintMetrics(text);
            text = readTextFromCLI();
        }
    }

    private void countWordsFromCLIWithIndex() {
        String text;
        text = readTextFromCLI();
        while (text != null && !text.isEmpty()) {
            countAndPrintMetrics(text);
            printIndex(text);
            text = readTextFromCLI();
        }
    }

    private void countWordsFromCLIWithIndexAndDictionary(String dictionaryFileName) {
        String text;
        text = readTextFromCLI();
        while (text != null && !text.isEmpty()) {
            countAndPrintMetrics(text);
            printIndexDictionary(text, dictionaryFileName);
            text = readTextFromCLI();
        }
    }

    private String readTextFromCLI() {
        String text;
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        return text;
    }
}
