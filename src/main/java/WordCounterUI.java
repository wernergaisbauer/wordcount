import java.util.Scanner;

public class WordCounterUI {
    private WordCounter wordCounterStop = new WordCounterStopWords();
    private WordCounter wordCounterUnique = new WordCounterUnique();

    public static void main(String[] args) {
        WordCounterUI wordCounterInterface = new WordCounterUI();
        if (args != null && args.length > 0 && args[0] != null) {
            wordCounterInterface.countWordsFromFile(args[0]);
        } else {
            wordCounterInterface.countWordsFromCLI();
        }
    }

    private void countAndPrintMetrics(String text) {
        int wordCountStop = wordCounterStop.countWords(text);
        int wordCountUnique = wordCounterUnique.countWords(text);
        System.out.println("Number of words: " + wordCountStop + ", unique: " + wordCountUnique);
    }

    private void countWordsFromFile(String fileName) {
        String text = FileReader.readFile("./src/main/resources/" + fileName);
        countAndPrintMetrics(text);
    }

    private void countWordsFromCLI() {
        String text = readTextFromCLI();
        countAndPrintMetrics(text);
    }

    private String readTextFromCLI() {
        String text;
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        return text;
    }
}
