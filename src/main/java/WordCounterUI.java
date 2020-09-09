import java.util.Scanner;

public class WordCounterUI {
    private WordCounter wordCounter = new WordCounterBasic();
//    private WordCounter wordCounter = new WordCounterStopWords();

    public static void main(String[] args) {
        WordCounterUI wordCounterInterface = new WordCounterUI();
        wordCounterInterface.countWordsFromCLI();
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
