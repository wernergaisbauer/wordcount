import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// TODO: implement interface
public class FileReader {
    public static String readFile(String name) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
