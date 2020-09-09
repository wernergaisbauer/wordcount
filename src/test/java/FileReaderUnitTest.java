import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FileReaderUnitTest {
    @Test
    public void TestReadText() {
        String text = FileReader.readFile("./src/test/resources/mytextfortest.txt");
        assertEquals("Mary had\na little\nlamb", text);
    }

    @Test
    public void TestReadTextFail() {
        String text = FileReader.readFile("./src/test/resources/abc.txt");
        assertNull(text);
    }
}
