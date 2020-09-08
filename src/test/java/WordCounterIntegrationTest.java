import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

public class WordCounterIntegrationTest {

    @Test
    public void TestMainMethod() {
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
        assertEquals("Enter text: \n" + "Number of words: 5\n", s);
    }
}
