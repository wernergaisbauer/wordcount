import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

public class WordCounterIntegrationTest {

    @Test
    public void TestMainMethodCountWordsFromCLI() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream bais = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(bais);
        PrintStream sysOutBackup = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        WordCounterUI.main(null);
        System.setIn(sysInBackup);
        System.out.flush();
        System.setOut(sysOutBackup);
        String s = new String(baos.toByteArray(), Charset.defaultCharset());
        assertEquals("Enter text: \n" +
                "Number of words: 4, unique: 4; average word length: 4.25\n", s);
    }

    @Test
    public void TestMainMethodCountWordsFromFile() {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        WordCounterUI.main(new String[]{"humpty.txt"});
        System.out.flush();
        System.setOut(old);
        String s = new String(baos.toByteArray(), Charset.defaultCharset());
        assertEquals("Number of words: 7, unique: 6; average word length: 6.43\n", s);
    }

    @Test
    public void TestMainMethodCountWordsFromCLIWithIndex() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream bais = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(bais);
        PrintStream sysOutBackup = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        WordCounterUI.main(new String[]{"-index"});
        System.setIn(sysInBackup);
        System.out.flush();
        System.setOut(sysOutBackup);
        String s = new String(baos.toByteArray(), Charset.defaultCharset());
        assertEquals("Enter text: \n" +
                "Number of words: 4, unique: 4; average word length: 4.25\n" +
                "Index:\n" +
                "had\n" +
                "lamb\n" +
                "little\n" +
                "Mary\n", s);
    }
}
