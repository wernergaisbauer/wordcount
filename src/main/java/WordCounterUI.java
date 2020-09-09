import java.util.Scanner;

public class WordCounterUI {
    private WordCounter wordCounter = new WordCounterStopWords();

    public static void main(String[] args) {
        WordCounterUI wordCounterInterface = new WordCounterUI();
        if (args != null && args.length > 0 && args[0] != null) {
            wordCounterInterface.countWordsFromFile(args[0]);
        } else {
            wordCounterInterface.countWordsFromCLI();
        }
    }

    private void countWordsFromFile(String fileName) {
        String text = FileReader.readFile("./src/main/resources/" + fileName);
        int wordCount = wordCounter.countWords(text);
        System.out.println("Number of words: " + wordCount);
    }

    private void countWordsFromCLI() {
        String text = readTextFromCLI();
        int wordCount = wordCounter.countWords(text);
        System.out.println("Number of words: " + wordCount);
    }

    private String readTextFromCLI() {
        String text;
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        text = scanner.nextLine();
        return text;
    }
}
